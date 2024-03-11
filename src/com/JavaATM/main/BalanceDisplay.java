package com.JavaATM.main;

import org.springframework.stereotype.Component;

@Component
public class BalanceDisplay extends ParentClass{
	
	public void show() {
		System.out.println(""
				+ "+--------------------------------+\n"
				+ "|             BALANCE            |\n"
				+ "+--------------------------------+\n"
				+ "|         PHP:                   |\n"
				+ "+--------------------------------+\n");
		
		pause();
	}
	
	public void pause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ClearConsoleScreen();
	}

}
