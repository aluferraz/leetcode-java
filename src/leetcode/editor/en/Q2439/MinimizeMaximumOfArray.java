package leetcode.editor.en.Q2439;

import java.util.*;

import javafx.util.Pair;

//You are given a 0-indexed array nums comprising of n non-negative integers. 
//
// In one operation, you must: 
//
// 
// Choose an integer i such that 1 <= i < n and nums[i] > 0. 
// Decrease nums[i] by 1. 
// Increase nums[i - 1] by 1. 
// 
//
// Return the minimum possible value of the maximum integer of nums after 
//performing any number of operations. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,7,1,6]
//Output: 5
//Explanation:
//One set of optimal operations is as follows:
//1. Choose i = 1, and nums becomes [4,6,1,6].
//2. Choose i = 3, and nums becomes [4,6,2,5].
//3. Choose i = 1, and nums becomes [5,5,2,5].
//The maximum integer of nums is 5. It can be shown that the maximum number 
//cannot be less than 5.
//Therefore, we return 5.
// 
//
// Example 2: 
//
// 
//Input: nums = [10,1]
//Output: 10
//Explanation:
//It is optimal to leave nums as is, and since 10 is the maximum value, we 
//return 10.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 1000 👎 241


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimizeArrayValue(int[] nums) {
        int[] reversed = new int[nums.length];
        long left = 0;
        long right = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            reversed[nums.length - (i + 1)] = nums[i];
            right = Math.max(right, nums[i]);
        }
        right++;
        while (left < right) {
            //Guess an answer
            long mid = Math.floorDiv(left + right, 2);
            if (canUseNumber(mid, reversed)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean canUseNumber(long target, int[] nums) {
        long carryOn = 0;
        for (long num : nums) {
            num += carryOn;
            carryOn = 0;
            if (num >= target) {
                //If we place "target" at this index, we need to carry the diff to the right
                carryOn = num - target;
            }
        }
        return carryOn == 0;// We could place the target in the array
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimizeMaximumOfArray extends Solution {
}