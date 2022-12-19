package leetcode.editor.en.Q410;

import java.util.*;

//Given an integer array nums and an integer k, split nums into k non-empty 
//subarrays such that the largest sum of any subarray is minimized. 
//
// Return the minimized largest sum of the split. 
//
// A subarray is a contiguous part of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], k = 2
//Output: 18
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum 
//among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], k = 2
//Output: 9
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum 
//among the two subarrays is only 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// 👍 7294 👎 166


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Integer[][] cache;

//    int result = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
//        result = presum[presum.length - 1];
        cache = new Integer[nums.length][k + 1];
        return evaluate(0, nums.length, k, presum);

    }

    private int evaluate(int left, int right, int k, int[] presum) {
        if (k == 1) {
            return left > 0 ? presum[(right - k)] - presum[left - 1] : presum[(right - k)];
        }
        if (cache[left][k] != null) return cache[left][k];
        int bestCombination = Integer.MAX_VALUE;
        for (int i = left; i <= (right - k); i++) {
            int slice = left > 0 ? presum[i] - presum[left - 1] : presum[i];
            int nextSlice = evaluate((i + 1), right, k - 1, presum);
            bestCombination = Math.min(bestCombination, Math.max(slice, nextSlice));
        }
        cache[left][k] = bestCombination;
        return bestCombination;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SplitArrayLargestSum extends Solution {
}