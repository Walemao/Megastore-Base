package com.walemao.megastore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductImage;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.repository.ProductBaseDao;
import com.walemao.megastore.repository.ProductClassfyDao;
import com.walemao.megastore.repository.ProductImageDao;
import com.walemao.megastore.repository.ProductInfoDao;
import com.walemao.megastore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductBaseDao productBaseDao;

	@Autowired
	private ProductInfoDao productInfoDao;

	@Autowired
	private ProductClassfyDao productClassfyDao;

	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public CurrentPage<ProductBase> getProducts(String parm, int classify,
			Date startTime, Date endTime, int mark) {

		return this.productBaseDao.getProducts(parm, classify, startTime,
				endTime, mark);
	}

	@Override
	public int insertProduct(ProductBase p, int[] colorIds, int[] imageIds) {
		int i = this.productBaseDao.insert(p);
		this.productInfoDao.update(i, colorIds);
		this.productImageDao.update(i, imageIds);

		return i;
	}

	@Override
	public void deleteProduct(int productId) {
		this.productBaseDao.delete(productId);
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
		ProductBase productBase = this.productBaseDao.getProduct(id);
		List<ProductInfo> infos = this.productInfoDao.getProductInfo(id);
		List<ProductImage> images = this.productImageDao.getProductImages(id);

		productBase.setProductColors(infos);
		productBase.setProductImages(images);
		return productBase;
	}

	@Override
	public void updateProduct(ProductBase p, int[] colorIds, int[] imagesIds) {
		this.productBaseDao.update(p);
		this.productInfoDao.update(p.getId(), colorIds);
		this.productImageDao.update(p.getId(), imagesIds);
	}

	@Override
	public List<ProductClassify> getProductClassifies() {
		return this.productClassfyDao.getProductClassifies();
	}

	@Override
	public int insertProductImage(ProductImage pi) {
		return this.productImageDao.insert(pi);
	}

	@Override
	public void deleteProductImage(int id) {

		this.productImageDao.delete(id);
	}

}
