package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductImage;

public interface ProductImageDao {
	/**
	 * 插入
	 * @param pi
	 * @return
	 */
	public int insert(ProductImage pi);
	/**
	 * 根据产品ID获取图片
	 * @param productId
	 * @return
	 */
	public List<ProductImage> getProductImages(int productId);
	/**
	 * 根据产品ID批量更新
	 * @param productId	产品ID
	 * @param ids	传入的图片ID
	 */
	public void update(int productId, int[] ids);
	/**
	 * 删除方法
	 * @param id
	 */
	public void delete(int id);
}
