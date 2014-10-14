package com.walemao.megastore.repository.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.Order;
import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.domain.Enum.EnumOrder;
import com.walemao.megastore.domain.mapper.OrderMapper;
import com.walemao.megastore.repository.OrderDao;
import com.walemao.megastore.util.PaginationHelper;

@Repository
public class OrderDaoImpl extends CommonDaoImpl implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String queryArgs = "o_id,o_username,o_createtime,o_addressinfo,o_confirm,o_status,o_fee,o_freight,o_remark,o_paytype";

	@Override
	public CurrentPage<Order> getAllOrders(String parm, Date startTime,
			Date endTime, int orderStatus, int mark) {
		PaginationHelper<Order> ph = new PaginationHelper<Order>();
		// TODO Auto-generated method stub
		String args = mark == 0 ? "null" : "not null";
		String sql = "select " + queryArgs
				+ " from t_order where deletemark is " + args;
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and o_id like ?";
			list.add("%" + parm + "%");
		}
		if (orderStatus != EnumOrder.全部状态.getKey()) {
			sql += " and o_status = ?";
			list.add(orderStatus);
		}
		if (startTime != null && endTime != null) {
			sql += " and o_createtime between ? and ?";
			list.add(startTime);
			list.add(endTime);
		}
		sql += " order by o_createtime desc";
		return ph.fetchPage(jdbcTemplate, sql.replace(queryArgs, "count(1)"),
				sql, list.toArray(), CurrentPage.getPageNubmer(),
				CurrentPage.getPageLength(), new OrderMapper());
	}

	@Override
	public CurrentPage<Order> getOrders(Date startTime, Date endTime,
			int orderStatus, String username) {
		// TODO Auto-generated method stub
		PaginationHelper<Order> ph = new PaginationHelper<Order>();
		String sql = "select " + queryArgs
				+ " from t_order where deletemark is null";
		List<Object> list = new ArrayList<Object>();
		if (startTime != null && endTime != null) {
			sql += " and o_createtime between ? and ?";
			list.add(startTime);
			list.add(endTime);
		}
		if (orderStatus != EnumOrder.全部状态.getKey()) {
			sql += " and o_status = ?";
			list.add(orderStatus);
		}
		sql += " and o_username=? order by o_createtime desc";
		list.add(username);
		return ph.fetchPage(jdbcTemplate, sql.replace(queryArgs, "count(1)"),
				sql, list.toArray(), CurrentPage.getPageNubmer(),
				CurrentPage.getPageLength(), new OrderMapper());
	}

	@Override
	public int insert(Order o) {
		// TODO Auto-generated method stub
		final List<OrderDetail> list = o.getList();
		String sql = "insert into t_order(o_username,o_createtime,o_addressinfo,o_fee,o_freight,o_remark,o_paytype) values (?,now(),?,?,?,?,?,?)";
		int id = this.addIntoDB(sql,
				new Object[] { o.getUsername(), o.getAddressinfo(), o.getFee(),
						o.getFreight(), o.getRemark(), o.getPaytype() });
		o.setId(id);
		sql = "insert into t_order_detail(od_productid,od_typeid,od_orderid,od_amount,od_reamark,od_createtime) values (?,?,"
				+ id + ",?,?,now())";
		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				int productid = list.get(i).getProductid();
				int typeid = list.get(i).getTypeid();
				int amount = list.get(i).getAmount();
				String remark = list.get(i).getRemark();
				ps.setInt(1, productid);
				ps.setInt(2, typeid);
				ps.setInt(3, amount);
				ps.setString(4, remark);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		return id;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "update t_order set deletemark=now() where od_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		String sql = "select o_id,o_username,o_createtime,o_addressinfo,o_confirm,o_status,o_fee,o_freight,o_remark,o_paytype from t_order where o_id=? limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { orderId },
				new OrderMapper()).get(0);
	}

	@Override
	public void updateOrderStatus(Order o) {
		// TODO Auto-generated method stub
		String sql = "update t_order set o_status = ? where o_id=?";
		this.jdbcTemplate.update(sql, new Object[] { o.getStatus(), o.getId() });
	}

	@Override
	public void permanentlyDelete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_order where o_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void updateConfirm(Order o) {
		// TODO Auto-generated method stub
		String sql = "update t_order set o_confirm = ? where o_id=?";
		this.jdbcTemplate.update(sql,
				new Object[] { o.getConfirm(), o.getId() });
	}

}
