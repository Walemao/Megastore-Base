package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.Province;
import com.walemao.megastore.domain.mapper.ProvinceMapper;
import com.walemao.megastore.repository.ProvinceDao;

public class ProvinceDaoImpl implements ProvinceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Province> getProvinces() {
		// TODO Auto-generated method stub
		List<Province> list = new ArrayList<Province>();
		Province p0 = new Province();
		p0.setId(0);
		p0.setName("请选择");
		list.add(p0);
		String sql = "select provinceid,provincename from d_province";
		list.addAll(this.jdbcTemplate.query(sql, new ProvinceMapper()));
		return list;
	}

}
