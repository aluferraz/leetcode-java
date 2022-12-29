package leetcode.editor.en.Q1962;

import java.util.*;

//You are given a 0-indexed integer array piles, where piles[i] represents the 
//number of stones in the iᵗʰ pile, and an integer k. You should apply the 
//following operation exactly k times: 
//
// 
// Choose any piles[i] and remove floor(piles[i] / 2) stones from it. 
// 
//
// Notice that you can apply the operation on the same pile more than once. 
//
// Return the minimum possible total number of stones remaining after applying 
//the k operations. 
//
// floor(x) is the greatest integer that is smaller than or equal to x (i.e., 
//rounds x down). 
//
// 
// Example 1: 
//
// 
//Input: piles = [5,4,9], k = 2
//Output: 12
//Explanation: Steps of a possible scenario are:
//- Apply the operation on pile 2. The resulting piles are [5,4,5].
//- Apply the operation on pile 0. The resulting piles are [3,4,5].
//The total number of stones in [3,4,5] is 12.
// 
//
// Example 2: 
//
// 
//Input: piles = [4,3,6,7], k = 3
//Output: 12
//Explanation: Steps of a possible scenario are:
//- Apply the operation on pile 2. The resulting piles are [4,3,3,7].
//- Apply the operation on pile 3. The resulting piles are [4,3,3,4].
//- Apply the operation on pile 0. The resulting piles are [2,3,3,4].
//The total number of stones in [2,3,3,4] is 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁵ 
// 1 <= piles[i] <= 10⁴ 
// 1 <= k <= 10⁵ 
// 
//
// 👍 900 👎 81


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
            pq.add(pile);

        }
        while (k > 0 && (!pq.isEmpty())) {
            int target = pq.poll();
            sum -= target;
            target -= Math.floorDiv(target, 2);
            sum += target;
            pq.add(target);
            k--;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemoveStonesToMinimizeTheTotal extends Solution {
}