package com.zjmy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityArgumentsConfig {

	@Value("${security.permitAll.url}")
	private String permitAllUrl;
	
	public String[] permitAllUrl() {
		return permitAllUrl.split(",");
	}
	
}
