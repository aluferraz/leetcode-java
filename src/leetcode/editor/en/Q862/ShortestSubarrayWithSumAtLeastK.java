package leetcode.editor.en.Q862;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums and an integer k, return the length of the 
//shortest non-empty subarray of nums with a sum of at least k. If there is no such 
//subarray, return -1. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
// Input: nums = [1], k = 1
//Output: 1
// 
// Example 2: 
// Input: nums = [1,2], k = 4
//Output: -1
// 
// Example 3: 
// Input: nums = [2,-1,2], k = 3
//Output: 3
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// 👍 3645 👎 98


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // This is not optimal, should use deque https://www.youtube.com/watch?v=K0NgGYEAkA4
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        TreeMap<Integer, Integer> seen = new TreeMap<>();


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) return 1;
            //the sum is way too negative, it is better to start over because K is always positive .
            if (nums[i] > (sum + nums[i])) {
                sum = 0;
                left = i;
                seen.clear();
            }
            sum += nums[i];
            seen.put(sum, i);
            if (sum >= k) {
                int canRemove = sum - k;
                Integer prev = seen.floorKey(canRemove);

                int minRange = left - 1;

                while (prev != null) {
                    minRange = Math.max(minRange, seen.get(prev));
                    seen.remove(prev);
                    prev = seen.floorKey(canRemove);
                }


//                int minRange = binarySearchMinRange(left, i, presum, k);
                res = Math.min(i - minRange, res);

            }


        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestSubarrayWithSumAtLeastK extends Solution {
}