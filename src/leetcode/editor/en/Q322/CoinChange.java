package leetcode.editor.en.Q322;

import java.util.*;

//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If 
//that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// 👍 14655 👎 335


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Long[] dp = new Long[amount + 1];
        Arrays.fill(dp, (long) Integer.MAX_VALUE);
        dp[0] = 0L;
        Arrays.sort(coins);
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            if (coin > amount) {
                break;
            }
            for (int j = coin; j <= amount; j++) {
//                long coinsNeeded = Math.floorDiv(j, coin);
                long coinsNeeded = 1L + dp[j - coin];
                dp[j] = Math.min(coinsNeeded, dp[j]);

            }
        }
        return dp[amount].intValue() == Integer.MAX_VALUE ? -1 : dp[amount].intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CoinChange extends Solution {
}