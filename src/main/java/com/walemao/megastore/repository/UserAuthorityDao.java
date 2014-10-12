package com.walemao.megastore.repository;

import com.walemao.megastore.domain.UserAuthority;

public interface UserAuthorityDao {
	/**
	 * 插入权限方法
	 * @param au
	 */
	public void insert(UserAuthority au);
	/**
	 * 修改权限方法
	 * @param au 传入修改权限的对象和用户名
	 */
	public void update(UserAuthority au);
	/**
	 * 删除用户权限
	 * @param username
	 */
	public void delete(String username);
}
