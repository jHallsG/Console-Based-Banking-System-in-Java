package com.JavaATM.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

	@Bean
	public Disclaimer disclaimer() {
		Disclaimer disc = new Disclaimer();
		disc.setLanding(landingPage());
		return disc;
	}
	
	@Bean 
	public LandingPage landingPage() {
		return new LandingPage();
	}
}
