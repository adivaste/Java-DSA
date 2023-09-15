public class RemoveAllDuplicateOccur{
    
    public static void remove(Node head){
        
        // Temp pointer to traverse
        Node prev = null;
        Node temp = head;

        // Traverse the list
        while(temp != null){

            // Flag
            boolean areRemoved = false;

            // Remove all other duplicates
            while(temp.next != null && temp.val == temp.next.val){
                areRemoved = true;
                temp.next = temp.next.next;
            }

            // Delete the current node
            if (areRemoved){
                prev.next = temp.next;
                temp = prev.next;
            }
            

            // Move to next node
            if (temp != null){
                prev = temp;
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args){
    }
}
