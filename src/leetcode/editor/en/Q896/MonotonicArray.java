package leetcode.editor.en.Q896;

import java.util.*;

import javafx.util.Pair;

//An array is monotonic if it is either monotone increasing or monotone 
//decreasing. 
//
// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. 
//An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j]. 
//
// Given an integer array nums, return true if the given array is monotonic, or 
//false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,2,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [6,5,4,4]
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 👍 1967 👎 63


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] nums) {
        return isMonoIncreasing(nums) || isMonoDecreasing(nums);
    }

    private boolean isMonoIncreasing(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                return false;
            }
            stack.add(i);
        }
        return true;
    }

    private boolean isMonoDecreasing(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                return false;
            }
            stack.add(i);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MonotonicArray extends Solution {
}