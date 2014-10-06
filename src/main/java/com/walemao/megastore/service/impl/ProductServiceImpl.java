package com.walemao.megastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.repository.ProductDao;
import com.walemao.megastore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public int insert(ProductInfo p) {
		return this.productDao.insert(p);
	}

}
