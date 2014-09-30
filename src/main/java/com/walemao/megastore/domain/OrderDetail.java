package com.walemao.megastore.domain;

import java.util.UUID;

public class OrderDetail {
	private UUID id;
	private UUID productid;
	private int colorid;
	private int orderid;
	private int amount;
	private String remark;
	
	private Product product;
	private ProductColor productcolor;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getProductid() {
		return productid;
	}
	public void setProductid(UUID productid) {
		this.productid = productid;
	}
	public int getColorid() {
		return colorid;
	}
	public void setColorid(int colorid) {
		this.colorid = colorid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductColor getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(ProductColor productcolor) {
		this.productcolor = productcolor;
	}
	
}
