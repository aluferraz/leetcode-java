package leetcode.editor.en.Q1004;

import java.util.*;

//Given a binary array nums and an integer k, return the maximum number of 
//consecutive 1's in the array if you can flip at most k 0's. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined. 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 0 <= k <= nums.length 
// 
//
// 👍 5606 👎 66


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int runningSum = 0;
        int originalK = k;
        while (right < nums.length) {
            if (nums[right] == 0) {
                while (k == 0 && left <= right) {
                    runningSum--;
                    k += (nums[left] == 0 ? 1 : 0);
                    left++;
                }
                k--;
            }
            if (k < 0) {
                runningSum = 0;
                k = originalK;
            } else {
                runningSum++;
            }
            result = Math.max(result, runningSum);
            right++;
        }
        return result;
    }
//
//    private int longestOnesHelper(int[] nums, int k, int i) {
//        if (i == nums.length) return 0;
//        if (k == 0 && nums[i] == 0) return 0;
//        if (cache[i][k] != null) {
//            return cache[i][k];
//        }
//        if (nums[i] == 0) {
//            cache[i][k] = 1 + longestOnesHelper(nums, k - 1, i + 1);
//            return cache[i][k];
//        }
//        cache[i][k] = 1 + longestOnesHelper(nums, k, i + 1);
//        return cache[i][k];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaxConsecutiveOnesIii extends Solution {
}