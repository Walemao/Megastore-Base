package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.Order;

public class OrderMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
