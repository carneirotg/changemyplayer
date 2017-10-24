package com.cmp.changemyplayer.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmp.changemyplayer.account.SpotifyAccount;
import com.cmp.changemyplayer.account.SpotifyAuthorizer;
import com.wrapper.spotify.Api;

@RestController
@RequestMapping("/spotify/")
public class SpotifyController {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpotifyAccount spotify;
	
	@Autowired
	private SpotifyAuthorizer spotifyAuthorizer;

	@RequestMapping("auth")
	public String authenticate() {
		spotifyAuthorizer.authenticate(spotify);
		return "index";
	}
	
	@RequestMapping("code")
	public String getCode(@RequestParam("code") String code, @RequestParam("state") String state, 
			@RequestParam("error") String error){
		
		log.info("code =["+code+"]");
		log.info("code =["+state+"]");
		log.info("code =["+error+"]");
		return "token";
	}

	

}
