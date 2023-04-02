package leetcode.editor.en.Q2594;

import java.util.*;

import javafx.util.Pair;

//You are given an integer array ranks representing the ranks of some mechanics.
// ranksi is the rank of the iᵗʰ mechanic. A mechanic with a rank r can repair n 
//cars in r * n² minutes. 
//
// You are also given an integer cars representing the total number of cars 
//waiting in the garage to be repaired. 
//
// Return the minimum time taken to repair all the cars. 
//
// Note: All the mechanics can repair the cars simultaneously. 
//
// 
// Example 1: 
//
// 
//Input: ranks = [4,2,3,1], cars = 10
//Output: 16
//Explanation: 
//- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16
// minutes.
//- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8
// minutes.
//- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12
// minutes.
//- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 
//16 minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​
//​
// 
//
// Example 2: 
//
// 
//Input: ranks = [5,1,8], cars = 6
//Output: 16
//Explanation: 
//- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 
//minutes.
//- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 
//16 minutes.
//- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 
//minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​
//​
// 
//
// 
// Constraints: 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// 👍 312 👎 13


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = (long) 1e14;
        while (low < high) {
            long mid = low + (high - low) / 2, repaired_cars = 0;
            for (int r : ranks)
                repaired_cars += Math.sqrt(mid / r);
            if (repaired_cars < cars) low = mid + 1;
            else high = mid;
        }
        return low;
    }

/* tle:
    public long repairCars(int[] ranks, int cars) {
        PriorityQueue<long[]> carsRepared = new PriorityQueue<>((a, b) -> {
            long nextRepairCarA = a[0] + 1;
            long nextRepairCarB = b[0] + 1;
            long nextRepairA = nextRepairCarA * nextRepairCarA * a[1];
            long nextRepairB = nextRepairCarB * nextRepairCarB * b[1];
            if (nextRepairA == nextRepairB) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(nextRepairA, nextRepairB);
        });
        for (int i = 0; i < ranks.length; i++) {
            carsRepared.add(new long[]{0, ranks[i], i});
        }
        long timeNeeded = 0;
        while (cars > 0) {
            long[] nextMechanicInfo = carsRepared.poll();
            long carsReparedByMechnic = ++nextMechanicInfo[0];
            long finishTime = nextMechanicInfo[1] * (carsReparedByMechnic * carsReparedByMechnic);
            timeNeeded = Math.max(finishTime, timeNeeded);
            cars--;
            carsRepared.add(nextMechanicInfo);
        }
        return timeNeeded;

    }

 */
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumTimeToRepairCars extends Solution {
}