import java.util.*;

// Node Class
class Node{

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


public class Tree{
    
    // Root of the tree
    private Node root;

    // Constructors
    public Tree(int val){
        root = new Node(val);
    }

    // === Methods ===
    
    // === 1) Take user input for tree ===
    public void inputRecursivelyHelper(Node root){
        Scanner s = new Scanner(System.in);

        if (root == null){
            System.out.println("Enter the root of the tree : ");
            int val = s.nextInt();
            this.root = new Node(val);
        }

        System.out.println("Enter the left of the node " + root.val);
        int left = s.nextInt();
        System.out.println("Enter the right of the node " + root.val);
        int right = s.nextInt();

        if(left != -1){
            root.left = new Node(left);
            inputRecursivelyHelper(root.left);
        }
        if(right != -1){
            root.right = new Node(right);
            inputRecursivelyHelper(root.right);
        }        
    }

    public void inputRecursively(){
        inputRecursivelyHelper(this.root);
    }

    // === 2) Take input iteratively ===
    public void inputIteratively(){

        Queue<Node> queue = new LinkedList<Node>();
        Scanner s = new Scanner(System.in);

        
        if (root == null){
            System.out.println("Enter the root of the tree : ");
            int val = s.nextInt();
            this.root = new Node(val);
        }

        queue.offer(this.root);

        while(!queue.isEmpty()){
            Node current_node = queue.poll();
            System.out.print("Enter the val of Left child of "+ current_node.val +" :");
            int left = s.nextInt();
            System.out.print("\n Enter the val of Right Child of" + current_node.val +":");
            int right = s.nextInt();

            if (left != -1){
                current_node.left = new Node(left);
                queue.offer(current_node.left);
            }
            if (right != -1){
                current_node.right = new Node(right);
                queue.offer(current_node.right);
            }
        }
    }

    11500/2


    public static void main(String[] args){
        Tree t = new Tree(1);
        // t.inputRecursively();
        t.inputIteratively();

    }
}



/*
                 1 
               /   \
              2     3
             / \   / \
            4   5 6   7

                1
               / \
              2   3

        1
      /   \
     2     3
    / \   / \
   4   5 6   7

          1
       /     \
     2         3
    / \       / \
   4   5     6   7
  / \ / \   / \ / \
 8  9 4  6 8  3 4  8

1 : 1
2 : 5
3 : 11
4 : 19
*/