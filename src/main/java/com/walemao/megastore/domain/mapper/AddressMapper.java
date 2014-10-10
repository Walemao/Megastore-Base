package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Address;

public class AddressMapper implements ParameterizedRowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setId(rs.getInt("a_id"));
		address.setUsername(rs.getString("a_username"));
		address.setConsignee(rs.getString("a_consignee"));
		address.setProvince(rs.getInt("a_province"));
		address.setCity(rs.getInt("a_city"));
		address.setDistrict(rs.getInt("a_district"));
		address.setAddress(rs.getString("a_address"));
		address.setZipCode(rs.getString("a_zip_code"));
		address.setMobilephone(rs.getString("a_mobilephone"));
		address.setPhone(rs.getString("a_phone"));
		address.setDefault(rs.getBoolean("a_isdefault"));
		address.setCreattime(rs.getDate("a_createtime"));
		return address;
	}

}
