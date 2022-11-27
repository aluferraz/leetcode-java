package leetcode.editor.en.Q300;

import leetcode.editor.en.Q1926.NearestExitFromEntranceInMaze;

import java.util.*;

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
// 👍 15758 👎 289


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<String> treeSet = new TreeSet<>();
        int longest = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            String insertionEl = nums[i] + "-" + i;
            treeSet.add(insertionEl);
            if (treeSet.last().equals(insertionEl)) continue;
            int subSequenceSize = treeSet.subSet((nums[i] + 1 + "-" + i), true, treeSet.last(), true).size();
            longest = Math.max(longest, subSequenceSize);
        }
        return longest;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestIncreasingSubsequence extends Solution {
}