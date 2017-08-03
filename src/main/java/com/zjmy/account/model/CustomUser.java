package com.zjmy.account.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.zjmy.account.enums.Gender;
import com.zjmy.account.interfaces.CustomUserDetails;

public class CustomUser extends User implements CustomUserDetails {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities, Long id,
			Integer age, Gender gender) {
		super(username, password, authorities);
		this.id = id;
		this.age = age;
		this.gender = gender;
	}

	private Long id;
	
	private Integer age;
	
	private Gender gender;

	@Override
	public Long id() {
		return id;
	}
	
	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public Gender getGender() {
		return gender;
	}
	
}
