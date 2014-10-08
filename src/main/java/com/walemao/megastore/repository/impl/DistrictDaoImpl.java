package com.walemao.megastore.repository.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.District;
import com.walemao.megastore.domain.mapper.DistrictMapper;
import com.walemao.megastore.repository.DistrictDao;

public class DistrictDaoImpl implements DistrictDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<District> getDistricts(int cityid) {
		// TODO Auto-generated method stub
		List<District> list = new ArrayList<District>();
		District d = new District();
		d.setId(0);
		d.setName("请选择");
		list.add(d);
		String sql = "select districtid,districtname,cityid from d_district where cityid=?";
		list.addAll(this.jdbcTemplate.query(sql, new Object[] { cityid },
				new DistrictMapper()));
		return list;
	}

}
