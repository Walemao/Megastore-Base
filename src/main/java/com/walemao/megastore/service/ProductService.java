package com.walemao.megastore.service;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductImage;
import com.walemao.megastore.domain.ProductInfo;

public interface ProductService {

	public CurrentPage<ProductBase> getProducts(String parm, int classify,
			Date startTime, Date endTime, int mark);

	public int insertProduct(ProductBase p, int[] colorIds, int[] imageIds);

	public void deleteProduct(int productId);

	public int insertProductInfo(ProductInfo pi);

	public ProductInfo getProductInfo(String md5);

	public void deleteProductInfo(int id);

	public void updateProductInfo(ProductInfo pi);

	public ProductBase getProduct(int id);

	public void updateProduct(ProductBase p, int[] colorIds, int[] imagesIds);

	public List<ProductClassify> getProductClassifies();

	public int insertProductImage(ProductImage pi);

	public void deleteProductImage(int id);

}
