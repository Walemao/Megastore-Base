package com.walemao.megastore.domain;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String mobilephone;
    private String email;
    private String createTime;
    private String loginTime;
    private String remark;
    private int type;
    private int level;
    private Boolean enabled;
    
    private UserBase ub;
    private UserDetail ud;
    
	public UserBase getUb() {
		return ub;
	}

	public void setUb(UserBase ub) {
		this.ub = ub;
	}

	public UserDetail getUd() {
		return ud;
	}

	public void setUd(UserDetail ud) {
		this.ud = ud;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
