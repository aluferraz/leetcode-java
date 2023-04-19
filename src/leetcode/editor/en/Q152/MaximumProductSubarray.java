package leetcode.editor.en.Q152;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, find a subarray that has the largest product, 
//and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 👍 15669 👎 473


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int max = 0;

    public int maxProduct(int[] nums) {
        max = Arrays.stream(nums).min().getAsInt();
        maxProduct(0, nums);
        return max;
    }

    public int[] maxProduct(int i, int[] nums) {
        if (i == nums.length) {
            return new int[]{1, 1};
        }
        int num = nums[i];
        int[] next = maxProduct(i + 1, nums);
        int newMax = Math.max(num, num * next[0]);
        newMax = Math.max(newMax, num * next[1]);
        int newMin = Math.min(num, num * next[0]);
        newMin = Math.min(newMin, num * next[1]);
        max = Math.max(max, newMax);

        return new int[]{newMax, newMin};
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumProductSubarray extends Solution {
}