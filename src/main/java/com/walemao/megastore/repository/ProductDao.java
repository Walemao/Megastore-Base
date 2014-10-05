package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.ProductInfo;

public interface ProductDao {
	public List<ProductInfo> getProducts(String parm,int type,Date startTime,Date endTime,int mark);
	public void insert(ProductInfo p);
	public void update(ProductInfo p);
	public void delete(ProductInfo p);
	public void permanentlyDelete(ProductInfo p);
}
