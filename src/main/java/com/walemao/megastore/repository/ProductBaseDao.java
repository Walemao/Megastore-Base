package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.ProductBase;

public interface ProductBaseDao {
	public List<ProductBase> getProducts(String parm,int type,Date startTime,Date endTime,int mark);
	public ProductBase getProduct(int id);
	public int insert(ProductBase p);
	public void update(ProductBase p);
	public void delete(ProductBase p);
	public void permanentlyDelete(ProductBase p);
}
