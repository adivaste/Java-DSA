package com.company;

public class Stack {
    
    // Constants
    private final int[] ARRAY;
    private final int SIZE;
    private int TOP;

    // Constructor
    public Stack(){
    	this(10);
    }

    public Stack(int size){
        this.SIZE = size;
        this.ARRAY = new int[SIZE];
        this.TOP = -1;
    }

    // Add the elements to stack
    public boolean push(int value){

        // Return when stack is full
        if (isFull()){
            return false;
        }
        
        // Add element to stack
        this.TOP ++;
        this.ARRAY[this.TOP] = value;
        return true;
    }

    // Remove element from stack
    public boolean pop(){
	
	// Return false when stack is empty
	if (isEmpty()){
		return false;	
	}

	// POP when stack is not empty
	this.TOP --;
	return true;
    }

    // Get the top element
    public int peek(){
	    if (!isEmpty()){
		    return this.ARRAY[this.TOP];
	    }
	    System.out.println("Stack is empty !");
	    return -1;
    }

    // Display the stack
    public void display(){
	    System.out.println("\n Stack : \n");
	    for(int i=0; i <= this.TOP; i++){
		System.out.println(" " + this.ARRAY[i]);
	    }
	    System.out.println();
    }

    // Check stack is full
    public boolean isFull(){
        return (this.TOP == this.SIZE-1);
    }

    // Check stack is empty
    public boolean isEmpty(){
	    return (this.TOP == -1);
    }

}
