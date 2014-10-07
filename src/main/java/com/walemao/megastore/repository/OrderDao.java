package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Order;

public interface OrderDao {
	public List<Order> getAllOrders(String parm,Date startTime,Date endTime,int mark);
	public List<Order> getOrders(Date startTime,Date endTime,String username);
	public Order getOrder(int orderId);
	public int insert(Order o);
	public void updateOrderStatus(Order o);
	public void delete(int id);
}
