package com.zjmy.account.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "拿来测试用的")
@RestController
public class TestController {

	@Value("${file.name}")
	String name;
	
	@RequestMapping("/test")
	public String testValue() {
	  return "world";
	}
}
