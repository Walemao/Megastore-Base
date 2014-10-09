package com.walemao.megastore.repository;

import com.walemao.megastore.domain.ProductInfo;

public interface ProductInfoDao {
	public ProductInfo getProductInfo(String md5);
	public int insert(ProductInfo p);
	public void update(ProductInfo p);
	public void update(int id,int[] ids);
	public void delete(int id);
	public void deleteUnused();
}
