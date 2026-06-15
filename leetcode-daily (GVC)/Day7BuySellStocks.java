import java.util.Arrays;

public class Day7BuySellStocks {
    public static int maxProfit(int[] prices) {
        // Handle edge cases for empty or single element arrays
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];
        
        // Single pass through the prices array
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update track of lowest buying price found so far
                minPrice = prices[i];
            } else {
                // Calculate potential profit if sold on the current day
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    // Driver code to test Day 7 implementation
    public static void main(String[] args) {
        // Test Case 1: Standard case where profit is achievable
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(prices1));
        System.out.println("Output (Max Profit): " + maxProfit(prices1)); // Expected: 5 (Buy at 1, Sell at 6)
        System.out.println();

        // Test Case 2: Downward trend case where no profit can be made
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2 Input: " + Arrays.toString(prices2));
        System.out.println("Output (Max Profit): " + maxProfit(prices2)); // Expected: 0
    }
}