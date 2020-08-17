package com.sapient.football.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LeagueModel {
	@JsonAlias("country_name")
	private String countryName;
	@JsonAlias("country_id")
	private String countryId;
	@JsonAlias("league_name")
	private String leagueName;
	@JsonAlias("league_id")
	private String leagueId;
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
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	@Override
	public String toString() {
		return "LeagueModel [countryName=" + countryName + ", countryId=" + countryId + ", leagueName=" + leagueName
				+ ", leagueId=" + leagueId + "]";
	}

}
