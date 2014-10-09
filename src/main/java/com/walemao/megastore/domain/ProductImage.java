package com.walemao.megastore.domain;

public class ProductImage {
	private int id;
	private String picSrc;
	private String picMd5;
	private int sort;
	private int productid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	public String getPicMd5() {
		return picMd5;
	}
	public void setPicMd5(String picMd5) {
		this.picMd5 = picMd5;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
}
