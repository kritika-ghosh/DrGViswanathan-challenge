import java.util.LinkedList;
import java.util.Queue;

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

public class Day10MaxDepthBinaryTree {
    
    // Core solution logic to compute maximum depth
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Add 1 (current level) to the maximum depth of either the left or right subtree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Driver code to test Day 10 implementation
    public static void main(String[] args) {
        /* Constructing LeetCode Example 1 Tree:
                 3
                / \
               9  20
                 /  \
                15   7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("Calculating maximum depth of the binary tree...");
        int depth = maxDepth(root);
        
        System.out.println("Output (Maximum Depth): " + depth); // Expected: 3
        
        // Test Case 2: A single root node tree
        TreeNode singleNode = new TreeNode(1);
        System.out.println("Output for Single Node Tree: " + maxDepth(singleNode)); // Expected: 1
    }
}