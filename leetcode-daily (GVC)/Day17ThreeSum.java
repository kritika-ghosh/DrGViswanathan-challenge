import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Day17ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the input array
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Initialize Two Pointers
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum == 0) {
                    // Match found: store the unique triplet
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; 
                    r--;
                    
                    // Skip duplicates for the second element
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    // Skip duplicates for the third element
                    while (l < r && nums[r] == nums[r + 1]) r--;
                    
                } else if (sum < 0) {
                    // Sum is too small, move toward larger elements
                    l++;
                } else {
                    // Sum is too big, move toward smaller elements
                    r--;
                }
            }
        }

        return res;
    }

    // Driver code to test Day 17 implementation
    public static void main(String[] args) {
        // Test Case 1: Standard mix containing multiple triplets
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output (Unique Triplets): " + threeSum(nums1)); 
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println();

        // Test Case 2: Array yielding no valid triplets
        int[] nums2 = {0, 1, 1};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2)); 
        // Expected Output: []
        System.out.println();

        // Test Case 3: All zeros
        int[] nums3 = {0, 0, 0, 0};
        System.out.println("Test Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSum(nums3)); 
        // Expected Output: [[0, 0, 0]]
    }
}