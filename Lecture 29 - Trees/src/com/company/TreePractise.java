package com.company;
import java.util.*;

// Create a tree in Java
public class TreePractise{
    
    // Node
    private class Node{

        // Data members
        private int data;
        private Node left;
        private Node right;

        // Constructors
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Root
    private Node root;

    // Initialize the tree using constructors
    public TreePractise(){
        this.root = null;
    }

    public TreePractise(int data){
        this.root = new Node(data);
    }

    //---------------------------------------------------
    // Functions
    // --------------------------------------------------
    
    Scanner input = new Scanner(System.in);

    // Take input tree using recursion
    public void takeInputUsingRecursion(Node root){
        // Take root node
        if(this.root == null){
            System.out.println("Enter root : ");
            int rootVal = input.nextInt();
            root = new Node(rootVal);
            this.root = root;
        }
        // Take the left and right
        
            System.out.println("Enter the left of " + root.data);
            int leftVal = input.nextInt();
            System.out.println("Enter the right of " + root.data);
            int rightVal = input.nextInt();

            root.left = new Node(leftVal);
            root.right = new Node(rightVal);
            takeInputUsingRecursion(root.left);
            takeInputUsingRecursion(root.right);
        
    }

    // Take input using the Queue|Iteration
    // Time Complexity : O(n)   (Queue Size)
    // Space complexity : O(n)  (Queue Size)
    public void takeInputUsingIteration(){

        // Create Queue to maintain the nodes
        Queue<Node> q = new LinkedList<>();
        // Scanner class object to take input
        Scanner input = new Scanner(System.in);

        // If tree is empty or root is null
        if (root == null){
            System.out.println("Enter the root of the tree : ");
            int rootVal = input.nextInt();

            Node newNode = new Node(rootVal);
            this.root = newNode;
            q.add(newNode);
        }
        // If not take the inputs recursively
            while(!q.isEmpty()){
                Node top = q.remove();

                System.out.println("Enter the left of " + top.data + " : ");
                int leftVal = input.nextInt();
                if (leftVal != -1){
                    Node leftNode = new Node(leftVal);
                    top.left = leftNode;
                    q.add(leftNode);
                }

                System.out.println("Enter the right of " + top.data + " : ");
                int rightVal = input.nextInt();
                if (rightVal != -1){
                    Node rightNode = new Node(rightVal);
                    top.right = rightNode;
                    q.add(rightNode);
                }
            }
        
    }

    // Print the tree In Inorder-way
    public void inOrderRecursion(Node root){
        if (root == null) return;

        inOrderRecursion(root.left);
        System.out.println(root.data);
        inOrderRecursion(root.right);
    }

    // Print the tree In Preorder-way
    public void preOrderRecursion(Node root){
        if (root == null) return;

        System.out.println(root.data);
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    // Print the tree In Postorder-way
    public void postOrderRecursion(Node root){
        if (root == null) return;

        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.println(root.data);
    }

    // Inorder using the iteration
    public void inOrderIteration(){
        Stack<Node> s = new Stack<>();
        Node curr = this.root;
        
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
    
            Node top = s.pop();
            System.out.println(top.data);
            curr = top.right;
         }
    }

    // Preorder using the iteration
    public void preOrderIteration(){
        if (this.root == null){
            return;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            Node top = s.pop();
            System.out.println(top.data);

            if (top.right != null) s.push(top.right);
            if (top.left != null) s.push(top.left);
        }
    }


    // Postorder using iteration - 2 stacks
    public void postOrderIterationS2(){
        
        // If tree is empty
        if (this.root == null) return;

        // 2 Stacks to maintain the Orders
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        // Push root into stack1
        s1.push(this.root);
        
        // Until the first stack get's empty, I will be pushing top
        // element to another stack "s2" and add child of curr node
        // into first stack eventually.
        // Order in first stack "s1"       => | Right | 
        //                                    | Left  |
        //
        // Order in second stack "s2"      => | Left  | 
        //                                    | Right | 
        //
        // Order while printing stack "s2" => | Left | Right |

        while(!s1.isEmpty()){
            Node top = s1.pop();
            s2.push(top);

            if(top.left != null) s1.push(top.left);
            if(top.right != null) s1.push(top.right);
        }

        // Printing the stack "s2"
        while(!s2.isEmpty()){
            int val = s2.pop().data;
            System.out.println(val);
        }
    }

    // Postorder using iteration - 1 Stack
    public void postOrderIterationS1(){
        
        // If tree is empty skip it
        if (this.root == null) return;

        // Maintain the stack and Postorder 
        Stack<Node> s = new Stack<>();
        Node curr = this.root;
        ArrayList<Node> postOrder = new ArrayList<>();

        // Until stack is not empty and curr is not null 
        // perform the operations
        while(!s.isEmpty() && curr != null){

            // Go to left and left only
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }

            // In case left becomes null then go to right
            // and then again left, left
            else{
                Node temp = s.top().right;
                
                // When both left and right becomes a null then
                // I will be adding top into "postOrder" and untill
                // I found that "temp" parent's right is not temp till
                // then I will backtrack and push into "postOrder"
                if (temp == null){
                    Node top = s.pop();
                    postOrder.add(top);

                    while (!s.isEmpty() && temp == s.top().right){
                        temp = s.pop();
                        postOrder.add(temp);
                    }
                }
                // If right is not null means it has something, so travese it
                // again.
                else{
                    curr = temp;
                }
            }
        }
    }

    // Level order traveral using iterations
    public void levelOrderTraversalUsingIterations(){
        
        // Maintain the Queue
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while(!q.isEmpty()){
            Node top = q.remove();
            System.out.println(top.data + " ");

            if (top.left != null) q.add(top.left);
            if (top.right != null) q.add(top.right);
        }
    }

    // Count the number of leaf nodes
    public int countOfLeafs(Node root){
        if (root == null) return 1;

        int leafOnLeft = countOfLeafs(root.left);
        int leafOnRight = countOfLeafs(root.right);

        return leafOnLeft + leafOnRight;
    }

    // Calculate the height of the tree
    public int heightOfTree(Node root){
        if (root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Print all the elements for perticular depth
    public void printTillPerticularDepth(Node root,int depth){
        if (root == null) return;
        if (depth == 0){
            System.out.prinln(root.data);
        }
        else if(depth > 0){
            printTillPerticularDepth(root.left, depth-1);
            printTillPerticularDepth(root.right, depth-1);
        }
    }

    // Find the depth of the node
    public int getDepthOfNode(Node root, int target, int depth){
        if (root == null) return -1;
        if (root.data == target) return depth;
        
        int leftDepth = getDepthOfNode(root.left, target, depth+1);
        int rightDepth = getDepthOfNode(root.right, target, depth+1);

        return Math.max(leftDepth, rightDepth);
    }

    // DS for Queue
    public class vPair{
        Node node = null;
        int hl = 0;

        public vPair(Node root, int hl){
            this.node = root;
            this.hl = hl;
        }
    }
    
    // Vertical Order traversal using iteration
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root){
        
        // Queue to maintain the nodes
        Queue<vPair> q = new LinkedList<>();

        // Hashmap to keep track of nodes
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<>();

        // Answer
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int maxhl = 0;
        int minhl = 0;

        // Push root into Queue
        q.push(new vPair(root, 0));

        // Until the Queue becomes empty remove the elements
        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                vPair top = q.pop();

                maxhl = Math.max(maxhl, top.hl);
                minhl = Math.min(minhl, top.hl);

                h.insertIfAbsent(top.hl, new ArrayList<Integer>);
                h.get(top.hl).add(top.node.data);

                if (top.node.left != null) q.push(new vPair(top.node.left, top.hl-1));
                if (top.node.right != null) q.push(new vPair(top.node.right, top.hl-1));
            }
        }

        // Add to answer and return it
        for(int i=minhl; i<=maxhl; i++){
            answer.add(h.get(i));
        }
        return answer;
    }


    // Top view of the tree
    // 
    // <---- Implementation of vPair class DS ---->
    
    public ArrayList<Integer> topView(Node root){

        // Queue to maintain the nodes
        Queue<vPair> q = new LinkedList<>();

        // Hashmap to keep track of nodes
        HashMap<Integer, Integer> h = new HashMap<>();

        // Answer
        ArrayList<Integer> ans = new ArrayList<>();
        int maxhl = 0;
        int minhl = 0;

        // Push root into Queue
        q.add(new vPair(root, 0));

        // Until the Queue becomes empty remove the elements
        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                vPair top = q.remove();

                maxhl = Math.max(maxhl, top.hl);
                minhl = Math.min(minhl, top.hl);

                h.putIfAbsent(top.hl, top.node.data);

                if (top.node.left != null) q.add(new vPair(top.node.left, top.hl-1));
                if (top.node.right != null) q.add(new vPair(top.node.right, top.hl+1));
                size--;
            }
        }

        // Add to answer and return it
        for(int i=minhl; i<=maxhl; i++){
            ans.add(h.get(i));
        }
        return ans;
    }

    // Bottom view of the tree 
    // <---- Implementation of vPair class DS ---->
    //
    public ArrayList<Integer> bottomView(Node root){

        // Queue to maintain the nodes
        Queue<vPair> q = new LinkedList<>();

        // Hashmap to keep track of nodes
        HashMap<Integer, Integer> h = new HashMap<>();

        // Answer
        ArrayList<Integer> ans = new ArrayList<>();
        int maxhl = 0;
        int minhl = 0;

        // Push root into Queue
        q.add(new vPair(root, 0));

        // Until the Queue becomes empty remove the elements
        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                vPair top = q.remove();

                maxhl = Math.max(maxhl, top.hl);
                minhl = Math.min(minhl, top.hl);

                h.putIfAbsent(top.hl, top.node.data);
                h.put(top.hl, top.node.data);

                if (top.node.left != null) q.add(new vPair(top.node.left, top.hl-1));
                if (top.node.right != null) q.add(new vPair(top.node.right, top.hl+1));
                size--;
            }
        }

        // Add to answer and return it
        for(int i=minhl; i<=maxhl; i++){
            ans.add(h.get(i));
        }
        return ans;

    }

    


    // Left View of the tree
    public ArrayList<Integer> leftView(Node root){

        // Answer as arraylist
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        
        // Queue to maintain the nodes
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Iterate untill queue become empty
        while(!q.isEmpty()){
            int size = q.size();
            answer.add(q.peek().data);

            while(size-- > 0){
                Node top = q.remove();
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
        }
        return answer;
    }


    // Right view of the tree
    public ArrayList<Integer> rightView(Node root){

        // Answer as arraylist
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) return answer;

        // Queue to maintain the nodes
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Iterate until queue become empty
        while(!q.isEmpty()){
            int size = q.size();

            Node removedNode = q.peek();
            while(size-- > 0){
                Node top = q.remove();
                removedNode = top;
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
            answer.add(removedNode.data);

        }
        return answer;
    }


    public class pair{
        int level;
        int sum;

        public pair(int level, int sum){
            this.level = level;
            this.sum  = sum;
        }
    }
    // Sum of the longest bloodline in tree
    public void sumOfLongestBloodline(Node root, pair hsp){
        if (root == null) return new pair();

        pair leftTree = sumOfLongestBloodline(root.left, new pair(hsp.level+1, hsp.sum + root.data));
        pair rightTree = sumOfLongestBloodline(root.right, new pair(hsp.level+1, hsp.sum + root.data));
        
        

    }

    public void inO(){
        takeInputUsingRecursion(this.root);
        inOrderRecursion(this.root);
        //inOrderUsingIteration();

    }
}

