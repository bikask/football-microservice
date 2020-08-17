package com.sapient.football.model;

public class TeamStandingsResponse {

	private String countryId;
	private String countryName;
	private String leagueId;
	private String leagueName;
	private String teamId;
	private String teamName;
	private String overAllLeaguePosition;
	
	public TeamStandingsResponse(String countryId, String countryName, String leagueId, String leagueName,
			String teamId, String teamName, String overAllLeaguePosition) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.overAllLeaguePosition = overAllLeaguePosition;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOverAllLeaguePosition() {
		return overAllLeaguePosition;
	}

	public void setOverAllLeaguePosition(String overAllLeaguePosition) {
		this.overAllLeaguePosition = overAllLeaguePosition;
	}
	
	

} 



/**
 * Country ID & Name: (<ID>) - <name>
League ID & Name: (<ID>) - <name>
Team ID & Name: (<ID>) - <name>
Overall League Position: <position>
 */
