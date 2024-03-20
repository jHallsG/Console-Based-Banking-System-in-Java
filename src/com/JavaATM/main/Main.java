package com.JavaATM.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JavaATM.displays.DisclaimerDisplay;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);
		
		disclaimer.show();

		
//		JDBCImplementation implem = context.getBean("jdbcImpl",JDBCImplementation.class);
//		System.out.println(implem.emailCheck("username@test.com"));
//		
//		// Get all bean names
//        String[] beanNames = jdbcConn.getBeanDefinitionNames();
//
//        // Print all bean names
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

		((ClassPathXmlApplicationContext) context).close();
	}
}
