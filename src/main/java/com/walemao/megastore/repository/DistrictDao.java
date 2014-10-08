package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.District;

public interface DistrictDao {
	public List<District> getDistricts(int cityid);
}
