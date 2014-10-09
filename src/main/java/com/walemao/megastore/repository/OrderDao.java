package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Order;

public interface OrderDao {
	/**
	 * 
	 * @param parm
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param mark
	 *            0查看所有订单 1查看删除的订单
	 * @return 返回所有订单列表
	 */
	public List<Order> getAllOrders(String parm, Date startTime, Date endTime,
			int mark);

	/**
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param username
	 *            用户名
	 * @return 返回用户的订单列表
	 */
	public List<Order> getOrders(Date startTime, Date endTime, String username);

	/**
	 * 
	 * @param orderId
	 *            订单ID
	 * @return 返回订单
	 */
	public Order getOrder(int orderId);

	/**
	 * 插入
	 * 
	 * @param o
	 * @return
	 */
	public int insert(Order o);

	/**
	 * 修改订单状态
	 * 
	 * @param o
	 */
	public void updateOrderStatus(Order o);

	/**
	 * 伪删除
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 永久删除
	 * 
	 * @param id
	 */
	public void permanentlyDelete(int id);

}
