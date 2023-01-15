package leetcode.editor.en.Q746;

import java.util.*;

//You are given an integer array cost where cost[i] is the cost of iᵗʰ step on 
//a staircase. Once you pay the cost, you can either climb one or two steps. 
//
// You can either start from the step with index 0, or the step with index 1. 
//
// Return the minimum cost to reach the top of the floor. 
//
// 
// Example 1: 
//
// 
//Input: cost = [10,15,20]
//Output: 15
//Explanation: You will start at index 1.
//- Pay 15 and climb two steps to reach the top.
//The total cost is 15.
// 
//
// Example 2: 
//
// 
//Input: cost = [1,100,1,1,1,100,1,1,100,1]
//Output: 6
//Explanation: You will start at index 0.
//- Pay 1 and climb two steps to reach index 2.
//- Pay 1 and climb two steps to reach index 4.
//- Pay 1 and climb two steps to reach index 6.
//- Pay 1 and climb one step to reach index 7.
//- Pay 1 and climb two steps to reach index 9.
//- Pay 1 and climb one step to reach the top.
//The total cost is 6.
// 
//
// 
// Constraints: 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// 👍 8640 👎 1346


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new Integer[cost.length];
        return Math.min(minCostClimbingStairsHelper(0, cost), minCostClimbingStairsHelper(1, cost));
    }

    private int minCostClimbingStairsHelper(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }
        if (cache[i] != null) return cache[i];

        int costSkipOne = cost[i] + minCostClimbingStairsHelper(i + 1, cost);
        int costSkipTwo = cost[i] + minCostClimbingStairsHelper(i + 2, cost);
        cache[i] = Math.min(costSkipOne, costSkipTwo);
        return cache[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinCostClimbingStairs extends Solution {
}