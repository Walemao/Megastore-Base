package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.Province;


public class ProvinceMapper implements RowMapper<Province>{

	@Override
	public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Province province = new Province();
		province.setId(rs.getInt(""));
		province.setName(rs.getString(""));
		return province;
	}

}
