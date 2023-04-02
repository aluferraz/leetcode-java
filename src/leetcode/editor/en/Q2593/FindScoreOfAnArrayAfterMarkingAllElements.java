package leetcode.editor.en.Q2593;

import java.util.*;

import javafx.util.Pair;

//You are given an array nums consisting of positive integers. 
//
// Starting with score = 0, apply the following algorithm: 
//
// 
// Choose the smallest integer of the array that is not marked. If there is a 
//tie, choose the one with the smallest index. 
// Add the value of the chosen integer to score. 
// Mark the chosen element and its two adjacent elements if they exist. 
// Repeat until all the array elements are marked. 
// 
//
// Return the score you get after applying the above algorithm. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,1,3,4,5,2]
//Output: 7
//Explanation: We mark the elements as follows:
//- 1 is the smallest unmarked element, so we mark it and its two adjacent 
//elements: [2,1,3,4,5,2].
//- 2 is the smallest unmarked element, so we mark it and its left adjacent 
//element: [2,1,3,4,5,2].
//- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
//Our score is 1 + 2 + 4 = 7.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,5,1,3,2]
//Output: 5
//Explanation: We mark the elements as follows:
//- 1 is the smallest unmarked element, so we mark it and its two adjacent 
//elements: [2,3,5,1,3,2].
//- 2 is the smallest unmarked element, since there are two of them, we choose 
//the left-most one, so we mark the one at index 0 and its right adjacent element: 
//[2,3,5,1,3,2].
//- 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
//Our score is 1 + 2 + 2 = 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// 👍 213 👎 2


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        HashSet<Integer> marked = new HashSet<>();
        long res = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int index = next[1];
            if (marked.contains(index)) continue;
            res += next[0];
            marked.add(index);
            marked.add(index + 1);
            marked.add(index - 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindScoreOfAnArrayAfterMarkingAllElements extends Solution {
}