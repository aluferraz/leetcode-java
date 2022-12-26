package leetcode.editor.en.Q2389;

import java.util.*;

//You are given an integer array nums of length n, and an integer array queries 
//of length m. 
//
// Return an array answer of length m where answer[i] is the maximum size of a 
//subsequence that you can take from nums such that the sum of its elements is 
//less than or equal to queries[i]. 
//
// A subsequence is an array that can be derived from another array by deleting 
//some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,5,2,1], queries = [3,10,21]
//Output: [2,3,4]
//Explanation: We answer the queries as follows:
//- The subsequence [2,1] has a sum less than or equal to 3. It can be proven 
//that 2 is the maximum size of such a subsequence, so answer[0] = 2.
//- The subsequence [4,5,1] has a sum less than or equal to 10. It can be 
//proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
//- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be 
//proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,4,5], queries = [1]
//Output: [0]
//Explanation: The empty subsequence is the only subsequence that has a sum 
//less than or equal to 1, so answer[0] = 0. 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// 👍 1022 👎 96


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int n = nums.length;


        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int left = 0;

            if (nums[n - 1] <= target) {
                result[i] = n;
                continue;
            }

            while (left < nums.length && nums[left] <= target) {
                left++;
            }
            result[i] = left;
        }

        return result;

    }


//    class Solution {
//        public int[] answerQueries(int[] nums, int[] queries) {
//            Arrays.sort(nums);
//            int[] presum = new int[nums.length];
//            int[] result = new int[queries.length];
//            presum[0] = nums[0];
//            for (int i = 1; i < presum.length; i++) {
//                presum[i] = nums[i] + presum[i - 1];
//            }
//
//            for (int i = 0; i < queries.length; i++) {
//                int target = queries[i];
//                int startingIndex = Arrays.binarySearch(presum, target);
//                int count = 0;
//                if (startingIndex < 0) {
//                    startingIndex = Math.abs(startingIndex);
//                    startingIndex = Math.min(startingIndex, presum.length - 1);
//                    for (int j = startingIndex; j >= 0; j--) {
//                        if (presum[j] <= target) {
//                            count = j + 1;
//                            break;
//                        }
//                    }
//                } else {
//                    startingIndex = Arrays.binarySearch(presum, target + 1);
//                    count = Math.abs(startingIndex);
//                    count--;
//                }
//                result[i] = count;
//            }
//
//            return result;
//
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestSubsequenceWithLimitedSum extends Solution {
}