package com.walemao.megastore.domain;

import java.util.Date;

public class ProductFavorites {
	private int id;
	private int userid;
	private int productid;
	private int colorid;
	private Date createtime;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
