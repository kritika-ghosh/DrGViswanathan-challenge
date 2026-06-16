// Definition for a binary tree node.

import java.util.*;
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
public class Day6InvertBinaryTree {
    
    // Recursive function to invert the binary tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Swap left and right child pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

    // Helper method to print the tree in Level-Order (BFS) format for verification
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                // Only print structural placeholders if there are valid nodes left to process
                if (!queue.stream().allMatch(Objects::isNull)) {
                    result.add("null");
                }
            }
        }
        System.out.println(result);
    }

    // Driver code to test Day 6 implementation
    public static void main(String[] args) {
        /* Constructing LeetCode Example 1 Tree:
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        System.out.println("Original Tree Structure (Level-Order):");
        printLevelOrder(root);

        // Process inversion
        TreeNode invertedRoot = invertTree(root);

        System.out.println("\nInverted Tree Structure (Level-Order):");
        printLevelOrder(invertedRoot); 
        // Expected Output Structure: [4, 7, 2, 9, 6, 3, 1]
    }
}