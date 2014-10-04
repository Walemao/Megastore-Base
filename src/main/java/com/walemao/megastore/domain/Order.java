package com.walemao.megastore.domain;

import java.math.BigDecimal;

import java.util.List;

public class Order {
	private int id;
	private String createtime;
	private int addressid;
	private int confirmid;
	private int state;
	private BigDecimal fee;
	private BigDecimal freight;
	private String remark;
	private int paytype;
	private List<OrderDetail> list;
	public List<OrderDetail> getList() {
		return list;
	}
	public void setList(List<OrderDetail> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getConfirmid() {
		return confirmid;
	}
	public void setConfirmid(int confirmid) {
		this.confirmid = confirmid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public BigDecimal getFreight() {
		return freight;
	}
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
}
