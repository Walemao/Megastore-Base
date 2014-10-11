package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.UserAuthority;

public class UserAuthorityMapper implements
		ParameterizedRowMapper<UserAuthority> {

	@Override
	public UserAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserAuthority ua = new UserAuthority();
		ua.setUsername(rs.getString("username"));
		ua.setAuthority(rs.getString("authority"));
		return ua;
	}

}
