public class Node{

    // Attributes
    int val;
    Node left;
    Node right;
    
    // Constructors
    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}