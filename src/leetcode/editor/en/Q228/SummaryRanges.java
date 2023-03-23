package leetcode.editor.en.Q228;

import java.util.*;

import javafx.util.Pair;

//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// 👍 2551 👎 1363


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Deque<Integer> previous = new LinkedList<>();
        for (int num : nums) {
            if (!previous.isEmpty() && num != previous.peekLast() + 1) {
                if (previous.size() == 2) {
                    res.add(previous.pollFirst() + "->" + previous.pollLast());
                } else {
                    res.add(previous.pollLast() + "");
                }
            }
            if (previous.isEmpty()) {
                previous.add(num);
            } else {
                if (previous.size() == 2) previous.pollLast();
                previous.add(num);
            }
        }

        if (previous.size() == 2) {
            res.add(previous.pollFirst() + "->" + previous.pollLast());
        } else {
            res.add(previous.pollLast() + "");
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SummaryRanges extends Solution {
}