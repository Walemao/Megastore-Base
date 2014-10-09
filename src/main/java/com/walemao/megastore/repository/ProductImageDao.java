package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductImage;

public interface ProductImageDao {
	public int insert(ProductImage pi);
	public List<ProductImage> getProductImages(int productId);
	public void update(int productId, int[] ids);
}
