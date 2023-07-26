// --- LINKED LIST QUESTIONS ---

// Basic Construction :
    - Singly Linked List
    - Doubly Linked List
    - Circular Linked List

// Other Questions :
    1. Convert the Binary Number Linked List to Integer
    2. Split the linked list into two halfs
    3. Remove duplicates from the unosorted linked list
    4. 


// ============================================================================

// --- SOLUTIONS ---

// Q.1) Convert Binary Number in a Linked List to Integer

// Approach 1 : Find the length of the linked list and just like we 
// convert binary number using 2^Power and 1|0's we will calculate 
// the sum of numbers

class Solution {
    public int getDecimalValue(ListNode head) {

        // Store answer, and it will updated eventually        
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

// Time complexity   :: O(n) [Length calculation] + O(n) [ Finding and updating the answer }
//                   :: O(n) + O(n)
//                   :: O(2n)
//                   ~= O(n)
// Space complexity  :: O(1) [ Constant Space for Variable ]]
//                   ~= O(1)   

// ****************************************************************************

// Approach 2 : Consider there is only one node in linked list, so 
// answer will 2^0, now you discovers another node, now as per 
// bitwise operators when you left shift current number get doubled, 
// so you will add the current nodes answer in existing answer.


class Solution {
    public int getDecimalValue(ListNode head) {
        
        int answer = 0;

        // Traverse and modify answer
        ListNode temp = head;
        while(temp != null){
            answer *= 2;                       // As we left shift, value get's doubled
            answer += temp.val*Math.pow(2,0);  // or answer += temp.val;
            temp = temp.next;
        }
        
        // return answer
        return answer;
    }
}

// Time Complexity  :: O(n) [ For traversing linked list and updating array ]
//                  ~= O(n)
// Space Complexity :: O(1) [ Constant time for maths operations and vars ]
//                  ~= O(1)

// ****************************************************************************

// Approach 2 [Modified] : We are just using the bitwise operators here

class Solution {
    public int getDecimalValue(ListNode head) {

        int ans = 0;

        // Traverse and modify answer
        ListNode temp = head;
        while(temp != null){
            ans = (ans << 1) | temp.val;  // Here answer is doubled (left shif)
                                          // and OR with current data value, 
                                          // which adds up in answer.
            temp = temp.next;
        }
        
        return ans;
    }
}

// Time Complexity  :: O(n) [ For traversing linked list and updating array ]
//                  ~= O(n)
// Space Complexity :: O(1) [ Constant time for maths operations and vars ]
//                  ~= O(1)

// ============================================================================

// Q.2) Design a hashset

// Approach 1 : Using the Arrays

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


// ****************************************************************************

// Approach 2 : Using the linked list within arrays for chaining and hashing
// algos are used along with it.


class MyHashSet {

    private LinkedList<Integer>[] HashSet;
    private Integer size;
    
    public MyHashSet() {
        this.size = 10000+1;
        this.HashSet = (LinkedList<Integer>[]) new LinkedList[this.size];
        for (int i = 0; i < this.size; i++) {
            HashSet[i] = new LinkedList<>();
        }
    }
    
    public int getIndex(int key){
        return key%size;
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

// ==================================================================
// Q. Design a Hashset

// Approach 1 :

class MyHashMap {

    private int size;
    private int[] hashmap;

    public MyHashMap() {
        this.size = 1000000 + 1;
        this.hashmap = new int[this.size];
        for(int i=0; i<this.size; i++){
            this.hashmap[i] = -1;
        }
    }   
    
    public void put(int key, int value) {
        this.hashmap[key] = value;
    }
    
    public int get(int key) {
        return this.hashmap[key];
    }
    
    public void remove(int key) {
        this.hashmap[key] = -1;
    }
}


// Approach 2 :
class MyHashMap {
    
    private int size;
    private LinkedList<Pair<Integer, Integer>>[] hashmap;

    public MyHashMap() {
        this.size = 100000 + 1;
        this.hashmap = new LinkedList[this.size];

        for (int i = 0; i < this.size; i++) {
            this.hashmap[i] = new LinkedList<>();
        }
    }

    public int getIndex(int key) {
        return key % this.size;
    }

    public int getInnerIndex(int key) {
        int index = getIndex(key);
        for (int i = 0; i < hashmap[index].size(); i++) {
            if (hashmap[index].get(i).getKey().equals(key)) return i;
        }
        return -1;
    }

    public void put(int key, int value) {
        Pair<Integer, Integer> temp = new Pair(key, value);
        int index = getIndex(key);
        int innerIndex = getInnerIndex(key);

        if (innerIndex != -1) {
            this.hashmap[index].set(innerIndex, temp); // Update the existing key-value pair
        } else {
            this.hashmap[index].add(temp); // Add a new key-value pair
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        int innerIndex = getInnerIndex(key);

        if (innerIndex != -1) {
            return this.hashmap[index].get(innerIndex).getValue(); // Return the value if key exists
        }

        return -1; // Key not found, return -1
    }

    public void remove(int key) {
        int index = getIndex(key);
        int innerIndex = getInnerIndex(key);

        if (innerIndex != -1) {
            this.hashmap[index].remove(innerIndex); // Remove the key-value pair if key exists
        }
    }
}

// ==================================================================

// Q.4) Remove the node from a linked list when no head is given

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

// Space complexity : O(1)
// Time complexity : O(1)

// ============================================================================
// Q.5) Find the Middle of the linked list


// Approach 1 : Traverse and find the length of the linked list 
// then make half of the length and that many traversal need to 
// make to reach the second middle

// If length = 6 ==> 6/2 = 3 
// If length = 5 ==> 5/2 = 2

class Solution {
    public ListNode middleNode(ListNode head) {

        // Find the length
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        
        // Iterate that len/2 many times
        int noOfTraversals = length/2;
        temp = head;
        while(noOfTraversals != 0){
            temp = temp.next;
            noOfTraversals--;
        }

        return temp;
    }
}

// ****************************************************************************
// Approach 2 : Use slow and fast pointer, fast pointer has double 
// speed than slow one, when fast reaches end, then return the slow

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

// ============================================================================
// Q.6 Remove duplicates from the linked list


// Approach 1 : Get the value of next node, if its same you
// current then remove the next node, if not same otherwise go next

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp != null){
            // Check next value is same as curr, before that check next is present
            // or not. If not same then go next
            if((temp.next != null) && (temp.val == temp.next.val)){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}

// ****************************************************************************
// Approach 2 : Recursive apporach 

class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } 
        else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }
}

// ****************************************************************************
// Approach 3 : Using the set to keep track of elements


public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    Set<Integer> uniqueValues = new HashSet<>();

    while (head != null) {
        if (!uniqueValues.contains(head.val)) {
            uniqueValues.add(head.val);
            prev.next = head;
            prev = prev.next;
        }
        head = head.next;
    }

    prev.next = null; // Ensure the last node points to null (end of the list)

    return dummy.next;
}

// ============================================================================

// Q.7) Remove all the instances of duplicates numbers, keep only distinct


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Skip all nodes with duplicate values
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }

            // If duplicates are found, skip the entire group
            if (prev.next != current) {
                prev.next = current.next;
            } else {
                prev = current; // Move the previous pointer
            }

            current = current.next; // Move the current pointer
        }

        return dummy.next;
    }

}

// ****************************************************************************

// Approach 2 : Recursive Approach


public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    if (head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
            head = head.next; // Skip all nodes with duplicate values
        }
        return deleteDuplicates(head.next); // Recursively call for next distinct node
    } else {
        head.next = deleteDuplicates(head.next); // Recursively call for the rest of the list
        return head;
    }
}

// ============================================================================

// Q.8) Reverse the linked list 

// Approach 1 : Iterative apporach

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)  return null;
        if (head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }

        head = prev;
        return head;
        
    }
}

// ****************************************************************************
// Approach 2 : Recursive Approach 


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)  return head;

        ListNode revHead = reverseList(head.next);

        ListNode temp = head.next;
        temp.next = head;
        head.next = null;

        return revHead;
    }
}

// ============================================================================

// Q.9 ) Detect the cycle in Linked List

// Approach 1 : Store each node in the HashTable, and each time you visited check
// node is present in hashtable or not, if yes then cycle is there return true,
// otherwise return false. (In this apporach more space will be there and time also)

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null)  return false;
        
        // Storing the node each time we visit
        HashMap<ListNode, Integer> hashmap = new HashMap<>();

        ListNode temp = head;
        while(temp != null){
            for(ListNode node : hashmap.keySet()){
                if (temp == node) return true;
            }
            hashmap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
}

// Time complexity  :: O(n^2) [For traversing node and checking node is present] 
//                  ~= O(n^2)
// Space complexity :: O(n) [For storing all the nodes]
//                  ~= O(n)

// ****************************************************************************

// Approach 2 : Same as first one, but using the HashSet to improve time
// complexity

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        // Base case
        if (head == null || head.next == null)  return false;

        // Storing the node each time we visit
        Set<ListNode> hashset = new HashSet<ListNode>();

        ListNode temp = head;
        while(temp != null){
            if (hashset.contains(temp)) return true;
            hashset.add(temp);
            temp = temp.next;
        }
        return false;
    }
}

// Time complexity  :: O(n) [For traversing node and checking node is present]
//                      as set takes ~= O(1) time
//                  ~= O(n)
// Space complexity :: O(n) [For storing all the nodes for set]
//                  ~= O(n)

// ****************************************************************************

// Approach 3 : Using the fast and slow pointer, at the some point they will meet
// each other.

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)  return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}

// Time complexity  :: O(n) [At worst case slow pointer will traverse all nodes]
//                  == O(n)
// Space complexity :: O(1) [Not using any extra space other than variables]
//                  ~= O(1)

// =============================================================================
// Q. 10 ) Find the starting point of the loop 

// Approach 1 : Use the hashset to store the nodes, if current node is present inside 
// a hashset that's the starting node. Otherwise insert the current node to set.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        // Use hashset
        HashSet<ListNode> hashset = new HashSet<>();

        ListNode temp = head;
        while(temp != null && temp.next != null){
            if (hashset.contains(temp)) return temp;
            hashset.add(temp);
            temp = temp.next;
        }

        return null;
    }
}

// Time complexity  :: O(n) [For traversing node and checking node is present]
//                      as set takes ~= O(1) time
//                  ~= O(n)
// Space complexity :: O(n) [For storing all the nodes for set]
//                  ~= O(n)

// ****************************************************************************
// Approach 2: Fast and slow pointers 

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null)  return null;

        // Approach 2 : Fast and slow pointers

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                while( slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }
}

// ============================================================================

// Q. 11) Detect Remove the cycle from the linked list

// Approach 1: Use Same set properties to store the elements, but each time we will
// keep track of prev pointer which will help use in removing the cycle. And after 
// finding the link if current node is not null or last node, then we will pointer
// next of current to "null". Otherwise we will find ourself changing the pointer 
// of non-cyclic linked list.

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if (head == null || head.next == null) return;
        
        // Use Hashset to store elements
        HashSet<Node> hashset = new HashSet<>();
        
        // TEMP
        Node temp = head;
        Node prevNode = null;
        
        while(temp != null && temp.next != null){
            if (hashset.contains(temp)) break;
            hashset.add(temp);
            
            prevNode = temp;
            temp = temp.next;
        }
        
        // Making check and returning, bcz we may change the pointers of non-cyclic
        // linked list
        if (temp == null || temp.next == null) return;
        
        // Changing the next pointer of prev to null for cyclic LL
        prevNode.next = null;
    }
}

// ****************************************************************************
// Approach 2: Use the Fast and slow pointers. i.e. Floyed-cycle detection algo.

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if (head == null || head.next == null) return;
        
        Node fast = head;
        Node slow = head;
        Node entry = head;
        Node prev = null;  // Reason we used here is that, there may be case that,
                           // loop is on 1st node, so in that case entry will not
                           // traverse anymore, and we will not get a chance to 
                           // update our prev, so.
        
        while(fast != null && fast.next != null){
            prev = slow;   // We are updating with prev because, that's the one, who
                           // will iterate and update time to time whenn entry pointer
                           // is started.
            
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast){
                while(slow != entry){
                    prev = slow;   // Ones we find the loop we will update previous with slow
                    
                    slow = slow.next;
                    entry = entry.next;
                }
                prev.next = null;  
                break;             // After updating break the loop otherwise it will point in 
                                   // NullPointerExpeception
            }
        }
    }
}

// Refer strivers video : Becuase intuation is there, which is very important
// ============================================================================

// Q.12) Merge two linked list 

// Approach 1: Using third linked list

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // Answer : merge of two
        ListNode merged = new ListNode(-1);

        // Pointer for two ll for traversing
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode temp = merged;

        while(temp1 != null && temp2 != null){

            if (temp1.val < temp2.val){
                ListNode newNode = new ListNode(temp1.val);
                temp.next = newNode;
                temp = newNode;
                temp1 = temp1.next;
            }
            else{
                ListNode newNode = new ListNode(temp2.val);
                temp.next = newNode;
                temp = newNode;
                temp2 = temp2.next;
            }
        }

        if (temp1 == null){
            while(temp2 != null){
                ListNode newNode = new ListNode(temp2.val);
                temp.next = newNode;
                temp = newNode;
                temp2 = temp2.next;
            }
        }

        if (temp2 == null){
            while(temp1 != null){
                ListNode newNode = new ListNode(temp1.val);
                temp.next = newNode;
                temp = newNode;
                temp1 = temp1.next;
            }
        }

        return merged.next;
    }
}

// ****************************************************************************
// Approach 2 : Without using the extra space, just moving the pointers

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode answer = l1;
        while(l1 != null && l2 != null){
            ListNode prev = null;
            while(l1 != null && l1.val <= l2.val){
                prev = l1;
                l1 = l1.next;
            }
            prev.next = l2;

            // Swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return answer;
    }
}

// ============================================================================

// Q.13) Adding two number in a linked list

// Approach 1 : Use the carry and sum variable and create the new node, and 
// join them eventually

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(-1);

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int sum = 0;
        int carry = 0;

        ListNode temp = answer;
        while(temp1 != null && temp2 != null){
            sum = temp1.val + temp2.val + carry;
            if (sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            else{
                carry = 0;
            }
                        
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 == null && temp2 != null){
            sum = temp2.val + carry;
            if (sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            else carry = 0;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            temp2 = temp2.next;
        }

        while (temp2 == null  && temp1 != null){
            sum = temp1.val + carry;
            if (sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            else carry = 0;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            temp1 = temp1.next;
        }

        if (temp1 == null && temp2 == null && carry == 1) temp.next = new ListNode(1);

        return answer.next;        
    }
}

// Improved Code :: 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum %= 10;
            current.next = new ListNode(sum);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

// ****************************************************************************

// Approach 2 : In place algorithm

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Get length of each list
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        // Select for the answer
        ListNode temp = l1;
        ListNode answer = l2;

        if (len1 > len2){
            answer = l1;
            temp = l2;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = answer;


        // Traverse the "temp" to add in "answer"
        int sum = 0;
        int carry = 0;

        ListNode prev = answer;
        while(temp != null){
            sum = answer.val + temp.val + carry;

            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            else carry = 0;

            answer.val = sum;

            temp = temp.next;
            prev = answer;
            answer = answer.next;
        }

        while(answer != null){
            sum = answer.val + carry;

            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            else carry = 0;

            answer.val = sum;
            prev = answer;
            answer = answer.next;
        }

        if (carry == 1){
            prev.next = new ListNode(1);
        }

        return dummy.next;

        
    }

    public int getLength(ListNode list){
        int len = 0;
        if (list == null) return 0;
        while(list != null){
            len++;
            list = list.next;
        }
        return len;
    }

}

// ============================================================================

// Q.13) Palindrome

// Approach 1 : Use a arraylist or vector to store the data, and check for that 
// data strcuture is it palindrome or not

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ArrayList<Integer> answer = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            answer.add(temp.val);
            temp = temp.next;
        }

        // boolean isPalindrome = true;
        int len = answer.size();
        for(int i=0; i<len/2; i++){
            if (answer.get(i) != answer.get(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}

// Approach 2 : Clone the linked list and reverse it and check till middle, which
// is more complex


// Approach 3: Find the middle of linked list, and start from 1st node and mid+1 node
// and compare them, use fast and slow pointers

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or single element list is considered a palindrome
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverse(slow);

        // Compare the first half with the reversed second half
        ListNode firstHalf = head;
        ListNode secondHalf = reversedSecondHalf;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

}

// ============================================================================
// Q.15) Rotate the linked list

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        // Approach 1 : As we are rotating the linked list, anti clock wise
        // direction, so back elements will come back to the front, that means 
        // we have to connect the last node to front, and break the link from 
        // somewhere

        if (head == null || k==0) return head;

        // Point last to head
        ListNode temp = head;
        int size = 0;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        size++;
        temp.next = head;

        // So that traversal do not cross size 
        k = k%size;

        // Break the chain
        int  traversalsToMake = size - k - 1;
        temp = head;
        while(traversalsToMake != 0){
            temp = temp.next;
            traversalsToMake--;
        }

        // Modify next and head
        head = temp.next;
        temp.next = null;

        return head;
    }
}

// ****************************************************************************

// Approach 2 : Rotate using brutforce, where we have to pick up load node and 
// put it on front and update the head. So we will do this "k" times

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed
        }

        // Calculate the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Perform k right rotations
        for (int i = 0; i < k % length; i++) {
            ListNode current = head;
            ListNode prev = null;

            // Move to the second-to-last node
            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            // Move the last node to the front
            current.next = head;
            head = current;
            prev.next = null;
        }

        return head;
    }
}
