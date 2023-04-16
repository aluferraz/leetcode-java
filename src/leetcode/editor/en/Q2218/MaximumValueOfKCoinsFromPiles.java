package leetcode.editor.en.Q2218;

import java.util.*;

import javafx.util.Pair;

//There are n piles of coins on a table. Each pile consists of a positive 
//number of coins of assorted denominations. 
//
// In one move, you can choose any coin on top of any pile, remove it, and add 
//it to your wallet. 
//
// Given a list piles, where piles[i] is a list of integers denoting the 
//composition of the iᵗʰ pile from top to bottom, and a positive integer k, return the 
//maximum total value of coins you can have in your wallet if you choose exactly k 
//coins optimally. 
//
// 
// Example 1: 
// 
// 
//Input: piles = [[1,100,3],[7,8,9]], k = 2
//Output: 101
//Explanation:
//The above diagram shows the different ways we can choose k coins.
//The maximum total we can obtain is 101.
// 
//
// Example 2: 
//
// 
//Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
//Output: 706
//Explanation:
//The maximum total can be obtained if we choose all coins from the last pile.
// 
//
// 
// Constraints: 
//
// 
// n == piles.length 
// 1 <= n <= 1000 
// 1 <= piles[i][j] <= 10⁵ 
// 1 <= k <= sum(piles[i].length) <= 2000 
// 
//
// 👍 1531 👎 24


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int n = piles.size();
        cache = new Integer[n][k + 1];
        return maxValueOfCoins(0, piles, k);
    }

    public int maxValueOfCoins(int i, List<List<Integer>> piles, int k) {
        if (i == piles.size()) {
            return 0;
        }
        if (k == 0) return 0;
        if (cache[i][k] != null) return cache[i][k];

        List<Integer> pile = piles.get(i);

        int best = 0;
        int score = 0;
        for (int j = 0; j < Math.min(pile.size(), k); j++) {
            int skip = maxValueOfCoins(i + 1, piles, k);
            score += pile.get(j);
            int takeCoin = score + maxValueOfCoins(i + 1, piles, k - (j + 1));
            int bestMove = Math.max(takeCoin, skip);
            best = Math.max(bestMove, best);
        }
        cache[i][k] = best;
        return best;


    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumValueOfKCoinsFromPiles extends Solution {
}