package leetcode.editor.en.Q57;

import java.util.*;

//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// 👍 6561 👎 468


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        LinkedList<int[]> res = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        boolean inserted = false;
        if (newStart <= intervals[i][0] && newEnd >= intervals[i][0]) {
            intervals[i][0] = newStart;
        }


        while (i < intervals.length) {
            int from = intervals[i][0];
            int to = intervals[i][1];
            if ((from <= newStart && to >= newStart) || (newStart <= from && newEnd >= from)) {
                int[] merged = new int[]{Math.min(from, newStart), Math.max(to, newEnd)};
                i++;
                while (i < intervals.length && newEnd >= intervals[i][0]) {
                    merged[1] = Math.max(intervals[i][1], newEnd);
                    i++;
                }
                res.add(merged);
                inserted = true;
            } else {
                if (newEnd < intervals[i][0] && !inserted) {
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(intervals[i]);
                i++;
            }
        }
        if (!inserted) {
            res.add(newInterval); // At the end
        }
        int[][] result = new int[res.size()][2];
        i = 0;
        while (!res.isEmpty()) {
            result[i] = res.pollFirst();
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class InsertInterval extends Solution {
}