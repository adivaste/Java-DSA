package com.company;

public class LL {

    private Node HEAD;
    private Node TAIL;
    private int SIZE;

    public LL() {
        this.SIZE = 0;
    }

    // Display the linked list
    public void display(){
        Node temp = HEAD;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    // Get size
    public int getSize(){
        return SIZE;
    }

    // Insert At Head
    public void insertAtHead(int value){
        Node node = new Node(value);
        node.next = HEAD;
        HEAD = node;

        if (TAIL == null){
            TAIL = HEAD;
        }
        SIZE += 1;
    }

    // Insert At End
    public void insertAtEnd(int value){

        // If LL is empty
        if (TAIL == null){
            insertAtHead(value);
            return;
//            TAIL = node;
//            HEAD = node;
        }
        Node node = new Node(value);

        TAIL.next = node;
        TAIL = node;
        SIZE += 1;
    }

    // Insert At Position
    public void insertAtPosition(int value, int position){
        Node node = new Node(value);

        // Return if position is more than expected
        if (position > SIZE+1 || position <= 0) return;

        if (position == 1) {
            insertAtHead(value);
            return;
        }
        if (position == SIZE+1){
            insertAtEnd(value);
            return;
        }

        Node temp = HEAD;
        for (int i = 2; i < position; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        SIZE += 1;
    }

    // Insert At Index
    public void insertAtIndex(int value, int index){

        // Return is position is more than expected index or negative
        if (index > SIZE || index < 0) return;

        // Insert the element at head when index is zero
        if (index == 0) {
            insertAtHead(value);
            return;
        }

        // Insert the element at end when index is equal to size of linked list
        // which also saves the time of traversing
        if (index == SIZE){
            insertAtEnd(value);
            return;
        }

        // Creating a new node for given value
        Node node = new Node(value);

        // Create temp node to traverse over the linked list
        Node temp = HEAD;
        // Iterating over the linked list until specified index
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        // Increasing the size after insertion
        SIZE += 1;
    }

    // Delete First
    public int deleteFirst(){
        // Return -1 if linked list is empty
        if (HEAD == null){
            return -1;
        }
        // Store the value before deleting
        int value = HEAD.value;
        // Move head to next
        HEAD = HEAD.next;
        // If single element is there then update both
        if (HEAD == null){
            TAIL = null;
        }
        // Reduce the size
        SIZE--;
        // Return value
        return value;
    }

    // Delete last
    public int deleteLast(){

        // Call delete first when HEAD is null or single element present
        if ( HEAD == null || HEAD.next == null ){
            return deleteFirst();
        }

        // Create temp node
        Node temp = HEAD;
        // Traverse over it to get previous of last
        for (int i = 2; i < SIZE; i++) {
            temp = temp.next;
        }

        // Store values and make next one NULL
        int value = temp.value;
        temp.next = null;
        TAIL = temp;
        // reduce size
        SIZE--;
        // return the value
        return value;
    }

    // Delete from any index
    public int deleteFromIndex(int index){
        if (index <= 0){
            return deleteFirst();
        }
        if (index >= SIZE-1){
            return deleteLast();
        }

        Node currRef = getReference(index);
        int value = currRef.value;
        Node prevRef = getReference(index-1);
        prevRef.next = currRef.next;
        SIZE--;
        return value;
    }

    // Searching in Linked List
    public Node find(int num){
        Node temp = HEAD;
        while (temp != null){
            if (temp.value == num) return temp;
            temp = temp.next;
        }
        return null;
    }


    // Get Desired reference
    public Node getReference(int index){
        Node temp = HEAD;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Node
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
