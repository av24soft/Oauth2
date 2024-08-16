package com.avsoft.demo.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/hello")
	public String hello() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

		Map<String, Object> userAttributes = oauth2User.getAttributes();
		System.out.println(userAttributes);		


		return "hello this is oauth logined";
	}

	
	
	@GetMapping("/user-info")
	public Map<String, Object> getUserInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication.getPrincipal() instanceof OAuth2User) {
			OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

			Map<String, Object> userAttributes = oauth2User.getAttributes();

			return userAttributes;
		}

		return Map.of("message", "User not authenticated with OAuth2");
	}

}
