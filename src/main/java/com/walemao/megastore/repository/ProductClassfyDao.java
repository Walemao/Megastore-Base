package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductClassify;

public interface ProductClassfyDao {
	public List<ProductClassify> getProductClassifies();
	public int insert(ProductClassify p);
	public void update(ProductClassify p);
}
