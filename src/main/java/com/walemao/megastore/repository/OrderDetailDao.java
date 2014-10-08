package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.OrderDetail;

public interface OrderDetailDao {
	public List<OrderDetail> getOrderDetails(int orderid);
}
