package com.zjmy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
		        .antMatchers("/").permitAll()
		        .anyRequest().authenticated()
		        .and()
		    .formLogin()
		        .loginPage("/login")  //跳转到登陆页面
		        .defaultSuccessUrl("/login/success")
		        .failureUrl("/login?error")
		        .permitAll()
		        .and()
		    .logout()
		        //.logoutUrl("")  默认退出路径为logout
		        //.logoutSuccessUrl("")  默认退出成功后跳转到登陆页面 ?logout
		        .permitAll();
		         
	}
	
}
