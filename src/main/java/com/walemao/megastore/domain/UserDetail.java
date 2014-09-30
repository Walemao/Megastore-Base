package com.walemao.megastore.domain;

import java.util.UUID;

public class UserDetail {
	private UUID id;
    private int material_status;
    private int education;
    private int professional;
    private int industry;
    private int income;
    private String interests;
    private String selfdesc;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getMaterial_status() {
		return material_status;
	}
	public void setMaterial_status(int material_status) {
		this.material_status = material_status;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public int getProfessional() {
		return professional;
	}
	public void setProfessional(int professional) {
		this.professional = professional;
	}
	public int getIndustry() {
		return industry;
	}
	public void setIndustry(int industry) {
		this.industry = industry;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getSelfdesc() {
		return selfdesc;
	}
	public void setSelfdesc(String selfdesc) {
		this.selfdesc = selfdesc;
	}
}
