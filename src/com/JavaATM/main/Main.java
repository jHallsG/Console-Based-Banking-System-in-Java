package com.JavaATM.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.displays.DisclaimerDisplay;
import com.JavaATM.displays.EditUserDetailsDisplay;
import com.JavaATM.displays.MainDisplay;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);
		MainDisplay main = context.getBean("mainDisplay", MainDisplay.class);
//		EditUserDetailsDisplay edit = context.getBean("editUserDetailsDisplay", EditUserDetailsDisplay.class);
//		edit.show();
//		disclaimer.show();
		main.show();
//		String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

//		((ClassPathXmlApplicationContext) context).close();
	}
}
