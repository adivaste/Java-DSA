// package com.company;

import java.util.*;

public class Node{
    
    // Attributes
    int data;
    Node next;

    // Constructor-1
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    // Constructor-2
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    // Driver code - For Trial Purpose
    public static void main(String[] args){

        // Nodes creation
        Node head = new Node(5);
        Node temp1 = new Node(6);
        Node temp2 = new Node(7);
        Node temp3 = new Node(8);

        // Node linking
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;


        // Node printing
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next.next.data);
        System.out.println(head.next.next.next.next);
    }
}

