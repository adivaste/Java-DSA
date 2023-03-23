package com.company;

public class Main {
    public static void main(String[] args) {
        LL linkedList1 = new LL();
        linkedList1.insertAtPosition(1,1);
        linkedList1.insertAtIndex(0,0);
        linkedList1.insertAtIndex(3,2);
        int val2 = linkedList1.deleteFromIndex(0);

        linkedList1.display();
        System.out.println("\nSize : " + linkedList1.getSize());
    }
}
