package array.best_time_to_buy_and_sell_stock_2;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length - 1; i++)
            if(prices[i] < prices[i + 1])
                max += prices[i + 1] - prices[i];

        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);

        System.out.println(maxProfit);
    }
}
