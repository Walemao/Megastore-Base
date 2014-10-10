package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.City;

public class CityMapper implements ParameterizedRowMapper<City> {

	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		City city  = new City();
		city.setId(rs.getInt("cityid"));
		city.setName(rs.getString("cityname"));
		city.setZipcode(rs.getString("zipcode"));
		city.setPid(rs.getInt("provinceid"));
		return city;
	}

}
