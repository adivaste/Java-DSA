
public class BoundryTraversal{

    public void leftTraversal(Node root){
        if (root == null ) return;
        if (root.left == null && root.right == null) return;

        System.out.print(" " + root.val);

        if (root.left != null){
            leftTraversal(root.left);
        }
        else{
            leftTraversal(root.right);
        }
    }

    public void rightReverseTraversal(Node root){
        if (root == null ) return;
        if (root.left == null && root.right == null) return;

        if (root.right != null){
            rightReverseTraversal(root.right);
        }
        else{
            rightReverseTraversal(root.left);
        }

        System.out.print(" " + root.val);
    }

    public void leafTraversal(Node root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            System.out.print(" " + root.val);
            return;
        }

        leafTraversal(root.left);
        leafTraversal(root.right);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        BoundryTraversal t = new BoundryTraversal();
        t.leftTraversal(root);
        t.leafTraversal(root);
        t.rightReverseTraversal(root.right);
        System.out.println();
    }
}