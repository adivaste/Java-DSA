package com.company;

public class DLL {

    private Node HEAD;
    private Node TAIL;
    private int SIZE;

    // Constructor to initialize size of 0
    public DLL(){
        this.SIZE = 0;
    }

    // Display DLL
    public void display(){
        Node temp = HEAD;

        System.out.print("START -> ");
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Display DLL
    public void displayReverse(){
        Node temp = TAIL;

        System.out.print("END -> ");
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    // Get size of DLL
    public int getSize(){
        return SIZE;
    }

    // Find the element
    public boolean findElement(int value){
        Node temp = HEAD;
        while (temp != null){
            if (temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }

    // Insert at Head
    public void insertAtHead(int value){

        // Create the node
        Node newNode = new Node(value);

        // If DLL is empty
        if (HEAD == null){
            HEAD = newNode;
            TAIL = newNode;
            SIZE++;
            return;
        }

        // Insert at head
        newNode.next = HEAD;
        HEAD = newNode;
        SIZE++;
    }

    // Insert At Tail
    public void insertAtTail(int value){

        // Create the node
        Node newNode = new Node(value);

        // If DLL is empty
        if (TAIL == null){
            HEAD = newNode;
            TAIL = newNode;
            SIZE++;
            return;
        }

        // Insert at last
        TAIL.next = newNode;
        newNode.prev = TAIL;
        TAIL = newNode;
        SIZE++;
    }

    // Insert At Index
    public void insertAtIndex(int value, int index){

        // Create the node
        Node newNode = new Node(value);

        // Handle indexes
        if (index < 0 || index > SIZE) return;

        // Insert at first and last
        if (index == 0){
            insertAtHead(value);
            return;
        }
        if (index == SIZE) {
            insertAtTail(value);
            return;
        }

        // Insert at index
        Node temp = HEAD;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next.prev = newNode;
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        SIZE++;
    }

    // Delete from Head
    public int deleteHead(){

        // If DLL is empty
        if(HEAD == null) return -1;

        // Delete the head
        int value = HEAD.value;
        HEAD = HEAD.next;

        // If DLL has single element
        if (HEAD == TAIL){
            HEAD = null;
            TAIL = null;
            return value;
        }
        HEAD.prev = null;
        SIZE--;
        return value;
    }

    // Delete from Tail
    public int deleteTail(){

        // If DLL is empty
        if(TAIL == null) return -1;

        // Delete the TAIL
        int value = TAIL.value;
        TAIL = TAIL.prev;

        // If DLL has single element
        if (HEAD == TAIL){
                HEAD = null;
                TAIL = null;
                return value;
        }
        TAIL.next = null;
        SIZE--;
        return value;
    }

    // Delete from particular index
    public int deleteFromIndex(int index){

        // If tail is empty
        if (TAIL == null) return -1;

        // Handling the irregular indexes
        if (index < 0 || index > SIZE) return -1;

        // Handling last and first indexes
        if (index == 0){
            return deleteHead();
        }
        if (index == SIZE-1){
            return deleteTail();
        }

        // Deleting specific node
        Node temp = HEAD;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node nodeToDelete = temp.next;
        int value = nodeToDelete.value;

        temp.next = nodeToDelete.next;
        nodeToDelete.next.prev = temp;
        SIZE--;
        return value;
    }


    private class Node{

        // Node data & next
        private int value;
        private Node next;
        private Node prev;

        // Constructors
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
