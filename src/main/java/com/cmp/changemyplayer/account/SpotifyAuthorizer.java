package com.cmp.changemyplayer.account;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.glassfish.jersey.internal.util.Base64;
import org.springframework.stereotype.Component;

import com.wrapper.spotify.Api;

@Component
public class SpotifyAuthorizer {

	public void authenticate(SpotifyAccount spotify){
		Api api = Api.builder()
				.clientId(spotify.getId())
				.clientSecret(spotify.getSecret())
				.redirectURI(spotify.getRedirectUrl()).build();
		
		/* Set the necessary scopes that the application will need from the user */
		final List<String> scopes = Arrays.asList(
				"playlist-read-private", 
				"playlist-read-collaborative",
				"playlist-modify-public",
				"playlist-modify-private");

		/* Set a state. This is used to prevent cross site request forgeries. */
		final String state = Base64.encodeAsString("changeMyPlayer" + System.currentTimeMillis());

		String authorizeURL = api.createAuthorizeURL(scopes, state);
		
		System.out.println(authorizeURL);
		
		//https://accounts.spotify.com:443/authorize?client_id={0}&response_type=code&redirect_uri={1}&scope={2}&state={3}
		String url = MessageFormat.format(spotify.getAuthorizationUrl(),
				spotify.getId(),
				spotify.getRedirectUrl(),
				scopes.toString(),
				state
				);
		

	
	}
}
