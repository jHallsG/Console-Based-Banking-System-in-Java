package com.JavaATM.displays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;


@Component()
public class DisclaimerDisplay extends ParentClass{

	public DisclaimerDisplay(ManageDisplay manageDisplay, WelcomeDisplay welcomeDisplay) {
		super(manageDisplay, welcomeDisplay);
	}

	public void show() {
		int retry = 0;
		System.out.print(""
				+ "+-------------------------------------------------------------------------------------------------------------------------------------------------------+\n"
				+ "|                                                                    DISCLAIMER                                                                         |\n"
				+ "+-------------------------------------------------------------------------------------------------------------------------------------------------------+\n"
				+ "|This ATM console project is created for personal learning and development purposes only. It is not intended to represent or emulate the                |\n"
				+ "|functioning of any actual ATM machines or banking systems. The functionalities and features implemented in this project are purely for educational     |\n"
				+ "|experimentation and exploration of programming concepts. This project does not involve any real banking operations or transactions. It should not      |\n"
				+ "|be used for any commercial or monetary purposes. The creator of this project shall not be held responsible for any misuse or misinterpretation of      |\n"
				+ "|the code,and users are solely responsible for their actions while interacting with this software. By using this ATM console project, you acknowledge   |\n"
				+ "|that it is a simulated environment and not a real banking system. Any resemblance to actual ATM machines or banking interfaces is purely coincidental. |\n"
				+ "|Please use this project responsibly and ethically, and refrain from attempting to use it for any unauthorized or unlawful activities. The creator      |\n"
				+ "|disclaims any liability for any damages or consequences arising from the use or misuse of this software.                                               |\n"
				+ "+-------------------------------------------------------------------------------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "Please input (y) if you agree and (n) if you disagree: \n>> ");
		
		while (true) {
			char choice = scan.next().charAt(0);
			switch (choice) {
			case 'y':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(welcomeDisplay);
				return;
			case 'n':
				System.out.println("\nExiting application...");
				return;
			default:
				retry++;
				if (retry == 3) {
	                System.out.println("\nMultiple invalid inputs detected. Exiting application...");
	                return;
	            }
				System.out.print("\nInvalid input. Please try again: \n>> ");
			}
		}
	}
}
