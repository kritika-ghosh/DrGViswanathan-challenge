import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        int len= nums.length;
        for (int i=0; i<len; i++){
            for (int j=i+1; j<len; j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}

public class Day1TwoSum {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] testNums = {2, 7, 11, 15};
        int testTarget = 9;
        int[] result = solver.twoSum(testNums, testTarget);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}