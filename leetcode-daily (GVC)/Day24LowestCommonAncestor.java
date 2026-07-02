/**
 * Day 24: Lowest Common Ancestor of a Binary Search Tree
 * Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Day24LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // If both nodes are smaller than root, LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both nodes are greater than root, LCA must be in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // We have found the split point, which is the LCA
        return root;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day24LowestCommonAncestor solver = new Day24LowestCommonAncestor();

        System.out.println("--- Day 24: Lowest Common Ancestor of a BST ---");

        /* 
         * Constructing the following BST for testing:
         *         6
         *       /   \
         *      2     8
         *     / \   / \
         *    0   4 7   9
         *       / \
         *      3   5
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Test Case 1: Nodes 2 and 8 (Split occurs right at the root)
        TreeNode p1 = root.left;       // Node 2
        TreeNode q1 = root.right;      // Node 8
        TreeNode lca1 = solver.lowestCommonAncestor(root, p1, q1);
        System.out.println("LCA of " + p1.val + " and " + q1.val + " is: " + lca1.val + " (Expected: 6)");

        // Test Case 2: Nodes 2 and 4 (Node 2 is the ancestor of node 4)
        TreeNode p2 = root.left;       // Node 2
        TreeNode q2 = root.left.right; // Node 4
        TreeNode lca2 = solver.lowestCommonAncestor(root, p2, q2);
        System.out.println("LCA of " + p2.val + " and " + q2.val + " is: " + lca2.val + " (Expected: 2)");

        // Test Case 3: Nodes 3 and 5 (LCA deep within the left subtree)
        TreeNode p3 = root.left.right.left;  // Node 3
        TreeNode q3 = root.left.right.right; // Node 5
        TreeNode lca3 = solver.lowestCommonAncestor(root, p3, q3);
        System.out.println("LCA of " + p3.val + " and " + q3.val + " is: " + lca3.val + " (Expected: 4)");
    }
}