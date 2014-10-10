package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Province;


public class ProvinceMapper implements ParameterizedRowMapper<Province>{

	@Override
	public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Province province = new Province();
		province.setId(rs.getInt("provinceid"));
		province.setName(rs.getString("provincename"));
		return province;
	}

}
