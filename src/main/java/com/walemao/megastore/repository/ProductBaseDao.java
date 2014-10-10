package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;

public interface ProductBaseDao {
	/**
	 * 
	 * @param parm
	 *            产品名称
	 * @param classify
	 *            产品类型，0表示所有类型
	 * @param startTime
	 *            查询开始时间
	 * @param endTime
	 *            查询结束时间
	 * @param mark
	 *            0表示查询所有商品 1表示删除的商品
	 * @param pageSize
	 *            页面大小
	 * @return 返回所有商品列表
	 */
	public CurrentPage<ProductBase> getProducts(String parm, int classify,
			Date startTime, Date endTime, int mark);

	public ProductBase getProduct(int id);

	public int insert(ProductBase p);

	public void update(ProductBase p);

	/**
	 * 伪删除
	 * 
	 * @param p
	 */
	public void delete(int id);

	/**
	 * 永久删除
	 * 
	 * @param p
	 */
	public void permanentlyDelete(int id);
}
