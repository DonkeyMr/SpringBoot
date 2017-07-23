package com.zjmy.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zjmy.account.interfaces.CustomUserDetails;
import com.zjmy.account.mapper.UserMapper;
import com.zjmy.account.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@SuppressWarnings("unused")
	@Override
	public CustomUserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.getUserByUsername(username);
		System.out.println(user.getRoles().toString());
		
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return user;
	}

}
