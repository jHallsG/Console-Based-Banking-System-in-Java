package com.JavaATM.displays;

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
        displayStack.pop();
        if ((displayStack.peek() instanceof LoginDisplay)) {
        	displayStack.pop();
        }
        
        ConsoleDisplays display = displayStack.peek();
        display.show();
    }
}
