package leetcode.editor.en.Q325;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums and an integer k, return the maximum length of a 
//subarray that sums to k. If there is not one, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-1,5,-2,3], k = 3
//Output: 4
//Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,-1,2,1], k = 1
//Output: 2
//Explanation: The subarray [-1, 2] sums to 1 and is the longest.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁹ <= k <= 10⁹ 
// 
//
// 👍 1878 👎 55


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] presum = new int[nums.length];
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        presum[0] = nums[0];
        sumMap.put(0, -1);// If we need to sum 0, it means that the entire sum is equal to k
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            presum[i] = nums[i] + (i > 0 ? presum[i - 1] : 0);
            sumMap.putIfAbsent(presum[i], i); // The leftmost index with that value is the greedy choice.
            //p[i] - x = k
            //x = p[i] - k
            int complement = presum[i] - k;
            if (sumMap.containsKey(complement)) {
                int left = sumMap.get(complement);
                res = Math.max((i - left), res);
            }
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumSizeSubarraySumEqualsK extends Solution {
}