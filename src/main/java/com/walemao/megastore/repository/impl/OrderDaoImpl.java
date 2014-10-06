package com.walemao.megastore.repository.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.Order;
import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.repository.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Order o) {
		// TODO Auto-generated method stub
		final List<OrderDetail> list = o.getList();
		String sql = "insert into t_order(o_username,o_createtime,o_addressid,o_state,o_fee,o_freight,o_remark,o_paytype) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int id = this.jdbcTemplate.update(
				sql,
				new Object[] {  });
		sql = "insert into t_prodcut_color(pd_productid,pd_name,pd_amount,pd_createtime) values ("
				+ id + ",?,?,now())";
		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				int amount = list.get(i).getAmount();
				ps.setInt(2, amount);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}

	@Override
	public void update(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void permanentlyDelete(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getAllOrders(String parm, Date startTime, Date endTime,
			int mark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders(Date startTime, Date endTime, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int orderId, String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
