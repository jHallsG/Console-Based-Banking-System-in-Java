package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class DisclaimerDisplay implements ConsoleDisplays{
	private Scanner scan = new Scanner(System.in);
	@Autowired
	private WelcomeDisplay welcomeDisplay;
	@Autowired
	private ManageDisplay manageDisplay;

	public void show() {
		boolean disclaimerLoop = true;
		int retry = 0;

		System.out.print(""
				+ "*********************************************************************************************************************************************************\r\n"
				+ "Disclaimer: This ATM console project is created for personal learning and development purposes only. It is not intended to represent or emulate the \r\n"
				+ "functioning of any actual ATM machines or banking systems. The functionalities and features implemented in this project are purely for educational \r\n"
				+ "experimentation and exploration of programming concepts. This project does not involve any real banking operations or transactions. It should not \r\n"
				+ "be used for any commercial or monetary purposes. The creator of this project shall not be held responsible for any misuse or misinterpretation of the code,\r\n"
				+ "and users are solely responsible for their actions while interacting with this software. By using this ATM console project, you acknowledge that it is\r\n"
				+ "a simulated environment and not a real banking system. Any resemblance to actual ATM machines or banking interfaces is purely coincidental. Please use\r\n"
				+ "this project responsibly and ethically, and refrain from attempting to use it for any unauthorized or unlawful activities. The creator disclaims any \r\n"
				+ "liability for any damages or consequences arising from the use or misuse of this software.\r\n"
				+ "*********************************************************************************************************************************************************\r\n"
				+ "\n"
				+ "Please input (y) if you agree and (n) if you disagree: \n>> ");
		
		while (disclaimerLoop) {
			char choice = scan.next().charAt(0);
			
			switch (choice) {
			case 'y':
				manageDisplay.pushDisplay(welcomeDisplay);
				disclaimerLoop = false;
				break;
			case 'n':
				System.out.println("Exiting application...");
				System.exit(0);
				break;
			default:
				retry++;
				if (retry == 3) {
	                System.out.println("\nMultiple invalid inputs detected. Exiting application...");
	                System.exit(0);
	            }
				System.out.print("\nInvalid input. Please try again: \n>> ");
			}
		}
	}
}
