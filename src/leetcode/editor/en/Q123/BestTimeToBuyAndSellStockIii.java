package leetcode.editor.en.Q123;

//You are given an array prices where prices[i] is the price of a given stock
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you 
//are engaging multiple transactions at the same time. You must sell before buying 
//again.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// 👍 7428 👎 143


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public int maxProfit(int[] prices) {
        return maxProfitK(prices, 2);
    }

    public int maxProfitK(int[] prices, int k) {
        int[][] dp = new int[k + 1][prices.length];
        cache = new Integer[k + 1][prices.length];

        for (int transaction = 1; transaction <= k; transaction++) {
            for (int price = 1; price < prices.length; price++) {
                int max = dp[transaction][price - 1];
                int subMax = maxAtDay(price, transaction - 1, prices, dp);
                dp[transaction][price] = Math.max(max, subMax + prices[price]);
            }
        }
        return dp[k][dp[k].length - 1];
    }

    private int maxAtDay(int price, int transaction, int[] prices, int[][] dp) {
        if (price == 0) {
            return dp[transaction][price] - prices[price];
        }
        if (cache[transaction][price] != null) {
            return cache[transaction][price];
        }

        cache[transaction][price] = Math.max(dp[transaction][price] - prices[price], maxAtDay(price - 1, transaction, prices, dp));
        return cache[transaction][price];
//
//        for (int l = price - 1; l >= 0; l--) {
//            subMax = Math.max(subMax, (dp[transaction - 1][l] - prices[l]));
//        }
//        return subMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BestTimeToBuyAndSellStockIii extends Solution {
}