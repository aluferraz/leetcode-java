package leetcode.editor.en.Q1979;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return the greatest common divisor of the 
//smallest number and largest number in nums. 
//
// The greatest common divisor of two numbers is the largest positive integer 
//that evenly divides both numbers. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,5,6,9,10]
//Output: 2
//Explanation:
//The smallest number in nums is 2.
//The largest number in nums is 10.
//The greatest common divisor of 2 and 10 is 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [7,5,6,8,3]
//Output: 1
//Explanation:
//The smallest number in nums is 3.
//The largest number in nums is 8.
//The greatest common divisor of 3 and 8 is 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3]
//Output: 3
//Explanation:
//The smallest number in nums is 3.
//The largest number in nums is 3.
//The greatest common divisor of 3 and 3 is 3.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// 👍 799 👎 32


//leetcode submit region begin(Prohibit modification and deletion)
import java.math.BigInteger;

class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        return BigInteger.valueOf(min).gcd(BigInteger.valueOf(max)).intValue();

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindGreatestCommonDivisorOfArray extends Solution {
}