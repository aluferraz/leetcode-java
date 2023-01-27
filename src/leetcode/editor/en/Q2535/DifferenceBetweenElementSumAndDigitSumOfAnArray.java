package leetcode.editor.en.Q2535;

import java.util.*;

import javafx.util.Pair;

//You are given a positive integer array nums. 
//
// 
// The element sum is the sum of all the elements in nums. 
// The digit sum is the sum of all the digits (not necessarily distinct) that 
//appear in nums. 
// 
//
// Return the absolute difference between the element sum and digit sum of nums.
// 
//
// Note that the absolute difference between two integers x and y is defined as 
//|x - y|. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,15,6,3]
//Output: 9
//Explanation: 
//The element sum of nums is 1 + 15 + 6 + 3 = 25.
//The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
//The absolute difference between the element sum and digit sum is |25 - 16| = 9
//.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
//Explanation:
//The element sum of nums is 1 + 2 + 3 + 4 = 10.
//The digit sum of nums is 1 + 2 + 3 + 4 = 10.
//The absolute difference between the element sum and digit sum is |10 - 10| = 0
//.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2000 
// 1 <= nums[i] <= 2000 
// 
//
// 👍 200 👎 6


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int differenceOfSum(int[] nums) {
        int arrSum = 0;
        int digitSum = 0;
        for (int num : nums) {
            arrSum += num;
            String sNum = String.valueOf(num);
            for (int i = 0; i < sNum.length(); i++) {
                digitSum += Character.getNumericValue(sNum.charAt(i));
            }
        }
        return Math.abs(arrSum - digitSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DifferenceBetweenElementSumAndDigitSumOfAnArray extends Solution {
}