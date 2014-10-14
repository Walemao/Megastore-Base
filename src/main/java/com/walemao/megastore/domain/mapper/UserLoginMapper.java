package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.UserLogin;

public class UserLoginMapper implements ParameterizedRowMapper<UserLogin> {

	@Override
	public UserLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserLogin ul = new UserLogin();
		ul.setId(rs.getInt("ul_id"));
		ul.setUsername(rs.getString("ul_username"));
		ul.setLastlogin(rs.getTimestamp("ul_lastlogin"));
		return ul;
	}

}
