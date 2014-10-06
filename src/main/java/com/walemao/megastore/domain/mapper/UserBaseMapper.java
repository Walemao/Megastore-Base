package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.UserBase;

public class UserBaseMapper implements RowMapper<UserBase>{

	@Override
	public UserBase mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserBase userbase = new UserBase();
		userbase.setId(rs.getInt("u_id"));
		userbase.setHead_portrait(rs.getString("u_head_portrait"));
		userbase.setNickname(rs.getString("u_nickname"));
		userbase.setRealname(rs.getString("u_realname"));
		userbase.setSex(rs.getInt("u_sex"));
		userbase.setBirth(rs.getDate("u_birth"));
		userbase.setIsval_email(rs.getBoolean("u_isval_email"));
		userbase.setProvices(rs.getInt("u_provices"));
		userbase.setCities(rs.getInt("u_cities"));
		userbase.setDistricts(rs.getInt("u_districts"));
		userbase.setAddress(rs.getString("u_address"));
		userbase.setIsval_mobilephone(rs.getBoolean("u_isval_mobilephone"));
		userbase.setTelphone(rs.getString("u_telphone"));
		return userbase;
	}

}
