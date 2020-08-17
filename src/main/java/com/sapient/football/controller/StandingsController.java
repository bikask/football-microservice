package com.sapient.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.model.CountryModel;
import com.sapient.football.model.Franchisee;
import com.sapient.football.model.LeagueModel;
import com.sapient.football.model.TeamStandingsResponse;
import com.sapient.football.service.FootballService;

@RestController
@RequestMapping(value = "/api")
public class StandingsController {
	
	@Autowired
	FootballService fs;
	
	
	@GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

	@GetMapping(value = "/test")
	public ResponseEntity<?> getTest(){
		return ResponseEntity.ok("test");
	}
	@GetMapping(value = "/standings")
	public ResponseEntity<?> getStandings(@RequestParam(value = "country_name", required=true) String countryName,
			@RequestParam(value = "league_name", required=true) String leagueName,
			@RequestParam(value = "team_name", required=true) String teamName){
		System.out.println("----" + leagueName);
		CountryModel cm = fs.getCountry(countryName);
		LeagueModel league = fs.getLeagues(cm, leagueName);
		Franchisee franchisee = fs.getStandings(league.getLeagueId(), teamName);
		TeamStandingsResponse tsr = new TeamStandingsResponse(cm.getCountryId(), cm.getCountryName(),
				league.getLeagueId(), league.getLeagueName(), franchisee.getTemName(), franchisee.getTemName(),
				franchisee.getOverallLeaguePosition().toString());
		return ResponseEntity.ok(tsr);
	}
	
	/**
	 *  a microservice to find standings of a team playing league football match using country name, league name and team name.
	 */
}
