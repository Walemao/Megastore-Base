package com.walemao.megastore.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ProductType {
	private int id;
	private int productid;
	private String thumbnail;
	private String thummd5;
	private BigDecimal price;
	private String name;
	private int amount;
	private Date createtime;

	public String getThummd5() {
		return thummd5;
	}

	public void setThummd5(String thummd5) {
		this.thummd5 = thummd5;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}