package com.walemao.megastore.repository;

import java.util.Date;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.Order;

public interface OrderDao {
	/**
	 * 查询所有所有订单列表
	 * @param parm			订单编号
	 * @param startTime		开始时间
	 * @param endTime		结束时间
	 * @param orderStatus	订单状态
	 * @param mark			0查看所有订单 1查看删除的订单
	 * @return
	 */
	public CurrentPage<Order> getAllOrders(String parm, Date startTime,
			Date endTime, int orderStatus, int mark);

	/**
	 * 查询用户所有所有订单列表
	 * @param username		用户名
	 * @param startTime		开始时间
	 * @param endTime		结束时间
	 * @param orderStatus	订单状态
	 * @return
	 */
	public CurrentPage<Order> getOrders(Date startTime, Date endTime,int orderStatus,
			String username);

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
	 * 确认发货后修改填写确认人信息
	 * 
	 * @param o
	 */
	public void updateConfirm(Order o);

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
