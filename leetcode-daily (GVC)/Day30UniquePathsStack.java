/**
 * Day 30: Unique Paths (Iterative Top-Down with Memoization & Explicit Stack)
 * Problem Link: https://leetcode.com/problems/unique-paths/
 */
import java.util.Stack;

public class Day30UniquePathsStack {
    static class GridState {
        int r, c;
        int state; // 0: Explore Right, 1: Explore Down, 2: Process/Aggregate

        GridState(int r, int c) {
            this.r = r;
            this.c = c;
            this.state = 0;
        }
    }

    public int uniquePaths(int m, int n) {
        // Memoization table to store results of subproblems
        int[][] memo = new int[m][n];
        
        // Stack to simulate the system call stack
        Stack<GridState> stack = new Stack<>();
        stack.push(new GridState(0, 0));

        while (!stack.isEmpty()) {
            GridState current = stack.peek();
            int r = current.r;
            int c = current.c;

            // Base Case 1: Reached the bottom-right corner
            if (r == m - 1 && c == n - 1) {
                memo[r][c] = 1;
                stack.pop();
                continue;
            }

            // Base Case 2: If already computed, pop and move on
            if (memo[r][c] > 0) {
                stack.pop();
                continue;
            }

            if (current.state == 0) {
                // Step 1: Explore RIGHT neighbor if within bounds
                current.state = 1;
                if (c + 1 < n) {
                    if (memo[r][c + 1] == 0) {
                        stack.push(new GridState(r, c + 1));
                    }
                }
            } else if (current.state == 1) {
                // Step 2: Explore DOWN neighbor if within bounds
                current.state = 2;
                if (r + 1 < m) {
                    if (memo[r + 1][c] == 0) {
                        stack.push(new GridState(r + 1, c));
                    }
                }
            } else {
                // Step 3: Both choices explored, aggregate results into memo table
                int rightPaths = (c + 1 < n) ? memo[r][c + 1] : 0;
                int downPaths = (r + 1 < m) ? memo[r + 1][c] : 0;
                
                memo[r][c] = rightPaths + downPaths;
                stack.pop(); // Fully processed, remove from stack
            }
        }

        // The result will be aggregated back up to the starting cell
        return memo[0][0];
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day30UniquePathsStack solver = new Day30UniquePathsStack();

        System.out.println("--- Day 30: Unique Paths (Explicit Stack) ---");

        // Test Case 1: Standard grid (3 x 7)
        int m1 = 3, n1 = 7;
        int result1 = solver.uniquePaths(m1, n1);
        System.out.println("Grid Size: " + m1 + "x" + n1);
        System.out.println("Unique Paths: " + result1 + " (Expected: 28)\n");

        // Test Case 2: Small grid (3 x 2)
        int m2 = 3, n2 = 2;
        int result2 = solver.uniquePaths(m2, n2);
        System.out.println("Grid Size: " + m2 + "x" + n2);
        System.out.println("Unique Paths: " + result2 + " (Expected: 3)");
    }
}