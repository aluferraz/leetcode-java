package leetcode.editor.en.Q1567;

import java.util.*;

import javafx.util.Pair;

//Given an array of integers nums, find the maximum length of a subarray where 
//the product of all its elements is positive. 
//
// A subarray of an array is a consecutive sequence of zero or more values 
//taken out of that array. 
//
// Return the maximum length of a subarray with positive product. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-2,-3,4]
//Output: 4
//Explanation: The array nums already has a positive product of 24.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,-2,-3,-4]
//Output: 3
//Explanation: The longest subarray with positive product is [1,-2,-3] which 
//has a product of 6.
//Notice that we cannot include 0 in the subarray since that'll make the 
//product 0 which is not positive. 
//
// Example 3: 
//
// 
//Input: nums = [-1,-2,-3,0,1]
//Output: 2
//Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 👍 2146 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int getMaxLen(int[] nums) {

        int[] nextNeg = new int[nums.length];
        Arrays.fill(nextNeg, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = (nums[i] > 0 ? 1 : -1);
            } else {
                stack.clear();
                continue;
            }
            while (!stack.isEmpty() && nums[i] < 0) {
                nextNeg[stack.pollLast()] = i;
            }
            stack.add(i);
        }


        return getMaxLen(0, nums, nextNeg);


    }


    public int getMaxLen(int left, int[] nums, int[] nextNeg) {
        if (left >= nums.length) {
            return 0;
        }
        int right = left;
        int prod = 1;
        int max = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                return Math.max(getMaxLen(right + 1, nums, nextNeg), max);
            }
            prod = prod * (nums[right] > 0 ? 1 : -1);
            if (prod > 0) {
                max = Math.max(max, right - left + 1);
            } else {
                if (nextNeg[right] == -1) {
                    //There are no new negs ahead
                    while (left <= right && prod < 0) {
                        prod /= nums[left];
                        left++;
                    }
                }
            }
            right++;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumLengthOfSubarrayWithPositiveProduct extends Solution {
}