package com.zjmy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityArgumentsConfig {

	@Value("${security.permitAll.url}")
	private String permitAllUrl;
	
	@Value("${security.ignoring}")
	private String ignoring;
	
	//允许匿名访问的资源
	public String[] permitAllUrl() {
		return permitAllUrl.split(",");
	}
	
	//不走security认证的资源
	public String[] ignoring() {
		return ignoring.split(",");
	}
}
