package leetcode.editor.en.Q238;

import java.util.*;

import javafx.util.Pair;

//Given an int array nums, return an array answer such that answer[i] is 
//equal to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//int. 
//
// You must write an algorithm that runs in O(n) time and without using the 
//division operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// 
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//int. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The 
//output array does not count as extra space for space complexity analysis.) 
//
// 👍 16107 👎 892


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodAhead = new int[nums.length];
        int[] res = new int[nums.length];
        productAhead(0, nums, prodAhead);
        productBehind(nums.length - 1, nums, res, prodAhead);
//
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = prodBehind[i] * prodAhead[i];
//        }

        return res;
    }

    private int productAhead(int start, int[] nums, int[] res) {
        if (start == nums.length) {
            return 1;
        }
//        if (res[start] != null) return res[start];
        res[start] = productAhead(start + 1, nums, res);
        return nums[start] * res[start];
    }

    private int productBehind(int start, int[] nums, int[] res, int[] prodAhead) {
        if (start == -1) {
            return 1;
        }
        int prodBehind = productBehind(start - 1, nums, res, prodAhead);
        res[start] = prodAhead[start] * prodBehind;
        return nums[start] * prodBehind;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class ProductOfArrayExceptSelf extends Solution {
}