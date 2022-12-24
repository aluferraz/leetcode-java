package leetcode.editor.en.Q309;

import java.util.*;

//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like (i.e., buy one and sell one share of the stock multiple times) 
//with the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., 
//cooldown one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// 👍 7005 👎 236


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    Integer[][] cache;

    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] wait = new int[prices.length];

        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sell[i] = buy[i - 1] + prices[i];
            wait[i] = Math.max(wait[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], wait[i - 1] - prices[i]);
        }
        return Math.max(sell[prices.length - 1], wait[prices.length - 1]);

    }


//    public int maxProfit(int[] prices) {
//        cache = new Integer[prices.length][2];
//        return maxProfitHelper(prices, 0, 1);
//    }

//    private int maxProfitHelper(int[] prices, int i, int canBuy) {
//        if (i >= prices.length) {
//            return 0;
//        }
//        if (cache[i][canBuy] != null) return cache[i][canBuy];
//        int newValue;
//        if (canBuy == 1) {
//            int buy = maxProfitHelper(prices, i + 1, 0) - prices[i]; //buy
//            int cooldown = maxProfitHelper(prices, i + 1, 1);  //do nothing
//            newValue = Math.max(buy, cooldown);
//        } else {
//            int sell = prices[i] + maxProfitHelper(prices, i + 2, 1); //Sell
//            int cooldown = maxProfitHelper(prices, i + 1, 0); //do nothing
//            newValue = Math.max(sell, cooldown);
//        }
//        cache[i][canBuy] = newValue;
//        return newValue;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BestTimeToBuyAndSellStockWithCooldown extends Solution {
}