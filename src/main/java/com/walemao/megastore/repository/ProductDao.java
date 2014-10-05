package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductInfo;

public interface ProductDao {
	public List<ProductInfo> getProducts();
	public boolean Update(ProductInfo p);
}
