// ---------------- Questions & Answers -------------------

// *--Question.01--* Delete the node from Linked List

// :: Solution.01.01
class Solution {
    public void deleteNode(ListNode node) {
        // Swap value with next node
        int nextData = node.next.val;
        node.next.val = node.val;
        node.val = nextData;

        // Delete the next node.
        node.next = node.next.next;
    }
}

// :: Solution.01.02
class Solution {
    public void deleteNode(ListNode node) {
        if (node.next == null){
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// --------------------------------------------------------
// *--Question.02--* Middle of the linked list

// :: Solution.02.01
class Solution {
    public ListNode middleNode(ListNode head) {
        
        // Get size of linked list
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        // Number of traverse to make - for even and odd both are same,
        // when second middle is asked. But for first middle, only for 
        // even case minus 1 is there. If even -> n = n-1. No change
        int n = size/2;
        
        // Traverse and move the temp head
        temp = head;
        while(n != 0){
            temp = temp.next;
            n--;
        }

        // return node
        return temp;
    }
}


// :: Solution.02.02  || [-- OPTIMIZED --]
class Solution {
    public ListNode middleNode(ListNode head) {

        if (head == null) return head;
        if (head.next == null) return head;

        // Use fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


// --------------------------------------------------------
// *--Question.03--* Binary Linked List to Integer

// :: Solution.03.01
class Solution {
    public int getDecimalValue(ListNode head) {
        
        // Approach 1 : Find length and use powers

        int answer = 0;

        // Get length of linked list
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        // According to power of 2 add the digits to answer
        int power = length - 1;
        temp = head;
        while(temp != null){
            answer += temp.val*Math.pow(2, power);
            temp = temp.next;
            power--;
        }

        // return answer
        return answer;
    }
}

// :: Solution.03.02  || [-- OPTIMIZED --]
class Solution {
    public int getDecimalValue(ListNode head) {
        
        // Approach 2 : Consider the first node as last number, then discover
        // a next node, and multiply by 2, then add current node answer

        int answer = 0;

        // traverse and modify answer
        ListNode temp = head;
        while(temp != null){
            answer *= 2;
            answer += temp.val*Math.pow(2,0);  // or answer += temp.val;
            temp = temp.next;
        }
        
        return answer;
    }
}

// :: Solution.03.03  || [: Making reverse LL and Powers :] || [-- LENGTHY --]

// --------------------------------------------------------
// *--Question.04--* Creating the HashSet

// :: Solution.04.01
class MyHashSet {

    private boolean[] HashSet;

    public MyHashSet() {
        int size = 1000000 + 1;
        this.HashSet = new boolean[size];
    }
    
    public void add(int key) {
        this.HashSet[key] = true;
    }
    
    public void remove(int key) {
        this.HashSet[key] = false;
    }
    
    public boolean contains(int key) {
        return this.HashSet[key];
    }
}


// :: Solution.04.02
class MyHashSet {

    private LinkedList<Integer>[] HashSet;
    private Integer size;

    public MyHashSet() {
        this.size = 1000+1;
        this.HashSet = (LinkedList<Integer>[]) new LinkedList[this.size];
        for (int i = 0; i < this.size; i++) {
            HashSet[i] = new LinkedList<>();
        }
    }

    public int getIndex(int key){

    }

    public int getListIndex(int key){
        int index = getIndex(key);
        return HashSet[index].indexOf(key);
    }

    public void add(int key) {
        int index = getIndex(key);
        if (getListIndex(key) == -1){
            HashSet[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int internalIndex = getListIndex(key);
        if ( internalIndex != -1){
            HashSet[index].remove(internalIndex);
        }
    }

    public boolean contains(int key) {
        return (getListIndex(key) != -1);
    }
}
