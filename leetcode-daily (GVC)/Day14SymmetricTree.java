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

public class Day14SymmetricTree {
    
    // Helper function to check if two trees are mirror images of each other
    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        // Base case: both nodes are null, meaning they match
        if (node1 == null && node2 == null) {
            return true;
        }
        // Base case: one node is null and the other isn't, structural mismatch
        if (node1 == null || node2 == null) {
            return false;
        }
        
        // Check if values match and outer/inner branches are structural mirrors
        return (node1.val == node2.val) 
            && isMirror(node1.left, node2.right) 
            && isMirror(node1.right, node2.left);
    }
    
    // Core function to check if the tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // Driver code to test Day 14 implementation
    public static void main(String[] args) {
        /* Test Case 1: Symmetric Tree
                 1
               /   \
              2     2
             / \   / \
            3   4 4   3
        */
        TreeNode symmetricTree = new TreeNode(1);
        symmetricTree.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        symmetricTree.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        System.out.println("Test Case 1 (Symmetric Tree):");
        System.out.println("Result: " + isSymmetric(symmetricTree)); // Expected: true
        System.out.println();

        /* Test Case 2: Asymmetric Tree
                 1
               /   \
              2     2
               \     \
               3      3
        */
        TreeNode asymmetricTree = new TreeNode(1);
        asymmetricTree.left = new TreeNode(2, null, new TreeNode(3));
        asymmetricTree.right = new TreeNode(2, null, new TreeNode(3));

        System.out.println("Test Case 2 (Asymmetric Tree):");
        System.out.println("Result: " + isSymmetric(asymmetricTree)); // Expected: false
    }
}