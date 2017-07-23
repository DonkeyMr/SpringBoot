package com.zjmy.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zjmy.account.model.User;

@Mapper //为mapper产生代理类对象
public interface UserMapper {

	public List<User> getUserList();

	public void add(User user);

	public User get(Long id);

	public void update(User user);

	public User getUserByUsername(String username);
}
