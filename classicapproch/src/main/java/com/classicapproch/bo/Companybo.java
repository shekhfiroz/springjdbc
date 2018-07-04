package com.classicapproch.bo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((company_nos == null) ? 0 : company_nos.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((established_Date == null) ? 0 : established_Date.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Companybo other = (Companybo) obj;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (company_nos == null) {
			if (other.company_nos != null)
				return false;
		} else if (!company_nos.equals(other.company_nos))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (established_Date == null) {
			if (other.established_Date != null)
				return false;
		} else if (!established_Date.equals(other.established_Date))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

}
