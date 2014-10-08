package com.walemao.megastore.domain;

import java.util.Date;

public class OrderDetail {
	private int id;
	private int productid;
	private int typeid;
	private int orderid;
	private int amount;
	private String remark;
	private Date createtime;

	private ProductBase product;
	private ProductInfo producttype;

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

	public ProductBase getProduct() {
		return product;
	}

	public void setProduct(ProductBase product) {
		this.product = product;
	}

	public ProductInfo getProducttype() {
		return producttype;
	}

	public void setProducttype(ProductInfo producttype) {
		this.producttype = producttype;
	}
}
