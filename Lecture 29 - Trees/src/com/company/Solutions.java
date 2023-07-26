// Level order traversal - Iterative [ List<List> | Stack ]

// [List]
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> answer = new LinkedList<List<Integer>>();
        if (root == null) return answer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                level.add(node.val);
            }
            answer.add(level);
        }
        Collections.reverse(answer);
        return answer;

        // Time O(n)
        // Space O(n)
    }
}

// [STACK] :: Reverse Level order traversal
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node root) 
    {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if (root == null) return answer;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        Stack<Integer> stack = new Stack<Integer>();

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node top = queue.poll();
                if(top.right != null) queue.offer(top.right);
                if(top.left != null) queue.offer(top.left);
                stack.push(top.data);
            }
        }

        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        return answer;
    }
}      


// Level Order Traversal - Recursive [ Hashmap ]
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        HashMap<Integer, ArrayList> answer = new HashMap<>();
        traverse(root, 0, answer);

        List<List<Integer>> finalAnswer = new LinkedList<List<Integer>>();
        for (ArrayList<Integer> item : answer.values()){
            finalAnswer.add(item);
        }
        Collections.reverse(finalAnswer);
        return finalAnswer;
    }

    public void traverse(TreeNode root, int level, HashMap<Integer, ArrayList> answer){
        if (root == null) return;

        if (answer.containsKey(level)){
            answer.get(level).add(root.val);
        }
        else{
            ArrayList<Integer> levelElements = new ArrayList<Integer>();
            answer.put(level, levelElements);
            answer.get(level).add(root.val);
        }

        traverse(root.left, level+1, answer);
        traverse(root.right, level+1, answer);
    }
}
