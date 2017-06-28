package com.zjmy.account.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjmy.account.interfaces.UserService;
import com.zjmy.account.utils.FreemarkerUtils;
import com.zjmy.account.utils.PdfFileUtils;

@Api(value = "拿来测试用的")
@RestController
public class TestController {

	@Autowired
	private UserService userService;

	@Value("${user.name}")
	private String name;
	
	@Value("${user.showName}")
	private String showName;
	
	@RequestMapping("/test")
	public void testValue() {
	    System.out.println(this.name);
	    System.out.println(this.showName);
	}
	
	@RequestMapping(value = "/pdf")
	public Map<String, Object> testCreatePDF() {
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put("mobile", "17343083162");
	    data.put("email", "1532129326@qq.com");
	    data.put("name", "刘鹏");
	    String ftlHtml = FreemarkerUtils.loadFtlHtml("simpleForm.ftl", data);
	    FileOutputStream f = null;
		try {
			f = new FileOutputStream("d:\\a.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    PdfFileUtils.saveChinesePdf(f, ftlHtml);
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("status", "success");
	    return map;
	}
	
	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put("mobile", "17343083162");
	    data.put("email", "1532129326@qq.com");
	    data.put("name", "刘鹏");
	    String ftlHtml = FreemarkerUtils.loadFtlHtml("simpleForm.ftl", data);
	    FileOutputStream f = null;
		try {
			f = new FileOutputStream("d:\\a.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    PdfFileUtils.saveChinesePdf(f, ftlHtml);
	} 
}
