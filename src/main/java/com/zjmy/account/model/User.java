package com.zjmy.account.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zjmy.account.enums.Gender;
import com.zjmy.account.interfaces.CustomUserDetails;

public class User extends org.springframework.security.core.userdetails.User implements CustomUserDetails {

	private Long id;
	
	private String username;
	
	private String password;
	
	private Integer age;
	
	/**
	 * 性别  0:女,1:男
	 */
	private Gender gender;
	
    private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	
	
	
	public User(String username, String password, Integer age, Gender gender,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.age = age;
		this.gender = gender;
	}
    
}
