package com.walemao.megastore.domain;

public class ProductFavorites {
	private int id;
	private int userid;
	private int productid;
	private int colorid;
	private String createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
