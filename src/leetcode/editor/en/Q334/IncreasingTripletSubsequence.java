package leetcode.editor.en.Q334;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return true if there exists a triple of indices (
//i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such 
//indices exists, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5]
//Output: true
//Explanation: Any triplet where i < j < k is valid.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,4,3,2,1]
//Output: false
//Explanation: No triplet exists.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,1,5,0,4,6]
//Output: true
//Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 
//4 < nums[5] == 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you implement a solution that runs in 
//O(n) time complexity and 
//O(1) space complexity?
//
// 👍 6188 👎 268


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] mins = new int[nums.length];
        int[] max = new int[nums.length];
        mins[0] = nums[0];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
            max[nums.length - (1 + i)] = Math.max(nums[nums.length - (1 + i)], max[nums.length - i]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > mins[i - 1] && nums[i] < max[i + 1]) return true;
        }
        return false;

    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class IncreasingTripletSubsequence extends Solution {
}