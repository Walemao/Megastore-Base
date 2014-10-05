package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.ProductInfo;

public interface ProductDao {
	public List<ProductInfo> getProducts(String parm,int type,Date startTime,Date endTime);
	public void Insert(ProductInfo p);
	public void Update(ProductInfo p);
}
