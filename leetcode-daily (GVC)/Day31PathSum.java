/**
 * Day 31: Path Sum
 * Problem Link: https://leetcode.com/problems/path-sum/
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

public class Day31PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: empty tree node cannot contain a path sum
        if (root == null) {
            return false;
        }
        
        // Leaf node validation case
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Recursively look into left and right subtrees with an updated target sum
        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);
        
        // Return true if either path works out
        return leftSum || rightSum;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day31PathSum solver = new Day31PathSum();

        System.out.println("--- Day 31: Path Sum ---");

        /*
         * Constructing the following Binary Tree:
         * 5
         * / \
         * 4   8
         * /   / \
         * 11  13  4
         * /  \      \
         * 7    2      1
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // Test Case 1: Valid target sum path exists (5 -> 4 -> 11 -> 2 = 22)
        int targetSum1 = 22;
        boolean result1 = solver.hasPathSum(root, targetSum1);
        System.out.println("Target Sum: " + targetSum1);
        System.out.println("Path Exists: " + result1 + " (Expected: true)\n");

        // Test Case 2: Incomplete/invalid path sum target
        int targetSum2 = 26;
        boolean result2 = solver.hasPathSum(root, targetSum2);
        System.out.println("Target Sum: " + targetSum2);
        System.out.println("Path Exists: " + result2 + " (Expected: false)\n");

        // Test Case 3: Empty tree edge case evaluation
        TreeNode emptyRoot = null;
        int targetSum3 = 0;
        boolean result3 = solver.hasPathSum(emptyRoot, targetSum3);
        System.out.println("Target Sum: " + targetSum3 + " on Empty Tree");
        System.out.println("Path Exists: " + result3 + " (Expected: false)");
    }
}