package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;

public class OrderDetailMapper implements ParameterizedRowMapper<OrderDetail> {

	@Override
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		OrderDetail oDetail = new OrderDetail();
		oDetail.setId(rs.getInt("od_id"));
		ProductBase productInfo = new ProductBase();
		productInfo.setName(rs.getString("p_name"));
		oDetail.setProduct(productInfo);
		ProductInfo productType= new ProductInfo();
		productType.setName(rs.getString(""));
		productType.setThumbnail(rs.getString(""));
		oDetail.setAmount(rs.getInt("od_amount"));
		oDetail.setRemark(rs.getString("od_reamark"));
		oDetail.setCreatetime(rs.getTimestamp("od_createtime"));
		return oDetail;
	}

}
