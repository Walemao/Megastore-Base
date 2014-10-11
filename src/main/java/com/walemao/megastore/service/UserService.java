package com.walemao.megastore.service;


import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.User;

public interface UserService {
	public CurrentPage<User> getUsers(String username, int enabled);
	public int insert(User user);
	public void delete(String username, boolean enabled);
}
