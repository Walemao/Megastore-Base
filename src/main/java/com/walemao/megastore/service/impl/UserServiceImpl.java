package com.walemao.megastore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.User;
import com.walemao.megastore.repository.UserDao;
import com.walemao.megastore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	@Override
	public CurrentPage<User> getUsers(String username, int enabled) {
		// TODO Auto-generated method stub
		return userDao.getUsers(username, enabled);
	}

	@Override
	public void delete(String username, boolean enabled) {
		// TODO Auto-generated method stub
		userDao.delete(username, enabled);
	}

}
