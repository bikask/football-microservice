package com.sapient.football.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Franchisee {

	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getTemName() {
		return temName;
	}
	public void setTemName(String temName) {
		this.temName = temName;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public Integer getOverallLeaguePosition() {
		return overallLeaguePosition;
	}
	public void setOverallLeaguePosition(Integer overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}
	@JsonAlias("country_name")
	private String countryName;
	@JsonAlias("team_name")
	private String temName;
	@JsonAlias("team_id")
	private String temId;
	@JsonAlias("league_name")
	private String leagueName;
	@JsonAlias("overall_league_position")
	private Integer overallLeaguePosition;
	public Franchisee() {
	}
	public String getTemId() {
		return temId;
	}
	public void setTemId(String temId) {
		this.temId = temId;
	}
	
}
