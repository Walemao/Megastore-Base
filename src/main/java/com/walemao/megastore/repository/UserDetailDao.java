package com.walemao.megastore.repository;

import com.walemao.megastore.domain.UserDetail;;

public interface UserDetailDao {
	public UserDetail getUserDetail(String username);
	public void insert(UserDetail u);
	public void update(UserDetail u);
	public void delete(UserDetail u);
}
