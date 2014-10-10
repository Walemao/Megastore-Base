package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Order;

public class OrderMapper implements ParameterizedRowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setCreatetime(rs.getDate("o_createtime"));
		order.setAddressinfo(rs.getString("o_addressinfo"));
		order.setConfirm(rs.getString("o_confirm"));
		order.setState(rs.getInt("o_state"));
		order.setFee(rs.getBigDecimal("o_fee"));
		order.setFreight(rs.getBigDecimal("o_freight"));
		order.setRemark(rs.getString("o_remark"));
		order.setPaytype(rs.getInt("o_paytype"));
		return order;
	}

}
