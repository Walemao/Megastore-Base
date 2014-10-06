package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Order;

public interface OrderDao {
	public List<Order> getAllOrders(String parm,Date startTime,Date endTime,int mark);
	public List<Order> getOrders(Date startTime,Date endTime,String username);
	public Order getOrder(int orderId,String username);
	public void insert(Order o);
	public void update(Order o);
	public void delete(Order o);
	public void permanentlyDelete(Order o);
}
