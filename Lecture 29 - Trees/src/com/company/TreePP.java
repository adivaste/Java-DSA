public class TreePP{
    
    // Node of the tree
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

        // Constructor - 2
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Root of the tree
    private Node root;

    // Constructor for tree - 1
    public TreePP(){
        this.root = null;
    }

    // Constructor for tree - 2
    public TreePP(int data){
        this.root = new Node(data);
    }

    // Constructor for tree - 3
    public TreePP(int data, Node left, Node right){
        this.root = new Node(data, left, right);
    }

    // Take User Input - Recursion
    public void takeUserInput1(Node root){
        
        // Take root node input
        if(root == null){
            Scanner s = new Scanner(System.In);
            System.out.println("Enter the root node : ");
            int rootValue = s.nextInt();
            root = new Node(rootValue);
        }
        
        System.out.println("Enter the left of " + root.data);
        Scanner s = new Scanner(System.In);

        int leftValue = s.nextInt();
        if (leftValue != -1){
            root.left = new Node(leftValue);
            takeUserInput1(root.left);
        }
 
        System.out.println("Enter the right of " + root.data);
        int rightValue = s.nextInt();
        if (rightValue != -1){
            root.right = new Node(rightValue);
            takeUserInput1(root.right);
        }
    }


    // Take User Input - Iteration (Queue)
    public void takeUserInput2(Node root){

    }

    // Lowest common ancestor (LCA - Storing)
    public void LCA1(Node root, Node node1, Node node2){
        
        public void findPathOfNode1(Node root){
            
        }
        public void findPathOfNode2(Node root){

        }
    }


}
