package leetcode.editor.en.Q759;

import java.util.*;

import javafx.util.Pair;

//We are given a list schedule of employees, which represents the working time 
//for each employee. 
//
// Each employee has a list of non-overlapping Intervals, and these intervals 
//are in sorted order. 
//
// Return the list of finite intervals representing common, positive-length 
//free time for all employees, also in sorted order. 
//
// (Even though we are representing Intervals in the form [x, y], the objects 
//inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, 
//schedule[0][0].end = 2, and schedule[0][0][0] is not defined). Also, we 
//wouldn't include intervals like [5, 5] in our answer, as they have zero length. 
//
// 
// Example 1: 
//
// 
//Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//Output: [[3,4]]
//Explanation: There are a total of three employees, and all common
//free time intervals would be [-inf, 1], [3, 4], [10, inf].
//We discard any intervals that contain inf as they aren't finite.
// 
//
// Example 2: 
//
// 
//Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//Output: [[5,6],[7,9]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= schedule.length , schedule[i].length <= 50 
// 0 <= schedule[i].start < schedule[i].end <= 10^8 
// 
//
// 👍 1719 👎 119
class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    private static final int START = -1;
    private static final int END = 1;

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        ArrayList<int[]> timeline = new ArrayList<>();

        for (List<Interval> workerSchedule : schedule) {
            for (Interval interval : workerSchedule) {
                timeline.add(new int[]{interval.start, START});
                timeline.add(new int[]{interval.end, END});
            }
        }
        Collections.sort(timeline, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int state = 0;
        Integer previousEnd = null;
        ArrayList<Interval> res = new ArrayList<>();
        for (int[] event : timeline) {
            int eventType = event[1];
            if (state == 0 && eventType == START && previousEnd != null) {
                int start = previousEnd;
                int end = event[0];
                res.add(new Interval(start, end));
            }
            state += eventType;
            if (eventType == END) {
                previousEnd = event[0];
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class EmployeeFreeTime extends Solution {
}