// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day16BalancedBinaryTree {
    
    // Core function to check if the tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    // Helper function that returns height if balanced, or -1 if unbalanced
    private static int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Check left subtree balance status
        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        // Check right subtree balance status
        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        // If current node violates the balance condition, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the actual height of the current node's subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Driver code to test Day 16 implementation
    public static void main(String[] args) {
        /* Test Case 1: Balanced Binary Tree
                 3
                / \
               9  20
                 /  \
                15   7
        */
        TreeNode balancedRoot = new TreeNode(3);
        balancedRoot.left = new TreeNode(9);
        balancedRoot.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("Test Case 1 (Balanced Tree):");
        System.out.println("Result: " + isBalanced(balancedRoot)); // Expected: true
        System.out.println();

        /* Test Case 2: Unbalanced Binary Tree
                   1
                  / \
                 2   2
                / \
               3   3
              / \
             4   4
        */
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.right = new TreeNode(2);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3, new TreeNode(4), new TreeNode(4));
        unbalancedRoot.left.right = new TreeNode(3);

        System.out.println("Test Case 2 (Unbalanced Tree):");
        System.out.println("Result: " + isBalanced(unbalancedRoot)); // Expected: false
    }
}