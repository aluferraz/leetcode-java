package leetcode.editor.en.Q260;

import java.util.*;

//Given an integer array nums, in which exactly two elements appear only once 
//and all the other elements appear exactly twice. Find the two elements that 
//appear only once. You can return the answer in any order. 
//
// You must write an algorithm that runs in linear runtime complexity and uses 
//only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,3,2,5]
//Output: [3,5]
//Explanation:  [5, 3] is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0]
//Output: [-1,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [0,1]
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each integer in nums will appear twice, only two integers will appear once. 
// 
//
// 👍 4588 👎 203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SingleNumberIii extends Solution {
}