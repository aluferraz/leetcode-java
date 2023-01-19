package leetcode.editor.en.Q918;

import java.util.*;

import javafx.util.Pair;

//Given a circular integer array nums of length n, return the maximum possible 
//sum of a non-empty subarray of nums. 
//
// A circular array means the end of the array connects to the beginning of the 
//array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the 
//previous element of nums[i] is nums[(i - 1 + n) % n]. 
//
// A subarray may only include each element of the fixed buffer nums at most 
//once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not 
//exist i <= k1, k2 <= j with k1 % n == k2 % n. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,-3,5]
//Output: 10
//Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// 
//
// Example 3: 
//
// 
//Input: nums = [-3,-2,-3]
//Output: -2
//Explanation: Subarray [-2] has maximum sum -2.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// 👍 4602 👎 203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] maxPrefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        maxPrefixSum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            maxPrefixSum[i] = Math.max(prefixSum[i], maxPrefixSum[i - 1]);
            max = Math.max(max, nums[i]);
            max = Math.max(max, maxPrefixSum[i]);
        }
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            int suffixSum = prefixSum[prefixSum.length - 1] - (i > 0 ? prefixSum[i - 1] : 0);
            int maxPrefix = (i > 0) ? maxPrefixSum[i - 1] : 0;
            maxPrefix = Math.max(maxPrefix, 0);
            int maxCycleSum = suffixSum + maxPrefix;
            max = Math.max(max, maxCycleSum);
            current += nums[i];
            max = Math.max(max, current);
            if (current < 0) {
                current = 0;
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumSumCircularSubarray extends Solution {
}