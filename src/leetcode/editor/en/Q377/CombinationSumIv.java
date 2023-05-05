package leetcode.editor.en.Q377;

import java.util.*;

import javafx.util.Pair;

//Given an array of distinct integers nums and a target integer target, return 
//the number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow 
//negative numbers? 
//
// 👍 5638 👎 571


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[] cache;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        cache = new Integer[target + 1];
        return combinationSum4Helper(nums, target);
    }

    public int combinationSum4Helper(int[] nums, int target) {
        if (target == 0) return 1;
        if (nums[0] > target) return 0;
        if (cache[target] != null) return cache[target];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += combinationSum4Helper(nums, target - nums[i]);
        }
        cache[target] = ans;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CombinationSumIv extends Solution {
}