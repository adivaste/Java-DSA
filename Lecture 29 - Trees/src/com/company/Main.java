package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Tree t = new Tree();
        t.inputTreeMe();
       // t.printTree();
        t.levelOrderTraversal();
        t.inOrderTraversal();
        t.postOrderTraversal();
        t.preOrderTraversal();
        t.inOrderUsingIteration();
        t.preOrderUsingIteration();
//        t.postOrderUsingIteration();
    }
}
