package com.company;

public class Main {
    public static void main(String[] args) {

        // Creating the stack and performing basic operations
	Stack s = new Stack(5);

	// Insert element
	s.push(5);
	s.push(6);
	s.push(7);

	// Pop from stack
	s.pop();
	s.pop();
	s.pop();
	
	// Get Top
	int top = s.top();
	System.out.println(" Top : " + top);

	// Check empty
	System.out.println(" isEmpty : " + s.isEmpty());
	
	
	// Check full	
	System.out.println(" isFull : " + s.isFull());
	
	s.display();
	
    }
}
