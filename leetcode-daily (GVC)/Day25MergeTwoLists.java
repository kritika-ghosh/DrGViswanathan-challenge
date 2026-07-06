/**
 * Day 25: Merge Two Sorted Lists
 * Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */

// Definition for singly-linked list node.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day25MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a sentinel dummy node to ease head initialization logic
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Traverse both lists, stitching the smaller node to our result
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // Fast-attach the remainder of whichever list is left over
        curr.next = (list1 != null) ? list1 : list2;

        // The true sorted list head begins immediately after the dummy
        return dummy.next;
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
        Day25MergeTwoLists solver = new Day25MergeTwoLists();

        System.out.println("--- Day 25: Merge Two Sorted Lists ---");

        // Test Case 1: Standard populated sorted lists
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});
        
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);
        
        ListNode merged1 = solver.mergeTwoLists(list1, list2);
        System.out.print("Merged Sorted List: ");
        printList(merged1); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
        System.out.println();

        // Test Case 2: One list is empty
        ListNode list3 = createList(new int[]{});
        ListNode list4 = createList(new int[]{0});
        
        System.out.print("List 3: ");
        printList(list3);
        System.out.print("List 4: ");
        printList(list4);
        
        ListNode merged2 = solver.mergeTwoLists(list3, list4);
        System.out.print("Merged Sorted List: ");
        printList(merged2); // Expected: 0 -> null
        System.out.println();

        // Test Case 3: Both lists are empty
        ListNode list5 = null;
        ListNode list6 = null;
        
        ListNode merged3 = solver.mergeTwoLists(list5, list6);
        System.out.print("Merged Sorted List (Both Empty): ");
        printList(merged3); // Expected: null
    }
}