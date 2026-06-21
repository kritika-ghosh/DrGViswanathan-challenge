import java.util.Arrays;

public class Day13ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] ans = new int[n];
        
        // Step 1: Calculate prefix products
        pre[0] = 1;
        if (n > 1) {
            pre[1] = nums[0];
        }
        for (int i = 2; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate suffix products
        post[n - 1] = 1;
        if (n > 1) {
            post[n - 2] = nums[n - 1];
        }
        for (int i = n - 3; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }
        
        // Step 3: Compute final answer array
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * post[i];
        }
        
        return ans;
    }

    // Driver code to test Day 13 implementation
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [24, 12, 8, 6]
        System.out.println();

        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]
    }
}