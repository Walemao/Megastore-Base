package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.City;

public interface CityDao {
	public List<City> getCities(int pid);
}
