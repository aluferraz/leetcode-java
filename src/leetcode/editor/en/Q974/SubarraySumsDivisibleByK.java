package leetcode.editor.en.Q974;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums and an integer k, return the number of non-empty 
//subarrays that have a sum divisible by k. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// Example 2: 
//
// 
//Input: nums = [5], k = 9
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// 👍 4569 👎 174


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        // ( prefixSum[X] - prefixSum[Y] ) % K = 0; // Where Y <= X-1
        // (prefixSum[X]  % K) - (prefixSum[Y] % K) = 0;
        // (prefixSum[X]  % K) = (prefixSum[Y] % K);

//        HashMap<Integer, Integer> seen = new HashMap<>();
//        seen.put(0, 1);
        int res = 0;
        int current = 0;

        int[] seen = new int[k + 1];
        seen[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            current = Math.floorMod(current, k);
            res += seen[current];
            seen[current]++;
        }

        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class SubarraySumsDivisibleByK extends Solution {
}