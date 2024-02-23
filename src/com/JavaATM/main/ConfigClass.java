package com.JavaATM.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

	@Bean
	public DisclaimerDisplay disclaimer() {
		DisclaimerDisplay disc = new DisclaimerDisplay();
		disc.setManage(manageDisplay());
		disc.setWelcome(welcomeDisplay());
		return disc;
	}
	
	@Bean
	public ManageDisplay manageDisplay() {
		return new ManageDisplay();
	}
	
	@Bean
	public ConsoleDisplays disclaimerDisplay() {
		return new DisclaimerDisplay();
	}
	
	@Bean
	public WelcomeDisplay welcomeDisplay() {
		WelcomeDisplay welcome = new WelcomeDisplay();
		welcome.setLogin(loginDisplay());
		welcome.setManage(manageDisplay());
		welcome.setReg(regDisplay());
		return welcome;
	}
	
	@Bean
	public LoginDisplay loginDisplay() {
		return new LoginDisplay();
	}
	
	@Bean RegisterDisplay regDisplay() {
		return new RegisterDisplay();
	}
}
