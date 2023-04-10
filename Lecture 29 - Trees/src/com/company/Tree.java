package com.company;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

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
        if (n == null){   
            System.out.println("Enter root of tree : ");
            Scanner input = new Scanner(System.in);

            int value = input.nextInt();
            root = new Node(value);
            n = root;
        }
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

    // Take the input
    public void inputTreeMe(){
        inputTree(root);
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
}
