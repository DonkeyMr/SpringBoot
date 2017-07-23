package com.zjmy.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjmy.account.interfaces.UserService;
import com.zjmy.account.mapper.UserMapper;
import com.zjmy.account.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	//添加用户
	@Override
	public User addUser(User user) {
		userMapper.add(user);
		//下面这步查询可以省略,因为插入时可返回主键id
		//User u = userMapper.get(user.getId());
		return user;
	}

	@Override
	public User get(Long id) {
		User user = userMapper.get(id);
		return user;
	}

	@Override
	public User update(User user) {
		userMapper.update(user);
		User u = userMapper.get(user.getId());
		return u;
	}

}
