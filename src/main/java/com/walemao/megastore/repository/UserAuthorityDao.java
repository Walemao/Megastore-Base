package com.walemao.megastore.repository;

import com.walemao.megastore.domain.UserAuthority;

public interface UserAuthorityDao {
	public void insert(UserAuthority au);
	public void update(UserAuthority au);
	public void delete(String username);
}
