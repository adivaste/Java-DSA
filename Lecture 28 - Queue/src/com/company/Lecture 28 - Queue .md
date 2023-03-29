# Lecture 28 - Queue

> **What is a Queue?**
> 
- A queue is a linear data structure used to store a collection of similar elements.
- A queue uses the principle of First In First Out (FIFO) or Last In Last Out (LIFO) ordering.
- In a queue, elements are inserted at one end called the rear and removed from the other end called the front.
- Just like people waiting in a line to buy tickets, a queue works in a similar way.
- Queues have basic operations like **`enqueue()`**, **`dequeue()`**, **`front()`**, **`rear()`**, **`isEmpty()`**, and **`isFull()`**.
- Queues are used in many real-world applications like computer processors scheduling, traffic management systems, etc.

> **FIFO principle**
> 
- In this principle, the element that is added first is removed first from the queue, and the element that is added last is removed last.
- Visuals
    
    ![Untitled](Lecture%2028%20-%20Queue%2099c0fd5e8b23422db95e32ac4a8f1926/Untitled.png)
    

> **Basic Operations**
> 
1. Enqueue: Add an element to the rear end of the queue.
2. Dequeue: Remove an element from the front end of the queue.
3. Front: Get the element at the front end of the queue.
4. Rear: Get the element at the rear end of the queue.
5. Is Empty: Check whether the queue is empty or not.
6. Is Full: Check whether the queue is full or not.

> **Working of Queue Data Structure**
> 
1. A pointer called `front` is used to keep track of the front end of the queue, and another pointer called `rear` is used to keep track of the rear end of the queue.
2. When initializing the queue, we set `front` and `rear` to -1.
3. On enqueueing an element, we increase the value of `rear` and place the new element in the position pointed to by `rear`
4. On dequeuing an element, we return the element pointed to by `front` and increase its value.
5. Before enqueuing, we check whether the queue is already full.
6. Before dequeuing, we check whether the queue is already empty.

> **Implementing Queue internally in Java**
> 
1. Constructor
    
    ```java
    package com.company;
    
    public class Queue {
    
        // Constants
        private final int[] ARRAY;
        private final int SIZE;
        private int FRONT, REAR;
    
        // Constructor
        public Queue(){
            this(10);
        }
    
        public Queue(int size){
            this.SIZE = size;
            this.ARRAY = new int[SIZE];
            this.FRONT = -1;
            this.REAR = -1;
        }
    }
    ```
    
2. Enqueue
    
    ```java
    public boolean enqueue(int value){
        // Return when queue is full
        if (isFull()){
            return false;
        }
        // Add element to queue
        if (isEmpty()){
            this.FRONT = 0;
        }
        this.REAR++;
        this.ARRAY[this.REAR] = value;
        return true;
    }
    ```
    
3. Dequeue
    
    ```java
    public boolean dequeue(){
        // Return false when queue is empty
        if (isEmpty()){
            return false;
        }
        // Dequeue when queue is not empty
        if (this.FRONT == this.REAR){
            this.FRONT = -1;
            this.REAR = -1;
        } else {
            this.FRONT++;
        }
        return true;
    }
    ```
    
4. Peek
    
    ```java
    public int peek(){
        if (!isEmpty()){
            return this.ARRAY[this.FRONT];
        }
        System.out.println("Queue is empty !");
        return -1;
    }
    ```
    
5. Is Full
    
    ```java
    public boolean isFull(){
        return (this.REAR == this.SIZE-1);
    }
    ```
    
6. Is Empty
    
    ```java
    public boolean isEmpty(){
        return (this.FRONT == -1 || this.FRONT > this.REAR);
    }
    ```
    
7. Display
    
    ```java
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
    ```
    

> **Time Complexity**
> 

For the array-based implementation of a queue, the enqueue and dequeue operations take constant time, i.e. **`O(1)`**

> **Space Complexity**
> 

For the array-based implementation of a queue, space complexity is linear as per size of queue, i.e. **`O(n)`**

> **Advantages**
> 
1. Easy to implement: Array-based implementation of queue is easy to implement and can be used to solve a variety of problems.
2. Fast access: As elements of the queue are stored in contiguous memory locations, it is easy to access the elements using their index. This makes the queue faster in terms of access time compared to other data structures like linked lists.
3. Efficient memory management: The array-based implementation of a queue requires only a fixed amount of memory, which is allocated at the time of creation. This makes memory management efficient and predictable.
4. Random access: As elements are stored in an array, random access to any element of the queue is possible by using its index.

> **Disadvantages**
> 
1. Fixed size: The size of the array used in the implementation of a queue is fixed, which means that the number of elements that can be stored in the queue is limited to the size of the array.
2. Limited flexibility: Once the array is filled, it cannot accommodate any additional elements, even if there is space available in the memory. This makes the array-based implementation of a queue less flexible.
3. Inefficient insertion and deletion: Insertion and deletion of elements from the queue can be inefficient when the queue is full or almost full, as it requires the shifting of all elements to fill the gaps created by the insertion or deletion of elements.
4. Wastage of memory: The array-based implementation of a queue can waste memory if the size of the array is not chosen properly. If the array size is too large, it can lead to wastage of memory, and if it is too small, it can result in the loss of elements.

> **Applications**
> 
- In Operating Systems for process scheduling
- In printer spooling
- In networking for data packets buffering
- In simulation systems to represent waiting lines