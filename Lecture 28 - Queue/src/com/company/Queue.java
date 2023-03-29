package com.company;

public class Queue {

    // Constants
    private final int[] array;
    private final int size;
    private int front;
    private int rear;


    // Constructors
    public Queue(){
        this(5);
    }

    public Queue(int size){
        this.size = size;
        this.array = new int[this.size];
        this.front = -1;
        this.rear = -1;
    }

    // Methods
    public boolean enqueue(int value){
        // When Queue is full
        if (isFull()){
            return false;
        }
        // When Queue is empty
        if (isEmpty()){
            this.front = 0;
        }
        // Adding generally
        this.rear++;
        this.array[this.rear] = value;
        return true;
    }

    // Delete from the queue
    public boolean dequeue(){
	// When queue is empty
	if (isEmpty()){
        return false;
	}

	// When rear and front are same | only one element
	// exists in queue
	if (this.front == this.rear){
	    this.front = -1;
	    this.rear = -1;
	}
	else{
	    this.front++;
	}
	return true;
    }

    // Get Front of queue
    public int front(){
	if (!isEmpty()){
	    return this.array[this.front];
	}
	System.out.println("Queue is empty !");
	return -1;
    }

    // Get Rear for queue
    public int rear(){
	if (!isEmpty()){
	    return this.array[this.rear];
	}	
	System.out.println("Queue is empty !");
	return -1;
    }

    // Display the Queue
    public void display(){
        if (isEmpty()){
            return;
        }
	    System.out.println("\n Queue : \n");
	    for (int i=this.front; i<=this.rear; i++){
	        System.out.println(" " + this.array[i]);
	    }
	    System.out.println();
    }

    // Check is it full
    public boolean isFull() {
        return (this.rear == this.size-1);
    }

    // Check is it empty
    public boolean isEmpty() {
        return (this.rear == -1);
    }
}
