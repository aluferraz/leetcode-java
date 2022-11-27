package leetcode.editor.en.Q1235;

import java.util.*;

//We have n jobs, where every job is scheduled to be done from startTime[i] to 
//endTime[i], obtaining a profit of profit[i]. 
//
// You're given the startTime, endTime and profit arrays, return the maximum 
//profit you can take such that there are no two jobs in the subset with overlapping 
//time range. 
//
// If you choose a job that ends at time X you will be able to start another 
//job that starts at time X. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// 
//
// Example 2: 
//
// 
//
// 
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
//,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job. 
//Profit obtained 150 = 20 + 70 + 60.
// 
//
// Example 3: 
//
// 
//
// 
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴ 
// 1 <= startTime[i] < endTime[i] <= 10⁹ 
// 1 <= profit[i] <= 10⁴ 
// 
//
// 👍 4510 👎 51


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://www.youtube.com/watch?v=WxcgT9YBeNg
    final int START_EVENT = 1;
    final int END_EVENT = 0; // We want to sum all ENDs before checking the next start

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Arrays::compare);
        int bestProfit = 0;

        for (int i = 0; i < startTime.length; i++) {
            Integer[] element = new Integer[]{
                    startTime[i],
                    START_EVENT,
                    endTime[i],
                    profit[i]
            };
            pq.add(element);
        }

        while (pq.size() > 0) {
            Integer[] element = pq.poll();
            int start = element[0];
            int type = element[1];
            int end = element[2];
            int gain = element[3];
            switch (type) {
                case START_EVENT:
                    pq.add(new Integer[]{
                            end,
                            END_EVENT,
                            0,
                            bestProfit + gain
                    });
                    break;
                case END_EVENT:
                    bestProfit = Math.max(bestProfit, gain);
            }
        }
        return bestProfit;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumProfitInJobScheduling extends Solution {
}