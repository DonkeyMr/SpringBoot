package com.zjmy.account.model;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.zjmy.account.enums.Gender;

public class User {

	private Long id;
	
	@NotNull
	private String username;
	
	@Min(6)
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
	
	
	@Override
	public String toString() {
		return "id= " + id + ", username= " + username + ", password= "
				+ password + ", age= " + age + ", gender= " + gender + ", roles= "
				+ roles;
	}
    
	
}
