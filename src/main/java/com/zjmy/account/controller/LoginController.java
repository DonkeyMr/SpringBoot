package com.zjmy.account.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"bye"})
public class LoginController {
	
	@RequestMapping(value = "/test/request", method = RequestMethod.GET)
	public String index(Model model) {
		//加入一个属性,用来在模板中读取
		model.addAttribute("hello", "hello world");
		model.addAttribute("bye", "goodbye");
		// return模板文件的名称，对应src/main/resources/templates/index.html
		return "index";
	}
	
	@RequestMapping(value = "/test/session", method = RequestMethod.GET)
	public String testSession(Model model) {
		return "bye";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultView() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	@ResponseBody
	public Collection<? extends GrantedAuthority> loginSuccess() {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext()
				                                                 .getAuthentication().getAuthorities();
		return authorities;
	}
}
