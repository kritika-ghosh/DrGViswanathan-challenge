package Arrays;

public class Move_all_Zeros_to_the_end {
    public static void moveZeroes(int[] nums) {
        int j = -1;
        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        // If no zero found, return
        if (j == -1) return;
        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }}}
    public static void main(String[] args) {
        int[] a={1,2,0,1,0,4,0};
        moveZeroes(a);
        for (Object elem : a) {
            System.out.println(elem);
        }
    }
}
