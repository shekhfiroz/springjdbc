package com.qa.bo;

public class Companybo {
	private String company_nos;
	private String company_name;
	private String description;
	private String location;
	private String established_Date;

	public String getCompany_nos() {
		return company_nos;
	}

	public void setCompany_nos(String company_nos) {
		this.company_nos = company_nos;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEstablished_Date() {
		return established_Date;
	}

	public void setEstablished_Date(String established_Date) {
		this.established_Date = established_Date;
	}

	@Override
	public String toString() {
		return "Companybo [company_nos=" + company_nos + ", company_name=" + company_name + ", description="
				+ description + ", location=" + location + ", established_Date=" + established_Date + "]";
	}

}
