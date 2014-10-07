package com.walemao.megastore.repository;

import com.walemao.megastore.domain.ProductType;

public interface ProductTypeDao {
	public int insert(ProductType p);
	public void delete(ProductType p);
}
