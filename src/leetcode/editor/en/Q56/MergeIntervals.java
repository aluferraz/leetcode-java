package leetcode.editor.en.Q56;

import java.util.*;

import javafx.util.Pair;

//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 👍 17718 👎 615


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int START = -1;
    private static final int END = 1;

    public int[][] merge(int[][] intervals) {
        int[][] sweep = new int[intervals.length * 2][2];
        int sIdx = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            sweep[sIdx] = new int[]{interval[0], START};
            sIdx++;
            sweep[sIdx] = new int[]{interval[1], END};
            sIdx++;
        }
        Arrays.sort(sweep, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int current = 0;

        LinkedList<int[]> merged = new LinkedList<>();
        int start = Integer.MAX_VALUE;

        for (int[] event : sweep) {
            current += event[1];
            if (current == 0) {
                merged.add(new int[]{start, event[0]});
                start = Integer.MAX_VALUE;
            } else {
                start = Math.min(start, event[0]);
            }
        }

        int[][] mergedArr = new int[merged.size()][2];
        int i = 0;
        while (!merged.isEmpty()) {
            mergedArr[i] = merged.pollFirst();
            i++;
        }
        return mergedArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MergeIntervals extends Solution {
}