package com.zjmy.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"bye"})
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
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
}
