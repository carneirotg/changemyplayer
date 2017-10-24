package com.cmp.changemyplayer.account;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.player.spotify")
public class SpotifyAccount implements Player{
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@NotNull
	private String id;
	
	@NotNull
	private String secret;
	
	@NotNull
	private String redirectUrl;
	
	@NotNull
	private String authorizationUrl;
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSecret() {
		return secret;
	}


	public void setSecret(String secret) {
		this.secret = secret;
	}


	public String getRedirectUrl() {
		return redirectUrl;
	}


	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


	public String getAuthorizationUrl() {
		return authorizationUrl;
	}


	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		log.warn("Id: " + this.id);
		log.warn("Secret: " + this.secret);
		log.warn("Redirect Url: " + this.redirectUrl);
		log.warn("Authorization Url: " + this.authorizationUrl);
		
	}

}
