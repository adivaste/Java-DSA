// Linked List 

// **-- Singly Linked List :: Create --**
public class SinglyLinkedList{

    // Node
    class Node{

        // Attributes
        int data;
        Node next;

        // Constructors
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    // Head of the node
    private Node head;

    // Constructor
    public SinglyLinkedList(){
        head = null;
    }

    public SinglyLinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
    }



   // == Insert into LL ==
   public void insert(int data){

       // Create new node
       Node newNode = new Node(data);

       
       // If LL is empty
       if (head == null){
           head = newNode;
       }
       // If LL has some elements
       else{
           Node temp = head;
           while(temp.next != null){
               temp = temp.next;
           }
           temp.next = newNode;
       }
   }

   // Delete from a node
   public int delete(int data){
       
       int deletedValue = -1;

       // Handling head
       if (head.data == data){
           deletedValue = head.data;
           head = head.next;
           return deletedValue;
       }


       Node temp = head;
       while(temp != null && temp.next != null){
           if(temp.next.data == data){
                deletedValue = temp.next.data;
                temp.next = temp.next.next;
           }
           temp = temp.next;
       }
       return deletedValue;
   }

   // Print the linked list
   public void printLL(){
       Node temp = head;

       while(temp != null){
           System.out.print(temp.data + " -> ");
           temp = temp.next;
       }
       System.out.print(" NULL ");

   }


   public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insert(5);
        sll.insert(6);
        sll.insert(7);

        sll.printLL();

        sll.delete(6);
        sll.printLL();
        sll.delete(5);
        sll.printLL();
        sll.delete(7);
        sll.printLL();

   }

    
}
