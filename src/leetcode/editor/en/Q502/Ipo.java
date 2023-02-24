package leetcode.editor.en.Q502;

import java.util.*;

import javafx.util.Pair;

//Suppose LeetCode will start its IPO soon. In order to sell a good price of 
//its shares to Venture Capital, LeetCode would like to work on some projects to 
//increase its capital before the IPO. Since it has limited resources, it can only 
//finish at most k distinct projects before the IPO. Help LeetCode design the best 
//way to maximize its total capital after finishing at most k distinct projects. 
//
// You are given n projects where the iᵗʰ project has a pure profit profits[i] 
//and a minimum capital of capital[i] is needed to start it. 
//
// Initially, you have w capital. When you finish a project, you will obtain 
//its pure profit and the profit will be added to your total capital. 
//
// Pick a list of at most k distinct projects from given projects to maximize 
//your final capital, and return the final maximized capital. 
//
// The answer is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
//Output: 4
//Explanation: Since your initial capital is 0, you can only start the project 
//indexed 0.
//After finishing it you will obtain profit 1 and your capital becomes 1.
//With capital 1, you can either start the project indexed 1 or the project 
//indexed 2.
//Since you can choose at most 2 projects, you need to finish the project 
//indexed 2 to get the maximum capital.
//Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 10⁵ 
// 0 <= w <= 10⁹ 
// n == profits.length 
// n == capital.length 
// 1 <= n <= 10⁵ 
// 0 <= profits[i] <= 10⁴ 
// 0 <= capital[i] <= 10⁹ 
// 
//
// 👍 1612 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //Max-Profit with minimum capital  - pq1
        //capital is limited, so sort by capital -  pq2

        int[][] capitalVsProfit = new int[capital.length][2];

        PriorityQueue<int[]> maxProfits = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // minimum cap
            return -Integer.compare(a[1], b[1]); //Max profit
        });
        PriorityQueue<int[]> minimumCapital = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return -Integer.compare(a[1], b[1]); //Max profit
            return Integer.compare(a[0], b[0]); // minimum cap
        });


        for (int i = 0; i < profits.length; i++) {
            capitalVsProfit[i] = new int[]{capital[i], profits[i]};
            minimumCapital.add(capitalVsProfit[i]);
        }
        int res = w;

        for (int i = 0; i < k; i++) {

            while (!maxProfits.isEmpty() && maxProfits.peek()[0] > w) {
                minimumCapital.add(maxProfits.poll());
            }
            while (!minimumCapital.isEmpty() && minimumCapital.peek()[0] <= w) {
                maxProfits.add(minimumCapital.poll());
            }
            if (maxProfits.isEmpty()) break;

            int[] capitalAndProfit = maxProfits.poll();
            //w -= capitalAndProfit[0]; //Cost
            w += capitalAndProfit[1]; //Profit

            res = Math.max(res, w);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class Ipo extends Solution {
}