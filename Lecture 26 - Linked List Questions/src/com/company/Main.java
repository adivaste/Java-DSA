package com.company;

public class Main {
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.insertAtIndex(0,5);
        sll.insertAtIndex(0,10);
        sll.insertAtIndex(0,15);
        sll.insertAtIndex(2,20);
        sll.insertAtIndex(3,26);
//        sll.insertAtIndex(5,69);
        sll.display();
    }
}
