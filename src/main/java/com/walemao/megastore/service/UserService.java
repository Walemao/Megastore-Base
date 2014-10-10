package com.walemao.megastore.service;

import java.util.List;

import com.walemao.megastore.domain.User;

public interface UserService {
	public List<User> getUsers(String username);
	public int insert(User user);
}
