package com.walemao.megastore.domain;

import java.util.UUID;

public class UserBase {
	private UUID id;
    private String head_portrait;
    private String nickname;
    private String realname;
    private int sex;
    private String birth;
    private Boolean isval_email;
    private int provices;
    private int cities;
    private int districts;
    private String address;
    private String zipcode;
    private Boolean isval_mobilephone;
    private String telphone;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getHead_portrait() {
		return head_portrait;
	}
	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Boolean getIsval_email() {
		return isval_email;
	}
	public void setIsval_email(Boolean isval_email) {
		this.isval_email = isval_email;
	}
	public int getProvices() {
		return provices;
	}
	public void setProvices(int provices) {
		this.provices = provices;
	}
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public int getDistricts() {
		return districts;
	}
	public void setDistricts(int districts) {
		this.districts = districts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Boolean getIsval_mobilephone() {
		return isval_mobilephone;
	}
	public void setIsval_mobilephone(Boolean isval_mobilephone) {
		this.isval_mobilephone = isval_mobilephone;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
}
