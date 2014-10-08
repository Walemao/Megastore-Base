package com.walemao.megastore.service;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;

public interface ProductService {
	public int insert(ProductBase p);
	
	public int insert(ProductInfo pi);
	
	public ProductInfo getProductInfo(String md5); 
	
}
