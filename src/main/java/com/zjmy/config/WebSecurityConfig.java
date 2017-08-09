package com.zjmy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //该注解开启@PreAuthorize方式
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private SecurityArgumentsConfig securityArgumentsConfig;
	

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//必须显示的注入UserDetailsService的bean对象，否则不生效
        auth.userDetailsService(userDetailsService);
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//不走security认证
        web.ignoring().antMatchers(securityArgumentsConfig.ignoring());		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
		        .antMatchers(securityArgumentsConfig.permitAllUrl()).permitAll()  //允许匿名用户访问
		        .anyRequest().authenticated()
		        .and()
		    .formLogin()
		        .loginPage("/login")  //跳转到登陆页面
		        .defaultSuccessUrl("/login/success") //首次登陆时跳转该接口,如果是访问受限后登陆则登陆成功后跳转到之前无权访问的页面
		        .failureUrl("/login?error")
		        .permitAll()
		        .and()
		    .logout()
		        //.logoutUrl("")  默认退出路径为"/logout"
		        //.logoutSuccessUrl("")  默认退出成功后跳转到登陆页面 "/login?logout"
		        .permitAll()
		        .and()
		    .rememberMe()        //默认有效时间是两周,cookie的名称为remember-me
		        .key("demoSpringBoot");  //随意起
		         
	}
	
}
