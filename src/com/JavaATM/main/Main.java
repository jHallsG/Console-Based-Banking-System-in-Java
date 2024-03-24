package com.JavaATM.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.displays.BalanceDisplay;
import com.JavaATM.displays.DisclaimerDisplay;
import com.JavaATM.displays.EditUserDetailsDisplay;
import com.JavaATM.displays.MainDisplay;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);

		disclaimer.show();
		
//		BalanceDisplay balanceDisplay = context.getBean("balanceDisplay",BalanceDisplay.class);
//		balanceDisplay.show();
		
		
		
//		String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

//		((ClassPathXmlApplicationContext) context).close();
	}
}
