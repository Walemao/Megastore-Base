package com.walemao.megastore.domain;


import java.util.Date;
import java.util.List;

public class ProductBase {
	private int id;
	private String number;
	private String name;
	private boolean recommend;
	private String thumbnail;
	private List<String> images;
	private int type;
	private String orgin;
	private String materials;
	private String desc;
	private double discount;
	private String remark;
	private Date creattime;
	
	private ProductClassification productClassification;
	private List<ProductInfo> productInfos;
	
	public ProductClassification getProductClassification() {
		return productClassification;
	}
	public void setProductClassification(ProductClassification productClassification) {
		this.productClassification = productClassification;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public List<String> getImages() {
		return images;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<ProductInfo> getProductInfos() {
		return productInfos;
	}
	public void setProductColors(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getOrgin() {
		return orgin;
	}
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreattime() {
		return creattime;
	}
}
