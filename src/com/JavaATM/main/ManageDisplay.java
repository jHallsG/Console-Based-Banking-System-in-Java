package com.JavaATM.main;

import java.util.Stack;

import org.springframework.stereotype.Component;

@Component("manageDisplay")
public class ManageDisplay {
	
	private Stack<ConsoleDisplays> displayStack;
	
	public void pushDisplay(ConsoleDisplays displays) {
		displayStack.push(displays);
	}
	
	public void popDisplay() {
        if (!displayStack.isEmpty()) {
            displayStack.pop();
        }
    }
	
	public void showDisplay() {
		displayStack.peek();
	}
}
