package com.company;

import com.sun.source.tree.NewArrayTree;

import java.time.temporal.Temporal;

public class SLL {

    private Node HEAD;
    private Node TAIL;
    private int SIZE;

    // ---- Insertion ----

    // 1. Insert using the recursion
    public void insertAtIndex(int index, int value){
        if (index == 0){
            insertAtHead(value);
            return;
        }
        if (index == SIZE){
            insertAtTail(value);
            return;
        }
        HEAD = insertUsingRecursion3(index, value, HEAD);
    }
    private void insertUsingRecursion(int index, int value, Node prevNode, Node currNode){
        if (index == 0){
            Node newNode = new Node(value);
            newNode.next = currNode;
            prevNode.next = newNode;
            SIZE++;
            return;
        }
        insertUsingRecursion(index-1, value, currNode, currNode.next);
    }

    private void insertUsingRecursion2(int index, int value, Node currNode){
        if (index == 1){
            Node newNode = new Node(value);
            newNode.next = currNode.next;
            currNode.next = newNode;
            SIZE++;
            return;
        }
        insertUsingRecursion2(index-1, value,currNode.next);
    }

    private Node insertUsingRecursion3(int index, int value, Node currNode){
        if (index == 0){
            Node newNode = new Node(value, currNode);
            SIZE++;
            return newNode;
        }
        currNode.next = insertUsingRecursion3(index-1, value,currNode.next);
        return currNode;
    }



    private void insertAtHead(int value){

        Node newNode = new Node(value);

        if (HEAD == null){
            HEAD = newNode;
            TAIL = newNode;
            SIZE++;
            return;
        }

        newNode.next = HEAD;
        HEAD = newNode;
        SIZE++;
        return;
    }

    private void insertAtTail(int value){

        Node newNode = new Node(value);

        if (TAIL == null){
            HEAD = newNode;
            TAIL = newNode;
            SIZE++;
            return;
        }

        TAIL.next = newNode;
        TAIL = newNode;
        SIZE++;
        return;
    }


    // Display
    public void display(){
        Node temp = HEAD;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
