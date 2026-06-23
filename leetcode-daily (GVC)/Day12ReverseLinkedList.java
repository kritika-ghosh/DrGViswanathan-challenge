// Definition for singly-linked list.
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

public class Day12ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        // Traverse the list and invert the pointers inline
        while (curr != null) {
            ListNode temp = curr.next;  // Store next node safely
            curr.next = prev;           // Reverse the current pointer
            prev = curr;                // Move prev one step forward
            curr = temp;                // Move curr one step forward
        }
        
        return prev; // New head of the reversed list
    }

    // Helper method to print the linked list layout
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Driver code to test Day 12 implementation
    public static void main(String[] args) {
        // Constructing a sample list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the list
        ListNode reversedHead = reverseList(head);

        System.out.println("\nReversed Linked List:");
        printList(reversedHead); // Expected: 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}