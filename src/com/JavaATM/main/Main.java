package com.JavaATM.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
//		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);
		EditDisplay disclaimer = context.getBean("editDisplay",EditDisplay.class);
		
		disclaimer.show();
		
//		// Get all bean names
//        String[] beanNames = context.getBeanDefinitionNames();
//
//        // Print all bean names
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
		((AnnotationConfigApplicationContext) context).close();
	}
}
