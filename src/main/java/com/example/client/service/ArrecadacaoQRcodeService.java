package com.example.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.client.mapper.response.GuiaArrecadacaoQrCodeResponseDTO;
import com.example.client.utils.JSONUtil;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Service
public class ArrecadacaoQRcodeService {

	private static final Logger LOG = LoggerFactory.getLogger(ArrecadacaoQRcodeService.class);
	
	@Value("${chave.gw.dev.app-key}")
	private String chaveDevAppKey;
	
	@Value("${base.uri.sandbox-bb}")
	private String baseUriSandboxBB;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 
	 * @param numeroConvenio
	 * @param codigoGuiaRecebimento
	 * @return GuiaArrecadacaoQrCodeResponseDTO
	 */
	public GuiaArrecadacaoQrCodeResponseDTO buscarArrecadacaoQrCodePagamentoPix(String numeroConvenio, String codigoGuiaRecebimento) {
		LOG.info("Consultar um QR Code de pagamentos instantâneos (PIX) por guia de recebimento (com ou sem código de barras) - {};{}", numeroConvenio, codigoGuiaRecebimento);
		
		var token = tokenService.getToken();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		var request = new HttpEntity<>(headers);
		
		var uri = baseUriSandboxBB + "/arrecadacao-qrcodes?gw-dev-app-key=" + chaveDevAppKey
				+ "&"
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;
		LOG.info("URI: {}", uri);
		
		String response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody();
		LOG.info("response: " + response);
		
		GuiaArrecadacaoQrCodeResponseDTO dto = JSONUtil.convertJsonToJava(response, GuiaArrecadacaoQrCodeResponseDTO.class);
		
		return dto;
	}
	
	
	public GuiaArrecadacaoQrCodeResponseDTO buscarArrecadacaoQrCodePagamentoPixPorId(String txid, String numeroConvenio) {
		LOG.info("Consultar um QR Code de pagamentos instantâneos (PIX) por guia de recebimento (com ou sem código de barras) por ID - {};{}", txid, numeroConvenio);
		
		var token = tokenService.getToken();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		var request = new HttpEntity<>(headers);
		
		// https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes/:id?gw-dev-app-key=d27b17790cffabc0136ce17d20050356b9a1a5b2&numeroConvenio=78806
		var uri = baseUriSandboxBB + "/arrecadacao-qrcodes/" + txid +  "?gw-dev-app-key=" + chaveDevAppKey + "&" + "numeroConvenio=" + numeroConvenio;
		LOG.info("URI: {}", uri);
		
		String response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody();
		LOG.info("response: " + response);
		
		GuiaArrecadacaoQrCodeResponseDTO dto = JSONUtil.convertJsonToJava(response, GuiaArrecadacaoQrCodeResponseDTO.class);

		return dto;
	}
	
}
