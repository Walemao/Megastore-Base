package com.walemao.megastore.repository;

import com.walemao.megastore.domain.ProductInfo;

public interface ProductInfoDao {
	public int insert(ProductInfo p);
	public void delete(ProductInfo p);
}
