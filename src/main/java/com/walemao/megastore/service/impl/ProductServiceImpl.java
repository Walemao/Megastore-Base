package com.walemao.megastore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.repository.ProductBaseDao;
import com.walemao.megastore.repository.ProductClassfyDao;
import com.walemao.megastore.repository.ProductInfoDao;
import com.walemao.megastore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductBaseDao productDao;
	
	@Autowired
	private ProductInfoDao productInfoDao;
	
	@Autowired
	private ProductClassfyDao productClassfyDao;
	
	
	@Override
	public List<ProductBase> getProducts(String parm, int classify, Date startTime,
			Date endTime, int mark){
		
		return this.productDao.getProducts(parm, classify, startTime, endTime, mark);
	}
	
	@Override
	public int insertProduct(ProductBase p, int[] ids) {
		int i = this.productDao.insert(p);
		this.productInfoDao.update(i, ids);
		
		return i;
	}


	@Override
	public int insertProductInfo(ProductInfo pi) {
		return this.productInfoDao.insert(pi);
	}


	@Override
	public ProductInfo getProductInfo(String md5) {
		return this.productInfoDao.getProductInfo(md5);
	}


	@Override
	public void deleteProductInfo(int id) {
		this.productInfoDao.delete(id);
	}


	@Override
	public void updateProductInfo(ProductInfo pi) {
		this.productInfoDao.update(pi);
	}


	@Override
	public ProductBase getProduct(int id) {
		ProductBase productBase = this.productDao.getProduct(id);
		List<ProductInfo> infos = this.productInfoDao.getProductInfo(id);
		
		productBase.setProductColors(infos);
		return productBase;
	}


	@Override
	public void updateProduct(ProductBase p, int[] ids) {
		this.productDao.update(p);
		this.productInfoDao.update(p.getId(), ids);
	}


	@Override
	public List<ProductClassify> getProductClassifies() {
		return this.productClassfyDao.getProductClassifies();
	}


}
