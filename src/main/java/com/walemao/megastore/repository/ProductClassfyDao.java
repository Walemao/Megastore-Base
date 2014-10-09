package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductClassify;

public interface ProductClassfyDao {
	/**
	 * 获取商品分类列表
	 * @return
	 */
	public List<ProductClassify> getProductClassifies();
	/**
	 * 插入
	 * @param p
	 * @return
	 */
	public int insert(ProductClassify p);
	/**
	 * 更新
	 * @param p
	 */
	public void update(ProductClassify p);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id);
}
