package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Order;
import com.walemao.megastore.domain.Enum.EnumOrder;

public class OrderMapper implements ParameterizedRowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setId(rs.getInt("o_id"));
		order.setUsername(rs.getString("o_username"));
		order.setCreatetime(rs.getTimestamp("o_createtime"));
		order.setAddressinfo(rs.getString("o_addressinfo"));
		order.setConfirm(rs.getString("o_confirm"));
		order.setStatus(rs.getInt("o_status"));
		order.setFee(rs.getBigDecimal("o_fee"));
		order.setFreight(rs.getBigDecimal("o_freight"));
		order.setRemark(rs.getString("o_remark"));
		order.setPaytype(rs.getInt("o_paytype"));
		order.setOrderStatus(EnumOrder.getName(order.getStatus()));
		return order;
	}

}
