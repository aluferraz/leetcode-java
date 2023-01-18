package leetcode.editor.en.Q169;

import java.util.*;

import javafx.util.Pair;

//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// 👍 13371 👎 423


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // My approach:
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> counter = new HashMap<>();
//        int minCount = Math.floorDiv(nums.length, 2);
//        for (int num : nums) {
//            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
//            if (counter.get(num) > minCount) {
//                return num;
//            }
//        }
//
//        return 0;
//    }
    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MajorityElement extends Solution {
}