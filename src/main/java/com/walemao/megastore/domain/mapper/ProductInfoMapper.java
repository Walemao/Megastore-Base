package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.ProductInfo;

public class ProductInfoMapper implements RowMapper<ProductInfo> {

	@Override
	public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductInfo productinfo = new ProductInfo();
		productinfo.setId(rs.getInt("pd_id"));
		productinfo.setProductid(rs.getInt("pd_productid"));
		productinfo.setName(rs.getString("pd_name"));
		productinfo.setThumbnail(rs.getString("pd_thumbnail"));
		productinfo.setThummd5(rs.getString("pd_thummd5"));
		productinfo.setWeight(rs.getString("pd_weight"));
		productinfo.setPrice(rs.getBigDecimal("pd_price"));
		productinfo.setAmount(rs.getInt("pd_amount"));
		productinfo.setCreatetime(rs.getTimestamp("pd_createtime"));
		return productinfo;
	}

}
