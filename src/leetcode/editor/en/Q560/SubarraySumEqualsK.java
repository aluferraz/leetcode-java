package leetcode.editor.en.Q560;

import java.util.*;

import javafx.util.Pair;

//Given an array of integers nums and an integer k, return the total number of 
//subarrays whose sum equals to k. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// 
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// 👍 16930 👎 496


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> seen = new HashMap<>();
        int res = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            // X - y  = k
            // presum - Y = k
            //presum - k = Y
            int complement = prefixSum[i] - k;
            if (seen.containsKey(complement)) res += seen.get(complement);
            if (prefixSum[i] == k) res++;
            seen.put(prefixSum[i], seen.getOrDefault(prefixSum[i], 0) + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SubarraySumEqualsK extends Solution {
}