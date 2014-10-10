package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.ProductImage;

public class ProductImageMapper implements ParameterizedRowMapper<ProductImage> {

	@Override
	public ProductImage mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductImage image = new ProductImage();
		image.setId(rs.getInt("pi_id"));
		image.setPicSrc(rs.getString("pi_src"));
		image.setPicMd5(rs.getString("pi_md5"));
		image.setSort(rs.getInt("pi_sort"));
		image.setProductid(rs.getInt("pi_productid"));
		return image;
	}

}
