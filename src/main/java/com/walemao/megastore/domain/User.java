package com.walemao.megastore.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String mobilephone;
    private String email;
    private String createTime;
    private String loginTime;
    private String remark;
    private int type;
    private int level;
    private boolean enabled;
    
    private UserBase userbase;
    private UserDetail userdetail;
    
	public UserBase getUserbase() {
		return userbase;
	}

	public void setUserbase(UserBase userbase) {
		this.userbase = userbase;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
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

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
