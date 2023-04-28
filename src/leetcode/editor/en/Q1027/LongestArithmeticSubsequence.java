package leetcode.editor.en.Q1027;

import java.util.*;

import javafx.util.Pair;

//Given an array nums of integers, return the length of the longest arithmetic 
//subsequence in nums. 
//
// Note that: 
//
// 
// A subsequence is an array that can be derived from another array by deleting 
//some or no elements without changing the order of the remaining elements. 
// A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (
//for 0 <= i < seq.length - 1). 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,6,9,12]
//Output: 4
//Explanation:  The whole array is an arithmetic sequence with steps of length =
// 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,4,7,2,10]
//Output: 3
//Explanation:  The longest arithmetic subsequence is [4,7,10].
// 
//
// Example 3: 
//
// 
//Input: nums = [20,1,15,3,10,5,8]
//Output: 4
//Explanation:  The longest arithmetic subsequence is [20,15,10,5].
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
//
// 👍 2796 👎 129


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestArithmeticSubsequence extends Solution {
}