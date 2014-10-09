package com.walemao.megastore.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.domain.mapper.OrderDetailMapper;
import com.walemao.megastore.repository.OrderDetailDao;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<OrderDetail> getOrderDetails(int orderid) {
		// TODO Auto-generated method stub
		String sql = "SELECT od_id, od_productid, "
				+ "	p_number, p_name, pd_price, "
				+ "	od_typeid, pd_name, od_orderid, "
				+ "	od_amount, od_reamark, od_createtime "
				+ "FROM t_order_detail a LEFT JOIN ( "
				+ "	SELECT p_id, p_number, p_name, pd_id, pd_price, pd_name FROM"
				+ "		t_product_base a "
				+ "	LEFT JOIN t_prodcut_info b ON a.p_id = b.pd_productid "
				+ ") b ON a.od_productid = b.p_id "
				+ "AND od_typeid = b.pd_id WHERE od_orderid = ? "
				+ "ORDER BY a.od_createtime";
		return this.jdbcTemplate.query(sql, new Object[] { orderid },
				new OrderDetailMapper());
	}

}
