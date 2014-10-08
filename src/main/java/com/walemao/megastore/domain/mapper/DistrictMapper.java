package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.District;

public class DistrictMapper implements RowMapper<District> {

	@Override
	public District mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		District d = new District();
		d.setId(rs.getInt("districtid"));
		d.setName(rs.getString("districtname"));
		d.setCityid(rs.getInt("cityid"));
		return d;
	}

}
