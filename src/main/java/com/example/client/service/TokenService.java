package com.example.client.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
public class TokenService {

	private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);
	
	@Autowired
	private AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceAndManager;
	
	/**
	 * @author emanuel.sousa
	 * retornar token
	 * @return String
	 */
	public String getToken() {
		
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
				.withClientRegistrationId("sandboxbb")
				.principal("API SANDBOX BB").build();

		OAuth2AuthorizedClient authorizedClient = this.authorizedClientServiceAndManager.authorize(authorizeRequest);

		OAuth2AccessToken accessToken = Objects.requireNonNull(authorizedClient).getAccessToken();

		LOG.info("Issued: " + accessToken.getIssuedAt().toString() + ", Expira:" + accessToken.getExpiresAt().toString());
		LOG.info("Scopes: " + accessToken.getScopes().toString());
		LOG.info("Token: " + accessToken.getTokenValue());

		return accessToken.getTokenValue();
	}
}
