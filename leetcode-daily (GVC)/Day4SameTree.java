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

public class Day4SameTree {
    
    // Recursive helper function to compare nodes step-by-step
    public static boolean helper(TreeNode curr_p, TreeNode curr_q) {
        // Base case: If one or both nodes are null
        if (curr_p == null || curr_q == null) {
            if (curr_p == null && curr_q == null) {
                return true;
            }
            return false;
        }
        
        // Base case: If both nodes are leaf nodes
        if (curr_p.left == null && curr_q.left == null && curr_p.right == null && curr_q.right == null) {
            if (curr_p.val == curr_q.val) {
                return true;
            }
            return false;
        }
        
        // Recursively check left and right subtrees
        boolean l = helper(curr_p.left, curr_q.left);
        boolean r = helper(curr_p.right, curr_q.right);
        
        // Check current node value along with subtree results
        if (curr_p.val == curr_q.val) {
            return (l && r);
        } else {
            return false;
        }
    }
    
    // Main function to check if trees are identical
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Edge cases
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        
        // Check root node value directly before starting recursion
        if (p.val != q.val) {
            return false;
        }

        return helper(p, q);
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        
        System.out.println("Test Case 1 (Identical Trees):");
        System.out.println("Result: " + isSameTree(p1, q1)); // Expected: true
        System.out.println();

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        
        System.out.println("Test Case 2 (Structurally Different):");
        System.out.println("Result: " + isSameTree(p2, q2)); // Expected: false
        System.out.println();

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        
        System.out.println("Test Case 3 (Value Mismatch):");
        System.out.println("Result: " + isSameTree(p3, q3)); // Expected: false
    }
}