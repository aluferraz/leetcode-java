package leetcode.editor.en.Q55;

import java.util.*;

//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 👍 13769 👎 728


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] cache;

    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }

//    public boolean canJump(int[] nums) {
//        cache = new int[(int) Math.pow(10, 5)];
//        return dfsJump(nums, 0);
//    }
//
//    private boolean dfsJump(int[] nums, int i) {
//        if (i == nums.length - 1) return true;
//        if (cache[i] == -1) {
//            return false;
//        }
//        if (i + nums[i] >= (nums.length - 1)) return true;
//        for (int j = 1; j <= nums[i]; j++) {
//            if (dfsJump(nums, i + j)) {
//                return true;
//            }
//        }
//        cache[i] = -1;
//        return false;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class JumpGame extends Solution {
}