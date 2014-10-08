package com.walemao.megastore.service;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;

public interface ProductService {
	public int insertProductBase(ProductBase p);
	
	public int insertProductInfo(ProductInfo pi);
	
	public ProductInfo getProductInfo(String md5); 
	
	public void deleteProductInfo(int id);
	
	public void updateProductInfo(ProductInfo pi);
	
}
