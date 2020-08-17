package com.sapient.football.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CountryModel {
	
	@JsonAlias("country_name")
	private String countryName;
	@JsonAlias("country_id")
	private String countryId;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "CountryModel [countryName=" + countryName + ", countryId=" + countryId + "]";
	}

}
