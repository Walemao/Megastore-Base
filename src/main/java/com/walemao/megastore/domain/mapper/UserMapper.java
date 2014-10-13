package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.User;


public class UserMapper implements ParameterizedRowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("u_id"));
		user.setUsername(rs.getString("u_username"));
		user.setPassword(rs.getString("u_password"));
		user.setMobilephone(rs.getString("u_mobilephone"));
		user.setEmail(rs.getString("u_email"));
		user.setCreateTime(rs.getTimestamp("u_createtime"));
		user.setRemark(rs.getString("u_remark"));
		user.setType(rs.getInt("u_type"));
		user.setLevel(rs.getInt("u_level"));
		user.setEnabled(rs.getBoolean("u_enabled"));
		user.setHead_portrait(rs.getString("u_head_portrait"));
		return user;
	}
}
