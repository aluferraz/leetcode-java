package leetcode.editor.en.Q1752;

import java.util.*;

import javafx.util.Pair;

//Given an array nums, return true if the array was originally sorted in non-
//decreasing order, then rotated some number of positions (including zero). 
//Otherwise, return false. 
//
// There may be duplicates in the original array. 
//
// Note: An array A rotated by x positions results in an array B of the same 
//length such that A[i] == B[(i+x) % A.length], where % is the modulo operation. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,5,1,2]
//Output: true
//Explanation: [1,2,3,4,5] is the original sorted array.
//You can rotate the array by x = 3 positions to begin on the the element of 
//value 3: [3,4,5,1,2].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,1,3,4]
//Output: false
//Explanation: There is no sorted array once rotated that can make nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: true
//Explanation: [1,2,3] is the original sorted array.
//You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
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
// 👍 1723 👎 80


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean check(int[] nums) {
        int min = nums[0];
        int minIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                minIdx = i;
                min = nums[i];
            }
        }
        int modIdx = minIdx;
        int prev = min;

        int end = nums.length - 1;
        while (end > 0 && nums[0] == nums[end]) {
            end--;
        }
        if (nums.length == 1) return true;

        for (int i = 0; i <= end; i++) {
            modIdx = (modIdx + 1) % (end + 1);
            if (modIdx == minIdx) break;
            if (nums[modIdx] < prev) {
                return false;
            }
            prev = nums[modIdx];
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CheckIfArrayIsSortedAndRotated extends Solution {
}