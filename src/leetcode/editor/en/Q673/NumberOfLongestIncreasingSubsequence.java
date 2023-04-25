package leetcode.editor.en.Q673;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return the number of longest increasing 
//subsequences. 
//
// Notice that the sequence has to be strictly increasing. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 
//3, 5, 7].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2]
//Output: 5
//Explanation: The length of the longest increasing subsequence is 1, and there 
//are 5 increasing subsequences of length 1, so output 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
//
// 👍 4731 👎 203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 0;

        // the longest increasing subsequence that ends at i
        int[] len = new int[n];

        // the number of the longest increasing subsequence that ends at i
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {

                // if combining with i makes an increasing subsequence
                if (nums[j] < nums[i]) {

                    // if combining with i makes a longer increasing subsequence
                    if (len[j]+1 > len[i]) {
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                    // if combining with i makes another longest increasing subsequence
                    else if (len[j]+1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            // if the current nums[i] is the minimum value so far
            if (len[i] == 0) {
                len[i] = 1;
                cnt[i] = 1;
            }

            // update the longest length
            max = Math.max(max, len[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == max) {
                res += cnt[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfLongestIncreasingSubsequence extends Solution {
}