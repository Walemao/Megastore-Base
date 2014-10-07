package com.walemao.megastore.repository;

import com.walemao.megastore.domain.UserBase;

public interface UserBaseDao {
	public UserBase getUserBase(String username);
	public int insert(UserBase u);
	public void update(UserBase u);
	public void delete(UserBase u);
}
