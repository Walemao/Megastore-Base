package com.walemao.megastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.repository.ProductBaseDao;
import com.walemao.megastore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductBaseDao productDao;
	
	
	@Override
	public int insert(ProductBase p) {
		return this.productDao.insert(p);
	}

}
