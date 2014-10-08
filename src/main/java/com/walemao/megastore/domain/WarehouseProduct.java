package com.walemao.megastore.domain;

import java.util.Date;

public class WarehouseProduct {
	private int id;
	private int productid;
	private int typeid;
	private int amount;
	private Date createtime;
	
	private ProductInfo productytpe;
	private ProductBase product;
	
	public ProductBase getProduct() {
		return product;
	}
	public void setProduct(ProductBase product) {
		this.product = product;
	}
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
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public ProductInfo getProductytpe() {
		return productytpe;
	}
	public void setProductytpe(ProductInfo productytpe) {
		this.productytpe = productytpe;
	}
	
}
