package com.company;

public class Main {
    public static void main(String[] args) {
//        LL linkedList1 = new LL();
//        linkedList1.insertAtPosition(1,1);
//        linkedList1.insertAtIndex(0,0);
//        linkedList1.insertAtIndex(3,2);
//        int val2 = linkedList1.deleteFromIndex(0);
//
//        linkedList1.display();
//        System.out.println("\nSize : " + linkedList1.getSize());

        CLL newLL = new CLL();
        newLL.insertAtTail(34);
        newLL.insertAtTail(21);
        newLL.insertAtTail(78);
        newLL.insertAtIndex(45,2);
//        newLL.deleteFromIndex(0);
        newLL.deleteHead();
        newLL.display();
        System.out.println(newLL.findElement(2545));
        newLL.displayReverse();
    }
}
