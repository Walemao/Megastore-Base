package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.UserAuthority;
import com.walemao.megastore.repository.UserAuthorityDao;

@Repository
public class UserAuthorityDaoImpl implements UserAuthorityDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public void insert(UserAuthority au) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_authority(username,authority) values(?,?)";
		this.JdbcTemplate.update(sql,
				new Object[] { au.getUsername(), au.getAuthority() });
	}

	@Override
	public void update(UserAuthority au) {
		// TODO Auto-generated method stub
		String sql = "update t_user_authority set authority=? where username=?";
		this.JdbcTemplate.update(sql,
				new Object[] { au.getAuthority(), au.getUsername() });
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_authority where username=?";
		this.JdbcTemplate.update(sql,
				new Object[] { username });
	}

}
