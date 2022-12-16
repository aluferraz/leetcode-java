package leetcode.editor.en.Q53;

import java.util.*;

//Given an integer array nums, find the subarray which has the largest sum and 
//return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
//
// 👍 26862 👎 1203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumSubarray extends Solution {
}