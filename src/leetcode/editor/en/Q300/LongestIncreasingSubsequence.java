package leetcode.editor.en.Q300;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// 👍 16823 👎 311


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lengthOfLIS(i, nums);
        }
        return Arrays.stream(cache).max().getAsInt();

    }

    public int lengthOfLIS(int i, int[] nums) {
        if (i < 0) return 0;
        if (cache[i] != 0) return cache[i];
        int res = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, 1 + lengthOfLIS(j, nums));
            }
        }
        cache[i] = res;
        return cache[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestIncreasingSubsequence extends Solution {
}