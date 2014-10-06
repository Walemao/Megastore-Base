package com.walemao.megastore.repository;

import com.walemao.megastore.domain.Order;

public interface OrderDao {
	public void insert(Order o);
	public void update(Order o);
	public void delete(Order o);
	public void permanentlyDelete(Order o);
}
