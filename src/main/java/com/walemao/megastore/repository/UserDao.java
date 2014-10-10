package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.User;

public interface UserDao {
	public List<User> getUsers(String username);
	public User getUser(int id);
	public User getUser(String username);
	public void updatePasswd(User user);
	public void updateEmail(User user);
	public void updateMobilephone(User user);
	public int insert(User user);
	public boolean CheckUsername(String username);
	public boolean CheckMobilephone(String mobilephone);
	public boolean CheckEmail(String email);
	public void delete(String username);
}
