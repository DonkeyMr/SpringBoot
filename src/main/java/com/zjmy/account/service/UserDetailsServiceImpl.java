package com.zjmy.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zjmy.account.interfaces.CustomUserDetails;
import com.zjmy.account.mapper.UserMapper;
import com.zjmy.account.model.CustomUser;
import com.zjmy.account.model.Role;
import com.zjmy.account.model.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public CustomUserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.getUserByUsername(username);		
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		//返回一个userDetails对象进行验证
		CustomUser customUser = new CustomUser(user.getUsername(), user.getPassword(), authorities,
				user.getId(), user.getAge(), user.getGender());
		return customUser;
	}

}
