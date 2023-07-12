package com.company;
import java.util.Queue;
import java.util.LinkedList;

public class BST{

    // Root Node for BST
    private Node root = null;
    
    // Create Node for BST
    private class Node{
        private int data;
        private Node left;
        private Node right;

        // Constructor 1
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Constructor 2
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Insert into BST 
    // :: Time Complexity = O(logn);
    
    private Node insertIntoBST(Node root, int data){
        Node node = new Node(data);
         
        if (root == null) return node;
        else if (data < root.data) root.left = insertIntoBST(root.left, data);
        else if (data > root.data) root.right = insertIntoBST(root.right, data);
        return root;
    }
    public void insertIntoBST(int data){
        this.root = insertIntoBST(this.root, data);
    }

    // Level order traversal
    public void levelOrderTraversal(Node root){
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
           Node top = q.remove();
           System.out.println(top.data + " ");

           if(top.left != null) q.add(top.left);
           if(top.right != null) q.add(top.right);
        }
    }

    public void levelOrderTraversal(){
        levelOrderTraversal(this.root);
    }


    // Driver's Code
    public static void main(String[] args){
        System.out.println("BST : ");
        BST b = new BST();
        b.insertIntoBST(5);
        b.insertIntoBST(1);
        b.insertIntoBST(8);
        b.insertIntoBST(4);
        b.insertIntoBST(9);
        b.insertIntoBST(6);
        b.insertIntoBST(10);

        b.levelOrderTraversal();
    }
}


