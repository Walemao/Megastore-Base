package com.walemao.megastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.repository.ProductBaseDao;
import com.walemao.megastore.repository.ProductInfoDao;
import com.walemao.megastore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductBaseDao productDao;
	
	@Autowired
	private ProductInfoDao productInfoDao;
	
	
	@Override
	public int insert(ProductBase p) {
		return this.productDao.insert(p);
	}


	@Override
	public int insert(ProductInfo pi) {
		return this.productInfoDao.insert(pi);
	}


	@Override
	public ProductInfo getProductInfo(String md5) {
		return this.productInfoDao.getProductInfo(md5);
	}

}
