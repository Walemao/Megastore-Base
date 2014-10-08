package com.walemao.megastore.domain;

import java.util.Date;


public class ShoppingCart {
	private int id;
	private int productBaseId;
	private int productInfoId;
	private int amount;
	private Date createtime;
	
	private ProductBase productInfo;
	private ProductInfo productColor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductBaseId() {
		return productBaseId;
	}
	public void setProductBaseId(int productBaseId) {
		this.productBaseId = productBaseId;
	}
	public int getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(int productInfoId) {
		this.productInfoId = productInfoId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public ProductBase getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductBase productInfo) {
		this.productInfo = productInfo;
	}
	public ProductInfo getProductColor() {
		return productColor;
	}
	public void setProductColor(ProductInfo productColor) {
		this.productColor = productColor;
	}
}
