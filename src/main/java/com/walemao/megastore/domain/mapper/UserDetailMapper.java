package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.UserDetail;

public class UserDetailMapper implements ParameterizedRowMapper<UserDetail> {

	@Override
	public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDetail ud = new UserDetail();
		ud.setMaterial_status(rs.getInt("u_matrial_status"));
		ud.setEducation(rs.getInt("u_education"));
		ud.setProfessional(rs.getInt("u_professional"));
		ud.setIndustry(rs.getInt("u_industry"));
		ud.setIncome(rs.getInt("u_income"));
		ud.setInterests(rs.getString("u_interests"));
		ud.setSelfdesc(rs.getString("u_selfdesc"));
		return ud;
	}

}
