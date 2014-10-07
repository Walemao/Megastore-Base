package com.walemao.megastore.domain;

import java.util.Date;


public class WarehouseProductRejected {
	private int id;
	private int productid;
	private int productColorId;
	private Date createtime;
	private String remark;
	
	private ProductType producttype;
	private ProductInfo product;

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ProductType getProducttype() {
		return producttype;
	}
	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
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
	public int getProductColorId() {
		return productColorId;
	}
	public void setProductColorId(int productColorId) {
		this.productColorId = productColorId;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
