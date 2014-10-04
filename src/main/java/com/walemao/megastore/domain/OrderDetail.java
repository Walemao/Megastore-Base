package com.walemao.megastore.domain;


public class OrderDetail {
	private int id;
	private int productid;
	private int colorid;
	private int orderid;
	private int amount;
	private String remark;
	
	private ProductInfo product;
	private ProductColor productcolor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
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
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	public ProductColor getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(ProductColor productcolor) {
		this.productcolor = productcolor;
	}
	
}
