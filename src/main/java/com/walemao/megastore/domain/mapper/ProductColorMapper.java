package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.ProductColor;

public class ProductColorMapper implements RowMapper<ProductColor> {

	@Override
	public ProductColor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductColor productColor = new ProductColor();
		productColor.setId(rs.getInt("pd_id"));
		productColor.setName(rs.getString("pd_name"));
		productColor.setAmount(rs.getInt("pd_amount"));
		productColor.setCreatetime(rs.getDate("pd_createtime"));
		return productColor;
	}

}
