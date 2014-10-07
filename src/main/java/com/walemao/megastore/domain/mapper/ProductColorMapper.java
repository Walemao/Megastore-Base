package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.ProductType;

public class ProductColorMapper implements RowMapper<ProductType> {

	@Override
	public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductType productColor = new ProductType();
		productColor.setId(rs.getInt("pd_id"));
		productColor.setName(rs.getString("pd_name"));
		productColor.setAmount(rs.getInt("pd_amount"));
		productColor.setCreatetime(rs.getDate("pd_createtime"));
		return productColor;
	}

}
