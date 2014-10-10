package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.User;


public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("u_id"));
		user.setUserName(rs.getString("u_username"));
		user.setPassword(rs.getString("u_password"));
		user.setMobilephone(rs.getString("u_mobilephone"));
		user.setEmail(rs.getString("u_email"));
		user.setCreateTime(rs.getDate("u_createtime"));
		user.setRemark(rs.getString("u_remark"));
		user.setType(rs.getInt("u_type"));
		user.setLevel(rs.getInt("u_level"));
		user.setHead_portrait(rs.getString("u_head_portrait"));
		return user;
	}
}
