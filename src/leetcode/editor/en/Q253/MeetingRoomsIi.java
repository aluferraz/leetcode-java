package leetcode.editor.en.Q253;

import java.util.*;

import javafx.util.Pair;

//Given an array of meeting time intervals intervals where intervals[i] = [
//starti, endi], return the minimum number of conference rooms required. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2
// 
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
//
// 👍 6391 👎 136


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int START = 1;
    private static final int END = -1;

    public int minMeetingRooms(int[][] intervals) {
        int[][] timeline = new int[intervals.length * 2][2];
        int i = 0;
        for (int[] interval : intervals) {
            timeline[i] = new int[]{interval[0], START};
            i++;
            timeline[i] = new int[]{interval[1], END};
            i++;
        }
        Arrays.sort(timeline, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int rooms = 0;
        int res = 0;

        for (int[] event : timeline) {
            rooms += event[1];
            res = Math.max(res, rooms);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MeetingRoomsIi extends Solution {
}