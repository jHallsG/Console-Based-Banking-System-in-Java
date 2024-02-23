package com.JavaATM.main;

import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class ManageDisplay {
	
	private Stack<ConsoleDisplays> displayStack = new Stack<ConsoleDisplays>();
	
	public void pushDisplay(ConsoleDisplays displays) {
		displayStack.push(displays);
		displays.show();
	}
	
	public void popDisplay() {
        if (!displayStack.isEmpty()) {
            displayStack.pop();
            ConsoleDisplays display = displayStack.peek();
            display.show();
        }
    }
}
