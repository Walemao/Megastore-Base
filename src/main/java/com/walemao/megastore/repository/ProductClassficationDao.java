package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.ProductClassification;

public interface ProductClassficationDao {
	public List<ProductClassification> getProductClassifications();
	public int insert(ProductClassification p);
	public void update(ProductClassification p);
}
