package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.OrderDetail;

public class OrderDetailMapper implements RowMapper<OrderDetail> {

	@Override
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		OrderDetail oDetail = new OrderDetail();
		oDetail.setId(rs.getInt("od_id"));
		oDetail.setAmount(rs.getInt("od_amount"));
		oDetail.setRemark(rs.getString("od_reamark"));
		oDetail.setCreatetime(rs.getDate("od_createtime"));
		return oDetail;
	}

}
