/**
 * Day 22: Remove Nth Node From End of List
 * Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

// Definition for singly-linked list node.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day22RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        
        ListNode ptr = head;
        ListNode temp = head;
        
        // Move ptr forward n times to create the gap
        int i = 1;
        while (i <= n) {
            ptr = ptr.next; 
            i++;
        }
        
        // If ptr becomes null, we need to remove the head
        if (ptr == null) return head.next;
        
        // Move both until ptr reaches the last node
        while (ptr.next != null) {
            ptr = ptr.next;
            temp = temp.next;
        } 
        
        // Skip the nth node from the end
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper method to construct a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day22RemoveNthFromEnd solver = new Day22RemoveNthFromEnd();

        System.out.println("--- Day 22: Remove Nth Node From End of List ---");

        // Test Case 1: Removing a middle node (2nd from the end)
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(arr1);
        System.out.print("Original List: ");
        printList(head1);
        
        head1 = solver.removeNthFromEnd(head1, 2);
        System.out.print("After removing 2nd from end: ");
        printList(head1); // Expected: 1 -> 2 -> 3 -> 5 -> null
        System.out.println();

        // Test Case 2: Removing the head node (2nd from the end of a 2-node list)
        int[] arr2 = {1, 2};
        ListNode head2 = createList(arr2);
        System.out.print("Original List: ");
        printList(head2);
        
        head2 = solver.removeNthFromEnd(head2, 2);
        System.out.print("After removing 2nd from end (head): ");
        printList(head2); // Expected: 2 -> null
        System.out.println();

        // Test Case 3: Removing the only node left
        int[] arr3 = {1};
        ListNode head3 = createList(arr3);
        System.out.print("Original List: ");
        printList(head3);
        
        head3 = solver.removeNthFromEnd(head3, 1);
        System.out.print("After removing 1st from end: ");
        printList(head3); // Expected: null
    }
}