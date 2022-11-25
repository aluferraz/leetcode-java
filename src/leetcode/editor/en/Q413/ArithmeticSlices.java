package leetcode.editor.en.Q413;

import java.util.*;

//An integer array is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic 
//sequences. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of 
//nums. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
//
// 👍 4391 👎 266


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int sum = 0;

    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }

    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ArithmeticSlices extends Solution {
}