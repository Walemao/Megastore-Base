package com.walemao.megastore.repository;

import java.util.List;
import java.util.UUID;

import com.walemao.megastore.domain.User;

public interface UserDao {
	public List<User> getUsers();
	public User getUser(int id);
}
