// package com.company;

import java.util.*;

public class CLL {

    // Attribute
    private Node head;

    // :: INSERT AT HEAD
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for a single node circular list
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            head = newNode;
            tail.next = head; // Update the last node to point back to the new head
        }
    }

    // :: INSERT AT TAIL
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for a single node circular list
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head; // Make the new node point to head to complete the circular link
        }
    }

    // :: INSERT AT GIVEN POSITION
    public void insertInPosition(int pos, int data) {
        if (pos <= 0)
            throw new IllegalArgumentException("Invalid position");
        if (pos == 1) {
            insertAtHead(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int count = 1;
            while (current.next != head && count < pos - 1) {
                current = current.next;
                count++;
            }
            if (count < pos - 1)
                throw new IllegalArgumentException("Invalid position");
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // :: REMOVE HEAD
    public int removeHead() {
        if (head == null)
            throw new IllegalStateException("List is empty");
        int data = head.data;
        if (head.next == head) {
            head = null; // Only one node in the list
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head; // Update the last node to point to the new head
        }
        return data;
    }

    // :: REMOVE TAIL
    public int removeTail() {
        if (head == null)
            throw new IllegalStateException("List is empty");
        int data;
        if (head.next == head) {
            data = head.data;
            head = null; // Only one node in the list
        } else {
            Node current = head;
            Node prev = null;
            while (current.next != head) {
                prev = current;
                current = current.next;
            }
            data = current.data;
            prev.next = head; // Update the previous node to point to the new head (removing the last node)
        }
        return data;
    }

    // :: REMOVE FROM POSITION
    public int remove(int pos) {
        if (pos <= 0 || head == null)
            throw new IllegalArgumentException("Invalid position");
        if (pos == 1)
            return removeHead();
        Node current = head;
        Node prev = null;
        int count = 1;
        while (current.next != head && count < pos) {
            prev = current;
            current = current.next;
            count++;
        }
        if (count < pos)
            throw new IllegalArgumentException("Invalid position");
        int data = current.data;
        prev.next = current.next;
        return data;
    }

    // :: REMOVE NODE FOR GIVEN VALUE
    public boolean removeNode(int data) {
        if (head == null)
            return false;

        if (head.data == data) {
            removeHead();
            return true;
        }

        Node current = head;
        Node prev = null;
        while (current.next != head) {
            if (current.data == data) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }

        // Check the last node
        if (current.data == data) {
            prev.next = head; // Update the last node to point to the new head
            return true;
        }

        return false;
    }

    // :: TRAVERSAL
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // ... Other methods ...

    // Drivers code - Just For Trial Purpose
    public static void main(String[] args) {
        CLL circularLinkedList = new CLL();

        circularLinkedList.insertAtHead(3);
        circularLinkedList.insertAtHead(2);
        circularLinkedList.insertAtHead(1);

        circularLinkedList.insertAtTail(4);
        circularLinkedList.insertAtTail(5);

        circularLinkedList.insertInPosition(3, 9);

        System.out.println("Circular Linked List:");
        circularLinkedList.traverse();

        int valueToRemove = 2;
        if (circularLinkedList.removeNode(valueToRemove)) {
            System.out.println("Successfully removed " + valueToRemove + " from the list.");
        } else {
            System.out.println(valueToRemove + " not found in the list.");
        }

        System.out.println("Circular Linked List after removal:");
        circularLinkedList.traverse();
    }
}
