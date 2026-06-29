import java.util.Arrays;

public class Day19BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Safe midpoint calculation to protect against overflow conditions
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target element discovered
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is larger, isolate the right half
            } else {
                right = mid - 1; // Target is smaller, isolate the left half
            }
        }

        return -1; // Target element does not exist within the array context
    }

    // Driver code to test Day 19 implementation
    public static void main(String[] args) {
        // Test Case 1: Target exists in the array
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test Case 1 Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output (Index): " + search(nums1, target1)); // Expected: 4
        System.out.println();

        // Test Case 2: Target does not exist in the array
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Test Case 2 Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output (Index): " + search(nums2, target2)); // Expected: -1
    }
}