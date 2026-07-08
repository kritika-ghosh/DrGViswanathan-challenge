/**
 * Day 29: Unique Paths
 * Problem Link: https://leetcode.com/problems/unique-paths/
 */
import java.util.Arrays;

public class Day29UniquePaths {
    public int uniquePaths(int m, int n) {
        // Base row array representing the row immediately above
        int[] aboveRow = new int[n];
        Arrays.fill(aboveRow, 1);

        // Process grid transitions row by row
        for (int row = 1; row < m; row++) {
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1);
            for (int col = 1; col < n; col++) {
                // Total ways = paths from left (col - 1) + paths from top (aboveRow[col])
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            // Move row window downward
            aboveRow = currentRow;
        }

        // The final element holds the cumulative paths to the target destination
        return aboveRow[n - 1]; 
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day29UniquePaths solver = new Day29UniquePaths();

        System.out.println("--- Day 29: Unique Paths ---");

        // Test Case 1: Small standard grid (3 x 7)
        int m1 = 3, n1 = 7;
        int result1 = solver.uniquePaths(m1, n1);
        System.out.println("Grid Size: " + m1 + "x" + n1);
        System.out.println("Unique Paths: " + result1 + " (Expected: 28)\n");

        // Test Case 2: Tiny grid setup (3 x 2)
        int m2 = 3, n2 = 2;
        int result2 = solver.uniquePaths(m2, n2);
        System.out.println("Grid Size: " + m2 + "x" + n2);
        System.out.println("Unique Paths: " + result2 + " (Expected: 3)\n");

        // Test Case 3: Single row grid boundary case (1 x 10)
        int m3 = 1, n3 = 10;
        int result3 = solver.uniquePaths(m3, n3);
        System.out.println("Grid Size: " + m3 + "x" + n3);
        System.out.println("Unique Paths: " + result3 + " (Expected: 1)");
    }
}