// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Day20LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // Traverse the list with fast and slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Moves by two steps
            slow = slow.next;      // Moves by one step

            // Cycle detected if pointers meet
            if (fast == slow) {
                return true;
            }
        }

        return false; // Fast pointer reached the end, no cycle exists
    }

    // Driver code to test Day 20 implementation
    public static void main(String[] args) {
        // Test Case 1: Linked list with a cycle
        // Creating nodes: 3 -> 2 -> 0 -> -4
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a loop back to node 2

        System.out.println("Test Case 1 (List with Cycle):");
        System.out.println("Result: " + hasCycle(head1)); // Expected: true
        System.out.println();

        // Test Case 2: Linked list without a cycle
        // Creating nodes: 1 -> 2 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Test Case 2 (List without Cycle):");
        System.out.println("Result: " + hasCycle(head2)); // Expected: false
    }
}