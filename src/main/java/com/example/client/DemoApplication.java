package com.example.client;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author emanuel.sousa
 *
 */


@Configuration
@SpringBootApplication
@EnableScheduling
public class DemoApplication { //implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

	@Value("${chave.gw.dev.app-key}")
	private String chaveDevAppKey;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Injetar o serviço de cliente autorizado API SANDBOX BB e o gerente de cliente autorizado da classe OAuthClientConfiguration
	@Autowired
	private AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceAndManager;

	/**
	@Override
	public void run(String... args) throws Exception {

		////////////////////////////////////////////////////
		//  ETAPA 1: Recupere o JWT autorizado
		////////////////////////////////////////////////////

		// Crie uma solicitação OAuth2 para o provedor API SANDBOX BB
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("sandboxbb")
			.principal("API SANDBOX BB")
			.build();

		// Execute a solicitação de autorização real usando o serviço de cliente autorizado e o cliente autorizado Gerente. 
		// É aqui que o JWT é recuperado dos servidores API SANDBOX BB.
		OAuth2AuthorizedClient authorizedClient = this.authorizedClientServiceAndManager.authorize(authorizeRequest);

		// Obtenha o token do objeto de cliente autorizado
		OAuth2AccessToken accessToken = Objects.requireNonNull(authorizedClient).getAccessToken();

		logger.info("Issued: " + accessToken.getIssuedAt().toString() + ", Expira:" + accessToken.getExpiresAt().toString());
		logger.info("Scopes: " + accessToken.getScopes().toString());
		logger.info("Token: " + accessToken.getTokenValue());

		////////////////////////////////////////////////////
		//  PASSO 2: Use o JWT e ligue para o serviço
		////////////////////////////////////////////////////

		// Adicione o JWT aos cabeçalhos RestTemplate
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken.getTokenValue());
		var request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String numeroConvenio = "78806";
		String codigoGuiaRecebimento = "83660000000199800053846101173758000000000008";

		var uri = "https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes" 
				+ "?gw-dev-app-key=" + chaveDevAppKey
				+ "&" 
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;
		
		logger.info("URI: {}", uri);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		String resultado = response.getBody();
		logger.info("Response: " + resultado);
		
	
	} **/

	
	/**
	 * GET https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes
	 * Rodar Job a cada 1 minuto
	 */
	@Scheduled(fixedRate = 60000)
	private void getArrecadacaoQrCodes() {
		
		// Crie uma solicitação OAuth2 para o provedor API SANDBOX BB
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("sandboxbb")
			.principal("API SANDBOX BB")
			.build();

		// Execute a solicitação de autorização real usando o serviço de cliente autorizado e o cliente autorizado Gerente. 
		// É aqui que o JWT é recuperado dos servidores API SANDBOX BB.
		OAuth2AuthorizedClient authorizedClient = this.authorizedClientServiceAndManager.authorize(authorizeRequest);

		// Obtenha o token do objeto de cliente autorizado
		OAuth2AccessToken accessToken = Objects.requireNonNull(authorizedClient).getAccessToken();

		logger.info("Issued: " + accessToken.getIssuedAt().toString() + ", Expira:" + accessToken.getExpiresAt().toString());
		logger.info("Scopes: " + accessToken.getScopes().toString());
		logger.info("Token: " + accessToken.getTokenValue());

		////////////////////////////////////////////////////
		//  PASSO 2: Use o JWT e ligue para o serviço
		////////////////////////////////////////////////////

		// Adicione o JWT aos cabeçalhos RestTemplate
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken.getTokenValue());
		var request = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();

		String numeroConvenio = "78806";
		String codigoGuiaRecebimento = "83660000000199800053846101173758000000000022";

		var uri = "https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes" 
				+ "?gw-dev-app-key=" + chaveDevAppKey
				+ "&" 
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;
		
		logger.info("URI: {}", uri);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		String resultado = response.getBody();
		logger.info("Response/Job: " + resultado);


	}
}
