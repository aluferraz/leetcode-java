package leetcode.editor.en.Q435;

import java.util.*;

import javafx.util.Pair;

//Given an array of intervals intervals where intervals[i] = [starti, endi], 
//return the minimum number of intervals you need to remove to make the rest of the 
//intervals non-overlapping. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-
//overlapping.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals 
//non-overlapping.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're 
//already non-overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// 👍 5417 👎 153


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return -Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int left = 0;
        int overlaps = 0;
        while (left < intervals.length) {
            int right = left + 1;
            int minimumEnd = intervals[left][1];
            while (right < intervals.length && minimumEnd > intervals[right][0]) {
                overlaps++;
                minimumEnd = Math.min(minimumEnd, intervals[right][1]);
                right++;
            }
            left = right;
        }
        return overlaps;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NonOverlappingIntervals extends Solution {
}