/*

# Striver -> Love Babber

    # Stack and Queue

    - Implementation problems, using stack, queue, ll, arrays
    - 2 stack, 3 stack and N stack
    - Parenthesis and reverse problems
    - Next greater, left and write 
    - Postfix, prefix, infix and arithmetic expression

    # Other 
    1. Middle of stack
    2. Min of list
    3. Celebrity problem
    4. Reverse the stack
    5. Sort the stack
    6. Largest rectangular area in histogram
    7. Length of longest substring
*/

// ========================== Questions & Answers =============================

// Q.1) Implement the stack using array

// :: 1. Simple code for stack
public class Stack{

    // Attributes
    private int[] stack;        // Stack implementing using array
    private int capacity;       // Max Capacity of stack
    private int top;            // Top index of stack

    // Constructors - 1
    public Stack(int capacity){
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[this.capacity];
    }

    // Constructor - 2
    public Stack(){
        this(5);
    }

    // Methods for operations

    public boolean push(int data){
        if (!isFull()){
            this.top++;
            this.stack[this.top] = data;
            return true;
        }
        return false;
    }

    public int pop(){
        if (!isEmpty()){
            int data = this.peek();
            this.top--;
            return data;
        }
        return -1;
    }

    public int peek(){
        if (!isEmpty()){
            return this.stack[this.top];
        }
        return -1;
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.capacity-1);
    }

}

// :: 2. More revised code


public class Stack {

    // Attributes
    private int[] stack;
    private int capacity;
    private int top;

    // Constructors - 1
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[this.capacity];
    }

    // Constructor - 2
    public Stack() {
        this(5);
    }

    // Methods for operations

    public void push(int data) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push element.");
        }
        this.top++;
        this.stack[this.top] = data;
    }

    public int pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty. Cannot pop element.");
        }
        int data = this.stack[this.top];
        this.top--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty. Cannot peek element.");
        }
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.capacity - 1);
    }
}

// :: 3.Some more improved code, if requires


// Custom exception for stack overflow
class StackOverflowException extends RuntimeException {
    public StackOverflowException(String message) {
        super(message);
    }
}

// Custom exception for stack underflow
class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
        super(message);
    }
}

public class Stack {

    // Attributes
    private int[] stack;
    private int capacity;
    private int top;

    // Constructors - 1
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[this.capacity];
    }

    // Constructor - 2
    public Stack() {
        this(5);
    }

    // Methods for operations

    public void push(int data) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Stack is full. Cannot push element.");
        }
        this.top++;
        this.stack[this.top] = data;
    }

    public int pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot pop element.");
        }
        int data = this.stack[this.top];
        this.top--;
        return data;
    }

    public int peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot peek element.");
        }
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.capacity - 1);
    }
}

// ============================================================================

// Q.2) Implement the Queue using Array


// Custom exception for queue underflow
class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException(String message) {
        super(message);
    }
}

public class Queue {

    // Attributes
    private int[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    // Constructors - 1
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[this.capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Constructor - 2
    public Queue() {
        this(5);
    }

    // Methods for operations

    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot enqueue element.");
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.queue[this.rear] = data;
        this.size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot dequeue element.");
        }
        int data = this.queue[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot peek element.");
        }
        return this.queue[this.front];
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public boolean isFull() {
        return (this.size == this.capacity);
    }

    public int getSize() {
        return this.size;
    }
}

// ============================================================================

// Q.3 ) Implement the Stack using Linked List

public class Stack {

    private StackNode top; // Reference to the top of the stack

    // Node for the linked list
    private class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor for an empty stack
    public Stack() {
        this.top = null;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to push/add an element to the top of the stack
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Method to pop/remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Method to peek/get the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Method to get the size/number of elements in the stack
    public int size() {
        int count = 0;
        StackNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to clear the stack and remove all elements
    public void clear() {
        top = null;
    }
}

// ============================================================================

// Q.4) Implement a Queue using the linked list


import java.util.NoSuchElementException;

public class Queue {

    private QueueNode front; // Reference to the front of the queue
    private QueueNode rear; // Reference to the rear of the queue

    // Node for the linked list
    private class QueueNode {
        int data;
        QueueNode next;

        public QueueNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor for an empty queue
    public Queue() {
        front = null;
        rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to add/enqueue an element to the rear of the queue
    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Method to remove/dequeue the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // If the queue becomes empty after dequeuing, reset rear as well
        }
        return data;
    }

    // Method to peek/get the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    // Method to get the size/number of elements in the queue
    public int size() {
        int count = 0;
        QueueNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to clear the queue and remove all elements
    public void clear() {
        front = null;
        rear = null;
    }
}

// ============================================================================

// Q.5) Implement the Stack using two queues and One Queue

// :: Approach 1 : Where are using the built-in functions of queue to push the 
// element, but while poping and retriving the peek() we are using the second
// queue q2. Such that rear of current queue q1 will be top of the stack, so
// we will poll() all the elements till size of q1 becomes 1, that last element 
// has to return. And all other elements removed before will maintain the stack 
// position same, just the top of the stack. Now we will swap out the q2 with q1 
// because actual stack exists in q2. Similar for peek() operations. And for other
// operations, we will use the queue functions.

import java.util.Queue;
import java.util.LinkedList;

public class Stack{
    
        // Stack using two queues
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // Push
        public  void push(int data){
            q1.offer(data);
        }
        
        // Pop
        public int pop(){
            if(isEmpty()) return -1;
            while(q1.size() != 1){
                q2.offer(q1.poll());
            }
            int data = q1.poll();
            
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            
            return data;
        }
        // Peek
        public int peek(){
            if (q1.isEmpty()) return -1;
            while(q1.size() != 1){
                q2.offer(q1.poll());
            }
            int data = q1.poll();
            q2.offer(data);
            
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            
            return data;
        }
        // isEmpty
        public boolean isEmpty(){
            return (q1.size() == 0);
        }
        
        // getSize
        public int getSize(){
            return q1.size();
        }

     public static void main(String []args){
        Stack s = new Stack();
        s.push(5);
        s.push(6);
        s.push(7);
        
        s.pop();
        s.pop();
        
        System.out.println(s.isEmpty());
     }
}

// :: Approach 2 : Using the Queue poll() and peek() operations this time, 
// and for insertion we will use our ones. We will insert the new element 
// inside a q2 and copy all elements from q1 to q2, and then swap the pointers.
// Queue's poll() and peek() will be used for removal and peek()


import java.util.Queue;
import java.util.LinkedList;

public class HelloWorld{
    
        // Stack using two queues
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // Push
        public  void push(int data){
            q2.offer(data);
            while(q1.size() != 0){
                q2.offer(q1.poll());
            }
            
            // Swap
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        // Pop
        public int pop(){
            if (isEmpty()) return -1;
            return q1.poll();
        }
        // Peek
        public int peek(){
            if(isEmpty()) return -1;
            return q1.peek();
        }
        // isEmpty
        public boolean isEmpty(){
            return (q1.size() == 0);
        }
        
        // getSize
        public int getSize(){
            return q1.size();
        }

     public static void main(String []args){
        HelloWorld s = new HelloWorld();
        s.push(5);
        s.push(6);
        s.push(7);
        
        s.pop();
        s.pop();
        
        System.out.println(s.peek());
     }
}

// ============================================================================
// :: Approach 3 : Here we will use the single queue, where poll() and peek()
// approach will be used as pop() and peek() for stack. And here when we are 
// inserting the element we will insert normally and other elements will be
// removed one by one and again inserted to queue. O(n)

import java.util.Queue;
import java.util.LinkedList;

public class HelloWorld{
    
        // Stack using single queues
        Queue<Integer> q1 = new LinkedList<>();
        
        // Push
        public  void push(int data){
            q1.offer(data);
            for(int i=0; i<q1.size()-1; i++){
                q1.offer(q1.poll());
            }
        }
        
        // Pop
        public int pop(){
            if (isEmpty()) return -1;
            return q1.poll();
        }
        // Peek
        public int peek(){
            if(isEmpty()) return -1;
            return q1.peek();
        }
        // isEmpty
        public boolean isEmpty(){
            return (q1.size() == 0);
        }
        
        // getSize
        public int getSize(){
            return q1.size();
        }

     public static void main(String []args){
        HelloWorld s = new HelloWorld();
        s.push(5);
        s.push(6);
        s.push(7);
        
        System.out.println(s.pop());
     }
}

// ============================================================================

// Q.6. Implement a Queue using a stacks

// Approach 1 : Use two stacks, make use of stack's pop() and peek() answer your
// own insertion method taking O(2n) time. Where you will pop out all elements to 
// other stack and put new element current stack (at bottom), and now empty the 
// other elements in current one, so that elements will be getting added from bottom
// and they will be removed from the top of the stack

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }        
        // Push
        public void push(int data){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }
        
        // Pop
        public int pop(){
            if (empty()) return -1;
            return s1.pop();
        }
        // Peek
        public int peek(){
            if(empty()) return -1;
            return s1.peek();
        }
        // isEmpty
        public boolean empty(){
            return (s1.size() == 0);
        }
}

// Approach 2 :: Using another stack with push operation taking O(1) time 
// and other approaches taking amortized or average time complexity 
// for pop() and peek() operations


class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (empty())
            return -1; // Return -1 if the queue is empty
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }

    public int peek() {
        if (empty())
            return -1; // Return -1 if the queue is empty
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

// ============================================================================
// Q.7 ) Implement a Min stack Question


class MinStack {

    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private Stack<Pair> s;

    public MinStack() {
        s = new Stack<Pair>();
    }
    
    public void push(int val) {
        int min;
        if(s.isEmpty()){
            min = val;
        }
        else{
            min = Math.min(s.peek().y, val);
        }
        s.push(new Pair(val, min));
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        s.pop();
    }
    
    public int top() {
        if (s.isEmpty()) return -1;
        return s.peek().x;
    }
    
    public int getMin() {
        if (s.isEmpty()) return -1;
        return s.peek().y;
    }
}

// ============================================================================

// Q. 8) Valid parenthesis

class Solution {
    public boolean isValid(String expression) {
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> h = new HashMap<>();
        h.put(')', '(');
        h.put(']', '[');
        h.put('}', '{');

        for(int i=0; i<expression.length(); i++){

            // Get character
            char c = expression.charAt(i);

            // If it is opening bracket then push to stack
            if (h.containsValue(c)){
                s.push(c);
            }
            
            // If it is closing bracket, get its opening pair
            // from map, and match with stack top
            // Matched :: pop()
            // No matched :: false | not balanced expression 
            else if (h.containsKey(c) && s.size() != 0){
                if (h.get(c) == s.peek()){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            // Stack is empty, still bracket in expression, means thats
            // extra part
            else if (h.containsKey(c) && s.size() == 0){
                return false;
            }
        }

        // Expression ended stil stack has something then return false
        // otherwise true
        if (s.empty()){
            return true;
        }
        return false;
    }
}

// ============================================================================
// Q.9 ) Next greater element

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> s = new Stack<>();
        ArrayList<Long> answer = new ArrayList<Long>();
        
        for(int i=arr.length-1; i>=0; i--){
            if (s.isEmpty()) answer.add((long)-1);
            else if (s.size() != 0 && s.peek() > arr[i]){
                answer.add(s.peek());
            }
            else if(!s.isEmpty() && s.peek() <= arr[i]){
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                if (s.isEmpty()) answer.add((long)-1);
                else answer.add(s.peek());
            }
            s.push(arr[i]);
        }
        
        long[] ans = new long[answer.size()];
        int i=ans.length-1;
        for(long item : answer){
            ans[i] = item;
            i--;
        }        
        return ans;
    } 
}
