package com.sapient.football;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
//@ComponentScan("com.sapient")
//@ConditionalOnClass(RestTemplate.class)
//@ConditionalOnMissingClass //TODO: can ignore this for our usecase
public class ServiceConfig {

	@Bean//(name="restTemplateByConf")
	@ConditionalOnBean 
	//@ConditionalOnMissingBean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
