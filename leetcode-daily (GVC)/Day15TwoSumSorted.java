import java.util.Arrays;

public class Day15TwoSumSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = 1;
        int[] res = new int[2];
        
        while (true) {
            int currentSum = numbers[ptr1] + numbers[ptr2];
            
            // Check if match is found
            if (currentSum == target) {
                res[0] = ptr1 + 1; // 1-indexed conversion
                res[1] = ptr2 + 1; // 1-indexed conversion
                return res;
            }
            
            // Shift indicators dynamically based on sum status
            if (currentSum > target) {
                ptr1--;
            } else {
                ptr1++;
                ptr2++;
            }
        }
    }

    // Driver code to test Day 15 implementation
    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1 Input: numbers = " + Arrays.toString(numbers1) + ", target = " + target1);
        System.out.println("Output (1-Indexed): " + Arrays.toString(twoSum(numbers1, target1))); // Expected: [1, 2]
        System.out.println();

        // Test Case 2: Array containing negative bounds
        int[] numbers2 = {-1, 0};
        int target2 = -1;
        System.out.println("Test Case 2 Input: numbers = " + Arrays.toString(numbers2) + ", target = " + target2);
        System.out.println("Output (1-Indexed): " + Arrays.toString(twoSum(numbers2, target2))); // Expected: [1, 2]
    }
}