package com.JavaATM.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Disclaimer disc = context.getBean("disclaimer", Disclaimer.class);
		
		disc.displayDisclaimer();
	}
}
