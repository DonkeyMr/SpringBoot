package com.zjmy.account.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import com.zjmy.account.enums.Gender;

public interface CustomUserDetails extends UserDetails {

	Long id();
	
	Integer getAge();
	
	Gender getGender();
}
