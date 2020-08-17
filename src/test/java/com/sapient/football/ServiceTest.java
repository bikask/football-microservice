package com.sapient.football;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.exception.TeamNotFoundException;
import com.sapient.football.model.CountryModel;
import com.sapient.football.service.FootballService;

@SpringBootTest
public class ServiceTest {
	@Mock
	RestTemplate rs ;
	
	@InjectMocks
	FootballService fs;

	/*
	 * @BeforeEach public void init() {
	 * MockitoAnnotations.initMocks(FootballService.class); }
	 */
	
	@Test
	public void test() {
		CountryModel f = new CountryModel();
		f.setCountryName("Honululu");
		f.setCountryId("123");
		
		Mockito.when(rs.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(new CountryModel[]{f});
		Assertions.assertEquals(f, fs.getCountry("Honululu"));
	}
	
	@Test
	public void test_entityNotFound() {
		CountryModel cm[] = new CountryModel[0];
		Mockito.when(rs.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(cm);
		try {
			fs.getCountry("Paris");
		} catch (Exception e) {
			Assertions.assertTrue(e instanceof TeamNotFoundException);
			Assertions.assertEquals("Country Not Found", e.getMessage());
		}
	}
	
	
}
