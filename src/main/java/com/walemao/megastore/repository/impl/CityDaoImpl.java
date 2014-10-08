package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.City;
import com.walemao.megastore.domain.mapper.CityMapper;
import com.walemao.megastore.repository.CityDao;

public class CityDaoImpl implements CityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<City> getCities(int pid) {
		// TODO Auto-generated method stub
		List<City> list = new ArrayList<City>();
		City c0 = new City();
		c0.setId(0);
		c0.setName("请选择");
		list.add(c0);
		String sql = "select cityid,cityname,zipcode,provinceid from d_city where provinceid=?";
		list.addAll(this.jdbcTemplate.query(sql, new Object[] { pid },
				new CityMapper()));
		return list;
	}

}
