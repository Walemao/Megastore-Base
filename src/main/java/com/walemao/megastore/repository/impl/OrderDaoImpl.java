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
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Order o) {
		// TODO Auto-generated method stub
		final List<OrderDetail> list = o.getList();
		String sql = "insert into t_order(o_username,o_createtime,o_addressid,o_fee,o_freight,o_remark,o_paytype) values (?,now(),?,?,?,?,?,?)";
		int id = this.jdbcTemplate.update(
				sql,
				new Object[] { o.getUsername(), o.getAddressid(), o.getFee(),
						o.getFreight(), o.getRemark(), o.getPaytype() });
		sql = "insert into t_order_detail(od_productid,od_colorid,od_orderid,od_amount,od_reamark) values (?,?,"
				+ id + ",?,?)";
		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				int productid = list.get(i).getProductid();
				int colorid = list.get(i).getColorid();
				int amount = list.get(i).getAmount();
				String remark = list.get(i).getRemark();
				ps.setInt(1, productid);
				ps.setInt(2, colorid);
				ps.setInt(3, amount);
				ps.setString(4, remark);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "update t_order set deletermark=now() where od_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
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
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void updateOrderStatus(Order o) {
		// TODO Auto-generated method stub
		String sql = "update t_order set o_state = ? where o_id=?";
		this.jdbcTemplate.update(sql, new Object[] { o.getState(), o.getId() });
	}

}
