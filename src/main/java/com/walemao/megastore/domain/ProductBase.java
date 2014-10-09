package com.walemao.megastore.domain;



import java.sql.Timestamp;
import java.util.List;

public class ProductBase {
	private int id;
	private String number;
	private String name;
	private boolean recommend;
	private String thumbnail;
	private int classify;
	private String orgin;
	private String materials;
	private String desc;
	private double discount;
	private String remark;
	private Timestamp creattime;
	
	private ProductClassify productClassification;
	private List<ProductInfo> productInfos;
	private List<ProductImage> productImages;
	
	public List<ProductImage> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setProductInfos(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}
	public ProductClassify getProductClassification() {
		return productClassification;
	}
	public void setProductClassification(ProductClassify productClassification) {
		this.productClassification = productClassification;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public Timestamp getCreattime() {
		return creattime;
	}
	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
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
}
