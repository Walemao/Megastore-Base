package com.walemao.megastore.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.domain.mapper.OrderDetailMapper;
import com.walemao.megastore.repository.OrderDetailDao;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<OrderDetail> getOrderDetails(int orderid) {
		// TODO Auto-generated method stub
		String sql = "SELECT od_id,od_productid,p_number,p_name,p_price,od_typeid, "
				+ "	pd_name,od_orderid,od_amount, "
				+ "	od_reamark,od_createtime "
				+ "FROM "
				+ "	t_order_detail a "
				+ "LEFT JOIN t_product_info b ON a.od_productid = b.p_id "
				+ "LEFT JOIN t_prodcut_type c ON a.od_typeid = c.pd_id "
				+ "WHERE a.od_orderid =?";
		return this.jdbcTemplate.query(sql, new Object[] { orderid },
				new OrderDetailMapper());
	}

}
