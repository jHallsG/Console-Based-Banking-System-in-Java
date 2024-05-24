package com.JavaATM.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.JavaATM.displays.DisclaimerDisplay;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		DisclaimerDisplay disclaimer = context.getBean("disclaimerDisplay",DisclaimerDisplay.class);
		
		disclaimer.show();
	
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}

		System.out.println("Application closed!");
		((ClassPathXmlApplicationContext) context).close();
	}
}






/*
 * FUTURE WORKS:
 * 1. Work on jdbcImpl methods to check successful database changes before reflecting it on transactions
 *		ex: successful deposit before showing it on transaction history
 * 2. Passwords are shown as plain text :(
 * 3. Disallow negative deposits
 * 4. Transfer money needs some improvement esp error handling.
 * 5. Add some cancel options when registering, editing, transfer, deposit
 * 6. Instances of negative value error when logging in to users with long names. need to check on that
 */

