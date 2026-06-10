
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }
    
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class Day2RemoveElementsLL {
    public static  ListNode removeElements(ListNode head, int val) {
        // Handle empty list
        if (head == null) {
            return null;
        }
        
        // Create a dummy node to handle removal at head easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        // Traverse the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                // Move to next node
                current = current.next;
            }
        }
        
        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Driver code to test the implementation
    public static void main(String[] args) {

        // Creating a sample linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int targetValue = 6;

        System.out.println("Original List:");
        printList(head);

        // Remove elements with value 6
        ListNode result = removeElements(head, targetValue);

        System.out.println("\nList after removing " + targetValue + ":");
        printList(result);
    }
}