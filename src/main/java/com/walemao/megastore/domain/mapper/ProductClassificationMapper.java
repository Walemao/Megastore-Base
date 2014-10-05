package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.ProductClassification;

public class ProductClassificationMapper implements RowMapper<ProductClassification>{

	@Override
	public ProductClassification mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		// TODO Auto-generated method stub
		ProductClassification pcf = new ProductClassification();
		pcf.setId(rs.getInt("pc_id"));
		pcf.setName(rs.getString("pc_name"));
		return pcf;
	}
}
