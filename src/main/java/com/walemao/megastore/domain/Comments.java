package com.walemao.megastore.domain;

import java.util.Date;

public class Comments {
	private int id;
	private String username;
	private String content;
	private int type;
	private int productid;
	private int orderdetailid;
	private Date createtime;

	private ProductBase productInfo;
	private OrderDetail orderdetail;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public int getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(int orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
}
