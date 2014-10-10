package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.ProductClassify;

public class ProductClassifyMapper implements ParameterizedRowMapper<ProductClassify>{

	@Override
	public ProductClassify mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		// TODO Auto-generated method stub
		ProductClassify pcf = new ProductClassify();
		pcf.setId(rs.getInt("pc_id"));
		pcf.setName(rs.getString("pc_name"));
		return pcf;
	}
}
