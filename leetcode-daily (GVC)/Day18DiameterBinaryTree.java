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

public class Day18DiameterBinaryTree {
    // Instance variable to track the maximum diameter found across the entire tree context
    private int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    // Helper function that calculates height and updates the global maximum diameter inline
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // Update the global maximum diameter if the path through the current node is longer
        max = Math.max(max, left + right);
        
        // Return the depth of the current node's subtree to the parent call
        return Math.max(left, right) + 1;  
    }

    // Driver code to test Day 18 implementation
    public static void main(String[] args) {
        Day18DiameterBinaryTree solver = new Day18DiameterBinaryTree();

        /* Test Case 1: Longest path passes through the root node
                 1
                / \
               2   3
              / \     
             4   5    
        */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root1.right = new TreeNode(3);

        System.out.println("Test Case 1:");
        System.out.println("Result (Diameter): " + solver.diameterOfBinaryTree(root1)); // Expected: 3 (Path: 4->2->1->3 or 5->2->1->3)
        System.out.println();

        // Resetting internal max tracker for the next standalone evaluation
        Day18DiameterBinaryTree solver2 = new Day18DiameterBinaryTree();
        
        /* Test Case 2: Only two nodes
                 1
                /
               2
        */
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Test Case 2:");
        System.out.println("Result (Diameter): " + solver2.diameterOfBinaryTree(root2)); // Expected: 1 (Path: 2->1)
    }
}