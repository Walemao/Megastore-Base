package com.walemao.megastore.repository.impl;

import java.util.List;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.Address;
import com.walemao.megastore.domain.mapper.AddressMapper;
import com.walemao.megastore.repository.AddressDao;

public class AddressDaoImpl extends CommonDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Address> getAddresses(String username) {
		// TODO Auto-generated method stub
		String sql = "select a_id,a_username,a_consignee,a_province,a_city,a_district,a_address,a_zip_code,a_mobilephone,a_phone,a_createtime from t_address where a_username = ? order by a_createtime";
		return this.jdbcTemplate.query(sql, new Object[] { username },
				new AddressMapper());
	}

	@Override
	public int insert(Address a) {
		// TODO Auto-generated method stub
		String sql = "insert into t_address(a_username,a_consignee,a_province,a_city,a_district,a_address,a_zip_code,a_mobilephone,a_phone,a_createtime) values(?,?,?,?,?,?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { a.getUsername(), a.getConsignee(),
						a.getProvince(), a.getCity(), a.getDistrict(),
						a.getAddress(), a.getZipCode(), a.getMobilephone(),
						a.getPhone() });
	}

	@Override
	public void update(Address a) {
		// TODO Auto-generated method stub
		String sql = "update t_address set a_consignee=?,a_province=?,a_city=?,a_district=?,a_address=?,a_zip_code=?,a_mobilephone=?,a_phone=? where a_id=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { a.getConsignee(), a.getProvince(), a.getCity(),
						a.getDistrict(), a.getAddress(), a.getZipCode(),
						a.getMobilephone(), a.getPhone(), a.getId() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_address where a_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void changeDefault(Address a) {
		// TODO Auto-generated method stub
		String sql0 = "update t_address set a_isdefault=0 where a_username = ?";
		this.jdbcTemplate.update(sql0, new Object[] { a.getUsername() });
		String sql = "update t_address set a_isdefault = ? where a_id=?";
		this.jdbcTemplate
				.update(sql, new Object[] { a.isDefault(), a.getId() });
	}

}
