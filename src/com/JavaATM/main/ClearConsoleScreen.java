package com.JavaATM.main;

public class ClearConsoleScreen {

	public ClearConsoleScreen() {
		for (int i = 0 ; i <= 50 ; i++) {
			System.out.println("\n");
		}
	}
	
	public static void pause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
