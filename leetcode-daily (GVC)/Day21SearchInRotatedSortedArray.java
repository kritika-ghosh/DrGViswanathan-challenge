import java.util.Arrays;

/**
 * Day 21: Search in Rotated Sorted Array
 * Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Day21SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Target found
            if (nums[mid] == target) return mid;
            
            // Check if the left part is sorted
            if (nums[mid] >= nums[start]) {
                // Check if target lies within the sorted left part
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1; // move left
                } else {
                    start = mid + 1; // move right
                }
            } 
            // Otherwise, the right part must be sorted
            else {
                // Check if target lies within the sorted right part
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1; // move right
                } else {
                    end = mid - 1; // move left
                }
            }
        }
        // Target not found in the array
        return -1;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        
        Day21SearchInRotatedSortedArray solver = new Day21SearchInRotatedSortedArray();

        System.out.println("--- Day 21: Search in Rotated Sorted Array ---");

        // Test Case 1: Target exists in the left sorted portion
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = solver.search(nums1, target1);
        System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Found at index: " + result1 + " (Expected: 4)\n");

        // Test Case 2: Target does not exist in the array
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = solver.search(nums2, target2);
        System.out.println("Array: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Found at index: " + result2 + " (Expected: -1)\n");

        // Test Case 3: Target exists in a basic array with no rotation
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solver.search(nums3, target3);
        System.out.println("Array: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Found at index: " + result3 + " (Expected: -1)\n");
        
        // Test Case 4: Target exists in the right sorted portion
        int[] nums4 = {6, 7, 1, 2, 3, 4, 5};
        int target4 = 2;
        int result4 = solver.search(nums4, target4);
        System.out.println("Array: " + Arrays.toString(nums4) + ", Target: " + target4);
        System.out.println("Found at index: " + result4 + " (Expected: 3)");
    }
}