package com.zjmy.account.interfaces;

import java.util.List;

import com.zjmy.account.model.User;

public interface UserService {

	public List<User> getUserList();

	public User addUser(User user);

	public User get(Long id);

	public User update(User user);
}
