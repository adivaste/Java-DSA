# Lecture 27 - Stacks

> **What is stack**
> 
- A stack is a linear data structure used to store similar elements, using the principle of Last In First Out.
- Stack uses the principle LIFO (Last In First Out) or FILO(First In Last Out)
- Just like books in shelf or plates in kitchen, stack works similar to it.
- Stack has basic operations like `push()`, `pop()`, `peek()`, `isEmpty()`, `isFull()`

> **LIFO principle**
> 
- In this principle the last element is removed first from the stack, and first element is removed at very last.
- Visuals
    
    ![Untitled](Lecture%2027%20-%20Stacks%2022adc2699c2b4e58a147b14402e2afd7/Untitled.png)
    

> **Basic Operations**
> 
1. Push : Add the element to the stack
2. Pop  : Remove element from stack
3. Peek : Get the top element of stack
4. Is Empty : Check stack is empty of not ( Stack-underflow)
5. Is Full :  Check stack is full ( Stack-overflow )

> **Working of Stack Data Structure**
> 

1. A pointer called `TOP` is used to keep track of the top element in the stack.
2. When initializing the stack, we set its `TOP` value to -1 so that we can check if the stack is empty by comparing `TOP == -1`.
3. On pushing an element, we increase the value of  `TOP` and place the new element in the position pointed to by `TOP`
4. On popping an element, we return the element pointed to by `TOP` and reduce its value.
5. Before pushing, we check if the stack is already full.
6. Before popping, we check if the stack is already empty.

![Untitled](Lecture%2027%20-%20Stacks%2022adc2699c2b4e58a147b14402e2afd7/Untitled%201.png)

> **Implementing stack internally in Java**
> 
- Code
    
    ```java
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
    ```
    

> **Stack data structure internal implementation**
> 
1. Constructor
    
    ```java
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
    }
    ```
    
2. Push
    
    ```java
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
    ```
    
3. Pop
    
    ```java
    public boolean pop(){
       // Return false when stack is empty
       if (isEmpty()){
          return false;
       }
       // POP when stack is not empty
       this.TOP --;
       return true;
    }
    ```
    
4. Peek
    
    ```java
    public int peek(){
       if (!isEmpty()){
    		   return this.ARRAY[this.TOP];
       }
       System.out.println("Stack is empty !");
       return -1;
    }
    ```
    
5. Is Full
    
    ```java
    public boolean isFull(){
    		return (this.TOP == this.SIZE-1);
    }
    ```
    
6. Is Empty
    
    ```java
    public boolean isEmpty(){
    		return (this.TOP == -1);
    }
    ```
    
7. Display
    
    ```java
    public void display(){
       System.out.println("\n Stack : \n");
       for(int i=0; i <= this.TOP; i++){
    		    System.out.println(" " + this.ARRAY[i]);
    		}
    		System.out.println();
    }
    ```
    

> **Time Complexity**
> 

For the array-based implementation of a stack, the push and pop operations take constant time, i.e. `O(1)`

> **Space Complexity**
> 

For the array-based implementation of a stack, space complexity is linear as per size of stack, i.e. `O(n)`

> **Applications**
> 
- To reverse the word
- Use to check parenthesis in IDE’s
- In compiler’s to solve the equations
- In browsers as a back button, and forward buttons while navigating.