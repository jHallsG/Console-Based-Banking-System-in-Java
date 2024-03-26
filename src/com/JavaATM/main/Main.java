package com.JavaATM.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JavaATM.displays.DisclaimerDisplay;
import com.JavaATM.displays.ViewDetailsDisplay;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
//		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);
//		
//		
//		disclaimer.show();
		
		ViewDetailsDisplay view = context.getBean("viewDetailsDisplay",ViewDetailsDisplay.class);
		view.show();
		
//		BalanceDisplay balanceDisplay = context.getBean("balanceDisplay",BalanceDisplay.class);
//		balanceDisplay.show();
		
		
		
//		String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

		System.out.println("Application closed!");
		((ClassPathXmlApplicationContext) context).close();
	}
}
