import java.util.Arrays;
import java.util.ArrayList;

public class Day9MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Base case: if there are no intervals or just one, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals based on their start coordinates
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);

        // Step 2: Iterate and merge overlapping intervals
        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (currentEnd >= nextStart) { 
                // Overlap found: merge by updating the end boundary
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: switch reference to the next distinct interval and save it
                currentInterval = nextInterval;
                ans.add(currentInterval);
            }
        } 
        
        // Convert the dynamic list back to a 2D primitive array
        return ans.toArray(new int[ans.size()][]); 
    }

    // Driver code to test Day 9 implementation
    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test Case 1 Input: " + Arrays.deepToString(intervals1));
        int[][] result1 = merge(intervals1);
        System.out.println("Output: " + Arrays.deepToString(result1)); // Expected: [[1, 6], [8, 10], [15, 18]]
        System.out.println();

        // Test Case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Test Case 2 Input: " + Arrays.deepToString(intervals2));
        int[][] result2 = merge(intervals2);
        System.out.println("Output: " + Arrays.deepToString(result2)); // Expected: [[1, 5]]
    }
}