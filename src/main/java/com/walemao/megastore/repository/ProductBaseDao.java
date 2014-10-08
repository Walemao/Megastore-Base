package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.ProductBase;

public interface ProductBaseDao {
	public List<ProductBase> getProducts(String parm,int type,Date startTime,Date endTime,int mark);
	public ProductBase getProduct(int id);
	public int insert(ProductBase p,int[] ids);
	public void update(ProductBase p);
	/**
	 * 伪删除
	 * @param p
	 */
	public void delete(ProductBase p);
	/**
	 * 永久删除
	 * @param p
	 */
	public void permanentlyDelete(ProductBase p);
}
