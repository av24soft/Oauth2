package com.avsoft.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecutiryConfig {
	
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	 {
	 return  http
	          .authorizeHttpRequests(authorizeRequests ->
	              authorizeRequests
	                  .requestMatchers("/public").permitAll()
	                  .anyRequest().authenticated()
	          ).build();	
	 
	 
	 }

	
	
	

	 }
