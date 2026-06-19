import java.util.Arrays;

public class Day11MaxSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int m = Integer.MIN_VALUE;

        int sum = 0;

        // Iterate through the array using Kadane's Algorithm
        for (int s = 0; s < n; s++) {
            sum += nums[s];

            // Update the global maximum if the current subarray sum is greater
            if (sum > m) {
                m = sum;
            }

            // If running sum becomes negative, reset it to discard the current prefix
            if (sum < 0) {
                sum = 0;
            }
        }

        return m;
    }

    // Driver code to test Day 11 implementation
    public static void main(String[] args) {
        // Test Case 1: Mixed positive and negative values
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output (Max Subarray Sum): " + maxSubArray(nums1)); // Expected: 6 ([4, -1, 2, 1])
        System.out.println();

        // Test Case 2: Single element array
        int[] nums2 = {1};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output (Max Subarray Sum): " + maxSubArray(nums2)); // Expected: 1
        System.out.println();

        // Test Case 3: All negative numbers (ensures initialization to MIN_VALUE works)
        int[] nums3 = {-5, -1, -3, -4};
        System.out.println("Test Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output (Max Subarray Sum): " + maxSubArray(nums3)); // Expected: -1 (Subarray containing just [-1])
    }
}