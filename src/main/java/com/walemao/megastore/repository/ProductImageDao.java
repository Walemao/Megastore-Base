package com.walemao.megastore.repository;

import com.walemao.megastore.domain.ProductImage;

public interface ProductImageDao {
	public int insert(ProductImage pi);

	public void update(int productId, int[] ids);
}
