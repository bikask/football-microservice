package com.sapient.football.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.exception.TeamNotFoundException;
import com.sapient.football.model.CountryModel;
import com.sapient.football.model.Franchisee;
import com.sapient.football.model.LeagueModel;

@Service
public class FootballService {

	//@Qualifier("restTemplate")
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("#{environment.API_KEY}")
	private String key ;
	
	//= "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
	
	public Object stabdings(String name) {
		try {
			Object o = restTemplate
			.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id="+name+"&APIkey="+key 
					,
					Franchisee[].class);
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//LOG
			return null;
		}
	}
	
	public CountryModel getCountry(String countryName){
		CountryModel[] o = restTemplate
				.getForObject("https://apiv2.apifootball.com/?action=get_countries&APIkey="+key 
						,
						CountryModel[].class);
		System.out.println(o.length);
		return Arrays.asList(o).stream().filter(p -> p.getCountryName().equalsIgnoreCase(countryName)).findFirst()
				.orElseThrow(() -> new TeamNotFoundException("Country Not Found"));
	}
	
	public LeagueModel getLeagues(CountryModel cm, String leagueName){
		System.out.println("============================== "+cm);
		LeagueModel[] o = restTemplate
				.getForObject("https://apiv2.apifootball.com/?action=get_leagues&country_id="+cm.getCountryId()+"&APIkey="+key 
						,
						LeagueModel[].class);
		return Arrays.asList(o).stream().filter(p -> p.getLeagueName().equalsIgnoreCase(leagueName)).findFirst()
				.orElseThrow(() -> new TeamNotFoundException("League Not Found"));
	}
	
	public Franchisee getStandings(String leagueId, String teamName){
		System.out.println("********************** "+leagueId);
		Franchisee[] o = restTemplate
				.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id="+leagueId+"&APIkey="+key 
						,
						Franchisee[].class);
		return Arrays.asList(o).stream().filter(p -> p.getTemName().equalsIgnoreCase(teamName)).findFirst()
				.orElseThrow(() -> new TeamNotFoundException("Team Not Found"));
	}
	
}
