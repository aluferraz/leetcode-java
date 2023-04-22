package leetcode.editor.en.Q879;

import java.util.*;

import javafx.util.Pair;

//There is a group of n members, and a list of various crimes they could commit.
// The iᵗʰ crime generates a profit[i] and requires group[i] members to 
//participate in it. If a member participates in one crime, that member can't participate 
//in another crime. 
//
// Let's call a profitable scheme any subset of these crimes that generates at 
//least minProfit profit, and the total number of members participating in that 
//subset of crimes is at most n. 
//
// Return the number of schemes that can be chosen. Since the answer may be 
//very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
//Output: 2
//Explanation: To make a profit of at least 3, the group could either commit 
//crimes 0 and 1, or just crime 1.
//In total, there are 2 schemes. 
//
// Example 2: 
//
// 
//Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
//Output: 7
//Explanation: To make a profit of at least 5, the group could commit any 
//crimes, as long as they commit one.
//There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 0 <= minProfit <= 100 
// 1 <= group.length <= 100 
// 1 <= group[i] <= 100 
// profit.length == group.length 
// 0 <= profit[i] <= 100 
// 
//
// 👍 1098 👎 90


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final long MOD = 1000000007L;

    Long[][][] cache;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        cache = new Long[group.length][n + 1][minProfit + 1];


        return (int) (profitableSchemes(0, n, minProfit, group, profit) + (minProfit == 0 ? 1 : 0) % MOD);
    }


    private long profitableSchemes(int i, int n, int minProfit, int[] group, int[] profit) {
        if (i == group.length) {
            return 0L;
        }
        if (cache[i][n][minProfit] != null) {
            return cache[i][n][minProfit];
        }
        int crimeProfit = profit[i];
        int crimeGang = group[i];
        long profitable = crimeProfit >= minProfit ? 1L : 0L;
        long ans = 0L;
        if (crimeGang <= n) {
            ans = (profitable + profitableSchemes(i + 1, (n - crimeGang), Math.max((minProfit - crimeProfit), 0), group, profit)) % MOD;
        }
        ans = (ans + (profitableSchemes(i + 1, n, minProfit, group, profit))) % MOD;
        cache[i][n][minProfit] = ans;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ProfitableSchemes extends Solution {
}