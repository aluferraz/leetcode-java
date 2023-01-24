package leetcode.editor.en.Q1085;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return 0 if the sum of the digits of the minimum 
//integer in nums is odd, or 1 otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [34,23,1,24,75,33,54,8]
//Output: 0
//Explanation: The minimal element is 1, and the sum of those digits is 1 which 
//is odd, so the answer is 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [99,77,33,66,55]
//Output: 1
//Explanation: The minimal element is 33, and the sum of those digits is 3 + 3 =
// 6 which is even, so the answer is 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
//
// 👍 102 👎 146


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int sum = 0;
        String s = String.valueOf(min);
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return (sum % 2 == 0 ? 1 : 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SumOfDigitsInTheMinimumNumber extends Solution {
}