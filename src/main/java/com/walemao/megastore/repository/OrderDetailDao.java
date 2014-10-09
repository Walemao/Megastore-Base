package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.OrderDetail;

public interface OrderDetailDao {
	/**
	 * 根据ID获取订单明细列表
	 * @param orderid
	 * @return
	 */
	public List<OrderDetail> getOrderDetails(int orderid);
	/**
	 * 伪删除
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 删除
	 * @param id
	 */
	public void permanentlyDelete(int id);
}
