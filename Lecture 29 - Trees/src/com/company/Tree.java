package com.company;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Tree{

    private Node root = null;
    
    // Tree Node
    private class Node{
        int data;
        Node left;
        Node right;

        // Constructor - 1
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Constrctor - 2
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Create tree with root 
    public Tree(int value){
        root = new Node(value);
    }

    // Create a empty tree 
    public Tree(){
        root = null;
    }
    
    // Take tree input using the recursion
    public void inputTree(Node n){

        // Input the root node
        if (n == null){   
            System.out.println("Enter root of tree : ");
            Scanner input = new Scanner(System.in);

            int value = input.nextInt();
            root = new Node(value);
            n = root;
        }

        // Input the child elements
        int currValue = n.data;
        System.out.println("Enter left of " + currValue + " : ");

        Scanner input = new Scanner(System.in);
        int leftValue = input.nextInt();

        System.out.println("Enter right of " + currValue + " : ");
        int rightValue = input.nextInt();

        if (leftValue != -1){
            n.left = new Node(leftValue);
            inputTree(n.left);
        }

        if (rightValue != -1){
            n.right = new Node(rightValue);
            inputTree(n.right);
        }
    }

    // Take the input using the Queue 
    public void inputUsingQueue(){
        Queue<Node> q = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        // Take the root input
        if(root == null){
            System.out.println("*Enter the root : ");
            int value = input.nextInt();
            Node rootNode = new Node(value);
            root = rootNode;
            q.add(root);
        }

        // Take the child elements
        while(!q.isEmpty()){
            Node curr = q.peek();

            System.out.println("Enter the left of " + curr.data + ": ");
            int value1 = input.nextInt();
            System.out.println("Enter the right of " + curr.data + ": ");
            int value2 = input.nextInt();
        
            if(value1 != -1){
                Node leftNode = new Node(value1);
                curr.left = leftNode;
                q.add(leftNode);
            }
            if(value2 != -1){
                Node rightNode = new Node(value2);
                curr.right = rightNode;
                q.add(rightNode);
            }
            q.remove();
        }
    }

    // Take the input
    public void inputTreeMe(){
        inputUsingQueue();
    }

    // Level order traversal
    public void levelOrderTraversal(){
        
        // Maintain the queue for traversing nodes
        Queue<Node> q = new LinkedList<>();
        Node temp = root;
        q.add(temp);
        q.add(null);

        while(!q.isEmpty()){
            if (q.peek() == null){
                System.out.println();
                q.remove();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else {
                System.out.print(q.peek().data);
                // Add child nodes to queue
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                // Remove the node
                q.remove();
            }
        }
    }
    
    // Inorder traversal
    public void inOrder(Node n){
        if(n == null) return;
        inOrder(n.left);
        System.out.print(n.data);
        inOrder(n.right);
    }

    // Preorder traversal
    public void preOrder(Node n){
        if (n == null) return;
        System.out.print(n.data);
        preOrder(n.left);
        preOrder(n.right);
    }

    // Postorder traversal
    public void postOrder(Node n){
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.data);
    }
    // Inorder traversal
    public void inOrderTraversal(){
        System.out.print("In-order traversal : ");
        inOrder(root);
        System.out.println();
    }
    // Preorder traversal
    public void preOrderTraversal(){
        System.out.print("Pre-order traversal : ");
        preOrder(root);
        System.out.println();
    }
    // Postorder traversal
    public void postOrderTraversal(){
        System.out.print("Post-order traversal : ");
        postOrder(root);
        System.out.println();
    }

    // Traversals using the Iterations
    public void inOrderUsingIteration(){
        Stack<Node> s = new Stack<>();
        Node temp = root;
        s.push(temp);

        System.out.println("Inorder Using iterations : ");

        while (!s.isEmpty()){
            // If is there null remove, print, add right
            if (s.peek() == null){
                s.pop();
                if (!s.isEmpty()){
                    Node topNode = s.pop();
                    System.out.print(topNode.data);
                    s.push(topNode.right);
                }
            }
            else {
                // Go to the left
                temp = s.peek().left;
                s.push(temp);
            }
        }
    }

    // Traversals using the Iterations
    public void preOrderUsingIteration(){
        Stack<Node> s = new Stack<>();
        Node temp = root;
        s.push(temp);

        System.out.println("Preorder Using iterations : ");

        while (!s.isEmpty()){
            // If is there null remove, print, add right
            if (s.peek() == null){
                s.pop();
                if (!s.isEmpty()){
                    Node topNode = s.pop();
                    s.push(topNode.right);
                }
            }
            else {
                // Go to the left
                System.out.println(s.peek().data);
                temp = s.peek().left;
                s.push(temp);
            }
        }
    }

    // Traversals using the Iterations
    public void postOrderUsingIteration(){
        Stack<Node> s = new Stack<>();
        Node temp = root;
        s.push(temp);

        System.out.println("Postorder Using iterations : ");

        while (!s.isEmpty()){
            // If is there null remove, print, add right
            if (s.peek() == null){
                s.pop();
                if (!s.isEmpty()){
                    s.push(s.peek().right);
                }
            }
            else {
                // Go to the left
                temp = s.peek().left;
                s.push(temp);
            }
        }
    }

    // Traversal using the Iterations - Preorder
    public void preOrderTraversalIterative(){

        // If root is null then return
        if (root == null) return;

        // Traversing it
        Stack<Node> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            Node curr = s.pop();
            System.out.println(curr.data);

            if (curr.right != null){
                s.push(curr.right);
            }
            if (curr.left != null){
                s.push(curr.left);
            }
        }
    }

    // Traversal using the iterations - Postorder
    public void postOrderTraversalIterative(){

        // If root is null then return
        if (root == null) return;

        // Traversing the postorder
        Stack<Node> s = new Stack<>();
        Stack<Node> pS = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            Node curr = s.pop();
            pS.push(curr);

            if (curr.left != null){
                s.push(curr.left);
            }
            if (curr.right != null){
                s.push(curr.right);
            }
        }

        while(!pS.isEmpty()){
            Node curr = pS.pop();
            System.out.println(curr.data);
        }
    }


    // Traversal using the iterations - Inorder
    public void inOrderTraversalIterative(){

        // If root is null then return
        if (root == null) return;

        // Traverse
        Stack<Node> s = new Stack<>();
        Node curr = root;


        while(curr != null || !s.isEmpty()){
            
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.println(curr.data);
            curr = curr.right;

            }
    }


    // Count leaf nodes
    public int getLeafs(Node n) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) return 1;
        return getLeafs(n.left) + getLeafs(n.right);
    }
}
