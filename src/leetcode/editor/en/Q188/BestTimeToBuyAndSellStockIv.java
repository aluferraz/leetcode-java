package leetcode.editor.en.Q188;

import java.util.*;

import javafx.util.Pair;

//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day, and an integer k. 
//
// Find the maximum profit you can achieve. You may complete at most k 
//transactions: i.e. you may buy at most k times and sell at most k times. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// 👍 6335 👎 197


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][][] cache;
    int MIN = -1000000000;

    public int maxProfit(int k, int[] prices) {
        cache = new Integer[k + 1][prices.length][2];
        return maxProfit(k, 0, true, prices);

    }


    private int maxProfit(int k, int i, boolean canBuy, int[] prices) {
        if (k == 0 || i == prices.length) return 0;
        if (cache[k][i][canBuy ? 1 : 0] != null) {
            return cache[k][i][canBuy ? 1 : 0];
        }

        int buy = MIN;
        int sell = MIN;
        if (canBuy) {
            int buyHere = -prices[i] + maxProfit(k, i + 1, false, prices);
            int buyAhead = maxProfit(k, i + 1, true, prices);
            buy = Math.max(buyAhead, buyHere);
        } else {
            int sellHere = prices[i] + maxProfit(k - 1, i + 1, true, prices);
            int sellAhead = maxProfit(k, i + 1, false, prices);
            sell = Math.max(sellHere, sellAhead);
        }
        cache[k][i][canBuy ? 1 : 0] = Math.max(buy, sell);
        return cache[k][i][canBuy ? 1 : 0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BestTimeToBuyAndSellStockIv extends Solution {
}