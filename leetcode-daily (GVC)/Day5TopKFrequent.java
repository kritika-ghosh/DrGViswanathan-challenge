import java.util.*;

public class Day5TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        // Step 1: Populate the frequency map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Step 2: Extract keys and sort them using a custom lambda comparator based on frequency
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((a, b) -> map.get(b) - map.get(a));
        
        // Step 3: Extract the top K frequent elements
        for (int j = 0; j < k; j++) {
            res[j] = keyList.get(j);
        }
        
        return res;
    }

    // Driver code to test Day 5 implementation
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test Case 1 Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(topKFrequent(nums1, k1))); // Expected: [1, 2]
        System.out.println();

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2 Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(topKFrequent(nums2, k2))); // Expected: [1]
    }
}