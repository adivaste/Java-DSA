/* 
1. Reverse Array
2. Reverse string
3. Reverse order of words in string
4. Reverse individual words in string keeping order same
5. Reverse stack using Stack 
6. Reverse stack using Queue
7. Reverse stack using Recursion
8. Reverse Queue using Queue ==> Not possible without recursion
9. Reverse Queue using using Stack
10. Reverse Queue using recursion
11. Reverse first half of stack : Use extra Queue as a reversal part OR Using two stacks
12. Reverse second half of stack : Use two stacks, one for temp. storing purpose another for reversal purpose
13. Reversing the first K element of the stack : same using two stacks
14. Reversing the last K element of the stack : Using one queue OR Two stacks
15. Reversing the first K elements of the Queue : Use one stack for reversal and use original queue to maintain order
16. Reversing the last K elements of the Queue : Use one queue for storing first elements and reverse remaining K via stack then rearrange || rearrange k element so they come at first, then reverse using traditional way and again rearrange.
*/ 

// 1,2,3,4,5
//
//  
//  
//
//  
//  
//
//  5,4,3,2,1



// 1. Reverse Array  
import java.util.Stack;

public class ReverseArray{
    public static void main(String[] args){
        
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1,2,3,4,5,6};
        
        // Insert the values to stack
        for(int i=0; i<arr.length; i++){
            stack.push(arr[i]);
        }

        // Pop out from stack and store into Array
        int counter = 0;
        while(!stack.isEmpty()){
            int topElement = stack.pop();
            arr[counter] = topElement;
            counter++;
        }

        // Output : [5, 4, 3, 2 ,1]
    }
}


// 2. Reverse the string
import java.util.Stack;

public class ReverseString{
    public static void main(String[] args){
        
        // String Input
        String word = "SKNCOE";

        // Stack to store and Reverse the Array
        Stack<Character> stack = new Stack<>();

        // Convert the string to Array of characters
        char[] charactersArray = word.toCharArray();

        // Push the characters into stack
        for(char ch : charactersArray){
            stack.push(ch);
        }

        // Pop out elements from stack and insert to charactersArray
        int counter = 0;
        while(!stack.isEmpty()){
            char element = stack.pop();
            charactersArray[counter] = element;
            counter++;
        }

        // Reconstruct the string fron characters Array
        String reversedWord = new String(charactersArray);

        System.out.println(reversedWord);
    }
}


// 3. Reverse the order of the words inside a string
/*
 *  => "hello how are you" 
 *  => "you are how hello" 
 *  
 */

import java.util.Stack;

public class ReverseOrderOfWords{
    public static void main(String[] args){

        // String Input
        String sentence = "hello how are you";

        // Split the string into list
        String[] words = sentence.split(" ");

        // Stack 
        Stack<String> stack = new Stack<>();
        for(String word: words){
            stack.push(word);
        }

        // Pop out the words from stack
        int counter = 0;
        while(!stack.isEmpty()){
            String element = stack.pop();
            words[counter] = element;
            counter++;
        }

        // Rejoin the words to form a string
        String reversedOrder = String.join(" ", words);

        System.out.println(reversedOrder);
    }
}


// 4. Reverse the individual words inside a strign keeping the order of words same
/*
 * ==> "hello how are you" 
 * ==> "olleh woh era uoy"
 */

import java.util.Stack;

public class ReverseWordKeepingOrderSame{

    public static void main(String[] args){
        
        // Input string
        String sentence = "hello how are you";

        // Convert sentence to words
        String[] words = sentence.split(" ");

        // Reverse each words from a list
        for(int i=0; i<words.length; i++){
            String word = words[i];
            String reversedWord = reverseWord(word);
            words[i] = reversedWord;
        }

        // Join the list to form a string
        String answer = String.join(" ", words);
        System.out.println(answer);
    }

    public static String reverseWord(String str){
        
        // Convert  the word to charactersArray 
        char[] charactersArray = str.toCharArray();
        
        // Stack to push and pop out element
        Stack<Character> stack = new Stack<>();
        for(char ch: charactersArray){
            stack.push(ch);
        }

        // Pop out elements from stack
        int counter = 0;
        while(!stack.isEmpty()){
            charactersArray[counter] = stack.pop();
            counter++;
        }

        String reversedWord = new String(charactersArray);
        return reverseWord;
    }
}

// 5. Reverse the stack using the stack
/*
 *  1             
 *  2         
 *  3        
 *  4        
 *  5        
 * S1  S2   S3
 *
 */

import java.util.Stack;

public class ReverseStack{

    // Using one extra stack and changing the reference
    public static Stack<Integer> reverseStack1(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<>();

        while(!s1.isEmpty()){
            int element = s1.pop();
            s2.push(element);
        }

        s1 = s2;
        return s1;
    }

    // Using two stacks without changing the reference
    public static Stack<Integer> reverseStack2(Stack<Integer> s1){
        
        // Create two stacks
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        // Pop out from s1 and push it to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        
        // Pop out from s2 and push it to s3
        while(!s2.isEmpty()){
            s3.push(s2.pop());
        }
        
        // Pop out from s3 and push it to s1
        while(!s3.isEmpty()){
            s1.push(s3.pop());
        }

        return s1;
    }

    public static void main(String[] args){

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        Stack<Integer> res1 = reverseStack1(s);

        for(int ele : res1){
            System.out.println(ele);
        }

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        Stack<Integer> res2 = reverseStack2(s);
        
        for(int ele : res2){
            System.out.println(ele);
        }

    }
}

// 6. Reverse stack using Queue
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseStackUsingQueue{
    public static void main(String[] args) {
        // Create the stack
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // Create the Queue
        Queue<Integer> queue = new LinkedList<Integer>();
        while (!s.isEmpty()) {
            queue.offer(s.pop());
        }

        // Push into stack
        while(!queue.isEmpty()){
            s.push(queue.pop());
        }

    }
}

// 7. Reverse stack using Recursion
// Simple approach is to reverse the remaining array and insert at the bottom
// for insertAtBottom() it says, I will pop out myself, and handle you to next
// call so that they will take care and after inserting at the end, I will push
// myself in.

import java.util.Stack;

public class ReverseStackUsingRecursion{

    public void reverseStack(Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }

        int element = s.pop();
        reverseStack(s);
        insertAtBottom2(s, element);
    }

    public void insertAtBottom1(Stack<Integer> s, int element){
        if (s.isEmpty()){
            s.push(element);
            return;
        }

        int ele = s.pop();
        insertAtBottom(s, element);
        s.push(ele);
    }

    public void insertAtBottom2(Stack<Integer> s, int element){

        Stack<Integer> auxStack = new Stack<>();
        while(!s.isEmpty()){
            auxStack.push(s.pop());
        }

        s.push(element);

        while(!auxStack.isEmpty()){
            s.push(auxStack.pop());
        }
    }
}

// 8. Reverse Queue using Queue :: Not possible without recursion ==> Not possible

// 9. Reverse the Queue using Stack
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueueUsingStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        while (!queue.isEmpty()) {
            s.push(queue.poll());
        }
        while (!s.isEmpty()) {
            queue.offer(s.pop());
        }
        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}

// 10. Reverse the Queue using Recursion
import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueueUsingRecursion{
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        System.out.println("Original Queue : " + q);
        reverseQueue(q);
        System.out.println("Revesed Queue : " + q);
    }

    public static void reverseQueue(Queue<Integer> q){
        if (q.isEmpty()){
            return;
        }

        int front = q.poll();
        reverseQueue(q);
        q.offer(front);
    }
}

// 11. Reverse the first half of the stack
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseFirstHalf{

    public static void reverseFirstHalf(Stack<Integer> s, int count){

        // Element skip count
        int skipElementCount = s.size() - count;

        // Create auxStack and push unneccessory elements
        Stack<Integer> auxStack = new Stack<>();
        while (!s.isEmpty() && skipElementCount != 0) {
            auxStack.push(s.pop());
            skipElementCount--;
        }

        // Use queue for reversal of the stack
        Queue<Integer> queue = new LinkedList<Integer>();
        while (s.isEmpty()){
            queue.offer(s.pop());
        }

        // POLL the element from the stack and push again to stack
        // [Stack has reversed first part here]
        while (queue.isEmpty()){
            s.push(queue.poll());
        }

        // Pop elements from auxStack() and push to original stack
        while(!auxStack.isEmpty()){
            s.push(auxStack.pop());
        }
    }
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        int count = s.size()/2;
        reverseFirstHalf(s, count);
    }
}

// 12. Reverse the first half of the stack using recursion
import java.util.Stack;
        import java.util.Queue;
        import java.util.LinkedList;

public class ReverseFirstHalfRecursion{

    public static void reverseFirstHalf(Stack<Integer> s, int size, int counter){
        if (s.isEmpty()) return;
        if (counter <= size/2) {
            int top = s.pop();
            reverseFirstHalf(s, size, counter - 1);
            insertAtBottom(s, top);
        } else {
            int top = s.pop();
            reverseFirstHalf(s, size, counter - 1);
            s.push(top);
        }

    }

    public static void insertAtBottom(Stack<Integer> s, int element){
        if (s.isEmpty()){
            s.push(element);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, element);
        s.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        reverseFirstHalf(s, s.size(), s.size());
        System.out.println(s);
    }
}

// 13. Reverse the second half of the stack iteratively
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseSecondHalf{

    public static void reverseSecondHalf(Stack<Integer> s){

        int count = s.size()/2;

        // Store the second half in the queue for reversal
        Queue<Integer> q = new LinkedList<>();

        // Pop out the element
        while(!s.isEmpty() && count != 0){
            int top = s.pop();
            q.offer(top);
            count--;
        }

        // Now push element from Queue to stack (reverse order)
        while (!q.isEmpty()){
            s.push(q.poll());
        }

    }
    public static void main(String[] args) {

        // Create the stack
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        reverseSecondHalf(s);
        System.out.println(s);
    }
}

// 14. Reversing the second half of the stack : Recursively
public class ReverseSecondHalfRecursive{

    public static void reverseSecondHalf(Stack<Integer> s, int size, int counter){
        if(s.isEmpty()) return;
        if(counter > size){
            int top = s.pop();
            reverseSecondHalf(s, size, counter-1);
            insertAtBottom(s, size, top);
        }
        else{
            return;
        }
    }

    public static void insertAtBottom(Stack<Integer> s, int size, int element){
        if (s.size() == size/2){
            s.push(element);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, size, element);
        s.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        reverseSecondHalf(s, s.size(), s.size());
    }
}

// ==================== Basic Questions =========================

// Implement the Stack using the Queue
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackUsingQueue{

    private Queue<Integer> originalQueue;
    private Queue<Integer> helperQueue;

    public StackUsingQueue(){
        originalQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return this.originalQueue.isEmpty();
    }
    public void push(int value){
        
        // Withdraw all element from original queue and push to helper queue
        while(!this.originalQueue.isEmpty()){
            this.helperQueue.offer(originalQueue.poll());
        }

        this.originalQueue.offer(value);

        // Push elements to original queue
        while (!this.helperQueue.isEmpty()){
            this.originalQueue.offer(helperQueue.poll());
        }
    }

    public int pop(){
        if (this.originalQueue.isEmpty()){
            return -1;
        }
        return this.originalQueue.poll();
    }

    public int peek(){
        if (this.originalQueue.isEmpty()){
            return -1;
        }
        return this.originalQueue.peek();
    }

    public void print(){
        System.out.println("Stack: " + this.originalQueue );
    }

    public static void main(String[] args){
        StackUsingQueue sq = new StackUsingQueue();
        sq.push(34);
        sq.push(56);
        sq.push(54);
        sq.pop();
        sq.push(69);

        sq.print();
    }
}

// While inserting remove all elements from queue and store it queue, now insert the element 
// and now push all elements to queue

// Original Queue : [4,3,2,1]
// 5,
// ^
// Helping Queue  : []

// Implement the Stack using the Deque
import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque{

    // Attributes
    private Deque<Integer> deque;

    // Constructor
    public StackUsingDeque(){
        deque = new ArrayDeque<Integer>();
    }

    // Methods
    public boolean isEmpty(){
        return deque.isEmpty();
    }

    public void push(int val){
        deque.offerLast(val);
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return deque.pollLast();
    }

    public int peek(){
        if (isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    public void print(){
        System.out.println("Stack : " + this.deque)
    }

    public static void main(String[] args){
        StackUsingDeque sdq = new StackUsingDeque();
        sdq.push(60);
        sdq.push(70);
        sdq.push(80);
        sdq.pop();
        sdq.push(90);
        sdq.print();
    }
}

// Implement the Queue using the stack
import java.util.Stack;

public class QueueUsingStack{
    
    private Stack<Integer> stack;
    private Stack<Integer> helperStack;

    public QueueUsingStack(){
        stack = new Stack<>();
        helperStack = new Stack<>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void offer(int val){
        // Pop out element from stack and store in helper stack
        while(!stack.empty()){
            helperStack.add(stack.pop());
        }

        stack.push(val);

        // Put it back element from helerstack to original stack
        while(!helerstack.isEmpty()){
            stack.push(helerstack.pop());
        }
    }

    public int poll(){
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack.pop();
    }

    public int peek(){
        if (this.stack.isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        return this.stack.peek();
    }

    public void print(){
        System.out.println("Queue :" + this.stack);
    }

    public static void main(String[] args){
        QueueUsingStack q = new QueueUsingStack();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.poll();
        q.offer(50);

        q.print();
    }
}


//  Implement the two stacks inside a array
public class TwoStacks{

    private int[] stack;
    private int capacity;
    private int top1;
    private int top2;

    public TwoStacks(int capacity){
        this.capacity = capacity;
        this.stack = new int[this.capacity];
        this.top1=-1; 
        this.top2=capacity;
    }

    public boolean isEmptyStack1(){
        return top1 == -1;
    }

    public boolean isEmptyStack2(){
        return top2 == capacity;
    }

    public boolean isFull(){
        return top2-top1 == 1;
    }

    public void pushStack1(int val){
        if (isFull()){
            throw new RuntimeException("Stack is full");
        }
        this.stack[++top1] = val;
    }

    public void pushStack2(int val){
        if (isFull()){
            throw new RuntimeException("Stack is full");
        }
        this.stack[--top2] = val;
    }

    public int popStack1(){
        if (isEmptyStack1()){
            throw new RuntimeException("Stack is empty");
        }
        return this.stack[top1--];
    }

    public void popStack2(){
        if (isEmptyStack2()){
            throw new RuntimeException("Stack is empty");
        }
        return this.stack[top2++];
    }

    public int topStack1(){
        if (isEmptyStack1()){
            throw new RuntimeException("Stack is empty");
        }
        return this.stack[top1];
    }

    public void topStack2(){
        if (isEmptyStack2()){
            throw new RuntimeException("Stack is empty");
        }
        return this.stack[top2];
    }

}


// Implement the Min Stack with extra space 
import java.util.Stack;

public class MinStack {

    class Element {
        int value;
        int min;

        public Element(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private Stack<Element> stack;

    public MinStack() {
        this.stack = new Stack<Element>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Element peek() {
        if (!isEmpty()) {
            return this.stack.peek();
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }

    public void push(int val) {
        if (isEmpty()) {
            this.stack.push(new Element(val, val));
        } else {
            int min = peek().min;
            this.stack.push(new Element(val, Math.min(min, val)));
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        } else {
            return this.stack.pop().value;
        }
    }

    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty !");
        } else {
            return peek().min; // Added return statement here
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(7);
        minStack.push(-8);
        
        System.out.println(minStack.getMin());

    }
}


// Implement insert at the bottom 
import java.util.Stack;

public class insertAtBottom{
    
    private Stack<Integer> stack = new Stack<>();

    public void insertAtBottom1(int val){
        
        // Using iterations
        Stack<Integer> auxStack = new Stack<>();
        
        // Remove element and push it to auxStack
        while(!stack.isEmpty()){
            auxStack.push(stack.pop());
        }

        stack.push(val);

        // Push remaining elements to stack
        while(!auxStack.isEmpty()){
            stack.push(auxStack.pop());
        }
    }

    public void insertAtBottom2(int val){
        if (stack.empty()){
            stack.push(val);
            return;
        }
        int top = stack.pop();
        insertAtBottom2(val);
        stack.push(top);
    }
}

// Parenthesis matching
import java.util.Stack;

public class CheckParenthesis{

    private Stack<Character> stack;

    public CheckParenthesis(){
        stack = new Stack<>();
    }

    private static boolean isBalanced(String s) {
        
        HashMap<Char, Char> map = new HashMap<>();
        map.put("}", "{");
        map.put(")", "(");
        map.put("]", "[");

        for(char ch : s.toCharArray()){
            
            // If opening bracket is there
            if (ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            }
            else {
                // Closing Bracket
                if (!stack.isEmpty()){
                    char top = stack.pop();
                    if (map.get(ch) != top) return false;
                }
                else{
                    return false;
                }
            }

            if (stack.isEmpty()) return true;
            return false;
        }
    }
}

// Delete the middle of the stack
import java.util.Stack;

public class DeleteMiddleOfStack{

    // Size 5 => Mid => 5/2 == 2+1           :: 1 2 3 4 5        => ADD 1
    // Size 6 => Mid => 6/2 == 3+1           :: 1 2 3 4 5 6      => ADD 1
    public void deleteMiddle(Stack<Integer> s, int size, int current){
        if(s.isEmpty()) return;
        if(s.size() == 1){
            s.pop();
            return;
        }
        if (current == size/2+1){
            s.pop();
            return ;
        }
        int top = s.pop();
        deleteMiddle(s , size, current+1);
        s.push(top);
    }

    public static void main(String[] args){
        DeleteMiddleOfStack obj = new DeleteMiddleOfStack();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        obj.deleteMiddle(s, s.size(), 1);
        System.out.println(s);
    }
}

// Sort the stack with recursion
import java.util.Stack;

public class SortStackUsingRecursion{

    public void insertInSortedStack(Stack<Integer> s, int element){
        if (s.isEmpty() || element < s.peek()){
            s.push(element);
            return;
        }
        int top = s.pop();
        insertInSortedStack(s, element);
        s.push(top);
    }
    public void sortStack(Stack<Integer> s){
        if (s.isEmpty() || s.size() == 1 ) return;
        int top = s.pop();
        sortStack(s);
        insertInSortedStack(s, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack: " + stack);

        SortStackUsingRecursion sorter = new SortStackUsingRecursion();
        sorter.sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }

}

// Sort the stack using iteration
import java.util.Stack;

public class SortStackUsingIteration{

    public void sortStack(Stack<Integer> s){

        Stack<Integer> auxStack = new Stack<>();
        
        while(!s.isEmpty()){
            int top = s.pop();
        
            while(!auxStack.isEmpty() && auxStack.peek() < top){
                stack.push(auxStack.pop());
            }
            auxStack.push(top);
        }

        while(!auxStack.isEmpty()){
            s.push(auxStack.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack: " + stack);

        SortStackUsingRecursion sorter = new SortStackUsingRecursion();
        sorter.sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

// Interleave first half of queue and second half
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class InterleaveQueueHalfs{

    public void interleave(Queue<Integer> q){
        if(q == null || q.size() <= 2) return;

        Stack<Integer> auxStack = new Stack<>();
        int firstHalfSize = q.size()/2 + 1;
        int secondHalfSize = q.size() - firstHalfSize;

        // Push first half to stack
        while(!q.isEmpty() && auxStack.size() != firstHalfSize){
            auxStack.push(q.poll());
        }

        // offer stack elements to queue
        while(!auxStack.isEmpty()){
            q.offer(auxStack.pop());
        }

        // Enque and deque elements to queue
        for(int i=0; i<secondHalfSize; i++){
            q.offer(q.poll());
        }

        // Push first half to stack
        while(!q.isEmpty() && auxStack.size() != firstHalfSize){
            auxStack.push(q.poll());
        }

        // Interleave the halfs
        for(int i=0; i<secondHalfSize; i++) {
            q.offer(auxStack.pop());
            q.offer(q.poll());
        }
        while(!auxStack.isEmpty()){
            q.offer(auxStack.pop());
        }

    }
}


// Next greater to the right
public class NGR{
    
    public int[] getNGR(int[] arr){
        
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            if(s.isEmpty()) answer.push(-1);
            else{
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                if (s.isEmpty()){
                    answer.push(-1);
                }
                else{
                    answer.add(s.peek());
                }
                s.push(arr[i]);
            }
        }

        int[] finalAnswer = new int[arr.length];
        int counter = arr.length - 1;
        
        for (int value : answer) {
            finalAnswer[counter] = value;
            counter--;
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        NGR ngr = new NGR();
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = ngr.getNGR(arr);

        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Next Greater to Right: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}