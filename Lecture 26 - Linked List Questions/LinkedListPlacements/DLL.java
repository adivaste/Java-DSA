class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class DLL {

    // Attributes
    private Node head;
    private Node tail;

    // :: INSERT AT HEAD
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // :: INSERT AT TAIL
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
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
            while (current != null && count < pos - 1) {
                current = current.next;
                count++;
            }
            if (current == null)
                throw new IllegalArgumentException("Invalid position");
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null)
                current.next.prev = newNode;
            current.next = newNode;
            if (current == tail)
                tail = newNode;
        }
    }

    // :: REMOVE HEAD
    public int removeHead() {
        if (head == null)
            throw new IllegalStateException("List is empty");
        int data = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        return data;
    }

    // :: REMOVE TAIL
    public int removeTail() {
        if (head == null)
            throw new IllegalStateException("List is empty");
        int data = tail.data;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        return data;
    }

    // :: REMOVE FROM POSITION
    public int remove(int pos) {
        if (pos <= 0 || head == null)
            throw new IllegalArgumentException("Invalid position");
        if (pos == 1)
            return removeHead();
        Node current = head;
        int count = 1;
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }
        if (current == null)
            throw new IllegalArgumentException("Invalid position");
        int data = current.data;
        if (current.next != null)
            current.next.prev = current.prev;
        if (current.prev != null)
            current.prev.next = current.next;
        if (current == tail)
            tail = current.prev;
        return data;
    }

    // :: REMOVE NODE FOR GIVEN VALUE
    public boolean removeNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    removeHead();
                } else if (current == tail) {
                    removeTail();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // :: TRAVERSAL FORWARD
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // :: TRAVERSAL BACKWARD
    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // :: GET SIZE
    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // :: SEARCH IN LINKED LIST
    public int getPosition(int data) {
        int position = 1;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Element not found
    }

    // :: Drivers code - Just For Trial Purpose
    public static void main(String[] args) {
        DLL doublyLinkedList = new DLL();

        doublyLinkedList.insertAtHead(3);
        doublyLinkedList.insertAtHead(2);
        doublyLinkedList.insertAtHead(1);

        doublyLinkedList.insertAtTail(4);
        doublyLinkedList.insertAtTail(5);

        doublyLinkedList.insertInPosition(3, 9);

        System.out.println("Forward Traversal:");
        doublyLinkedList.traverseForward();

        System.out.println("Backward Traversal:");
        doublyLinkedList.traverseBackward();

        System.out.println("Size of Doubly Linked List: " + doublyLinkedList.getSize());

        int valueToRemove = 2;
        if (doublyLinkedList.removeNode(valueToRemove)) {
            System.out.println("Successfully removed " + valueToRemove + " from the list.");
        } else {
            System.out.println(valueToRemove + " not found in the list.");
        }

        System.out.println("Size of Doubly Linked List after removal: " + doublyLinkedList.getSize());
    }
}

