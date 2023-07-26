// package com.company;

import java.util.*;

public class SLL {

    // Attributes
    private Node head;
    private Node tail;

    // Methods

    // :: INSERT AT HEAD
    public void insertAtHead(int data) {
        // Create new node
        Node newNode = new Node(data);

        // If LL is empty
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        // If LL has some elements
        else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    // :: INSERT AT TAIL
    public void insertAtTail(int data) {
        // Create new Node
        Node newNode = new Node(data);

        // If LL is empty
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        // If LL has some elements
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    // :: INSERT AT GIVEN POSITION
    public void insertInPosition(int pos, int data) {
        // Create new node
        Node newNode = new Node(data);

        // If Position is 1
        if (pos == 1) {
            this.insertAtHead(data);
            return;
        }
        // If position is other
        else {
            int noOfTraversals = pos - 2;

            Node temp = this.head;
            while (temp != null && noOfTraversals != 0) {
                temp = temp.next;
                noOfTraversals--;
            }
            if (temp == this.tail) {
                insertAtTail(data);
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    // :: REMOVE HEAD
    public int removeHead() {
        if (head == null) return -1;

        int val = head.data;
        head = head.next;

        if (head == null) tail = null; // If only one node, make tail null

        return val;
    }

    // :: REMOVE TAIL
    public int removeTail() {
        if (head == null) return -1;

        int val = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }

        return val;
    }

    // :: REMOVE FROM POSITION
    public int remove(int pos) {
        if (pos <= 0 || head == null) return -1;

        if (pos == 1) {
            return removeHead();
        } else {
            int noOfTraversals = pos - 2;

            Node temp = this.head;
            while (temp != null && noOfTraversals != 0) {
                temp = temp.next;
                noOfTraversals--;
            }
            if (temp == null || temp.next == null) {
                return -1; // Invalid position
            } else {
                int val = temp.next.data;
                temp.next = temp.next.next;
                return val;
            }
        }
    }

    // :: REMOVE NODE FOR GIVEN VALUE
    public boolean removeNode(int data) {
        if (head == null) return false;

        if (head.data == data) {
            removeHead();
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // :: GET SIZE
    public int getSize() {
        int size = 0;

        Node temp = this.head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    // :: SEARCH IN LINKED LIST
    public int getPosition(int data) {
        int position = -1;

        Node temp = this.head;
        while (temp != null) {
            position++;
            if (temp.data == data) {
                return position + 1;
            }
            temp = temp.next;
        }
        return position;
    }


    // :: TRAVERSAL
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    // :: Drivers code - Just For Trial Purpose
    public static void main(String[] args) {
        SLL linkedList = new SLL();

        linkedList.insertAtHead(3);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(1);

        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);

        linkedList.insertInPosition(3, 9);

        System.out.println("Position of 4: " + linkedList.getPosition(4));
        System.out.println("Size of Linked List: " + linkedList.getSize());

        linkedList.remove(2);
        linkedList.removeNode(4);

        System.out.println("Size of Linked List after removal: " + linkedList.getSize());
    }
}
