package com.sapient.football;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sapient.football.model.CountryModel;
import com.sapient.football.model.Franchisee;
import com.sapient.football.model.LeagueModel;
import com.sapient.football.service.FootballService;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	FootballService fs;

	@Test
	public void testtest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/test"))
		//andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(
						Matchers.containsString("test")));
	}
	
	@Test
	public void testEndpoint_success() throws Exception {
		CountryModel f = new CountryModel();
		f.setCountryName("Honululu");
		f.setCountryId("101");
		Mockito.when(fs.getCountry(Mockito.anyString())).thenReturn(f);
		LeagueModel lm = new LeagueModel();
		lm.setLeagueName("Mandrake");
		lm.setLeagueId("102");
		Mockito.when(fs.getLeagues(Mockito.any(), Mockito.anyString())).thenReturn(lm);
		Franchisee fr = new Franchisee();
		fr.setTemName("Phantom");
		fr.setOverallLeaguePosition(2);
		fr.setTemId("103");
		Mockito.when(fs.getStandings(Mockito.anyString(), Mockito.anyString())).thenReturn(fr);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/standings?country_name=Mandrake&league_name=Mandrake&team_name=Phantom"))
		//andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk())
				//.andExpect(MockMvcResultMatchers.content().string(
						//Matchers.containsString("Honululu")))
		;
	}
	
	@Test
	public void testtest_eror() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/standing"))
		//andDo(print())
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
