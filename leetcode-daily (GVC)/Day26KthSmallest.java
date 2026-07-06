/**
 * Day 26: Kth Smallest Element in a BST
 * Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day26KthSmallest {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        // Reset state variables for fresh runs (critical for testing)
        count = 0;
        res = 0;
        
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null)
            return;

        // Traverse Left Subtree
        inorder(node.left, k);

        // Process Root Node
        count++;
        if (count == k) {
            res = node.val;
            return; // Target found
        }

        // Traverse Right Subtree
        inorder(node.right, k);
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day26KthSmallest solver = new Day26KthSmallest();

        System.out.println("--- Day 26: Kth Smallest Element in a BST ---");

        /*
         * Test Tree Structure:
         *       3
         *      / \
         *     1   4
         *      \
         *       2
         */
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        int k1 = 1;
        System.out.println("Test Case 1 (k = " + k1 + "):");
        System.out.println("Result: " + solver.kthSmallest(root1, k1) + " (Expected: 1)\n");

        /*
         * Test Tree Structure:
         *            5
         *           / \
         *          3   6
         *         / \
         *        2   4
         *       /
         *      1
         */
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        int k2 = 3;
        System.out.println("Test Case 2 (k = " + k2 + "):");
        System.out.println("Result: " + solver.kthSmallest(root2, k2) + " (Expected: 3)");
    }
}