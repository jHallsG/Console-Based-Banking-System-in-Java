package com.JavaATM.main;

import java.util.Scanner;

public class HiddenScanner {
	 // Method to hide user input
    public static String hideInput(Scanner scanner) {
        if (System.console() != null) {
            StringBuilder input = new StringBuilder();
            while (true) {
                char[] c = System.console().readPassword(); // Read characters
                if (c == null || c.length == 0) {
                    break; // Break loop if input is empty
                }
                for (char ch : c) {
                    input.append(ch);
                }
                break; // Break loop after reading input
            }
            return input.toString();
        } else {
            return scanner.nextLine(); // Fallback to scanner input if console is not available
        }
    }
}