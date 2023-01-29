package leetcode.editor.en.Q352;

import javafx.util.Pair;

import java.util.*;

//Given a data stream input of non-negative integers a1, a2, ..., an, summarize 
//the numbers seen so far as a list of disjoint intervals. 
//
// Implement the SummaryRanges class: 
//
// 
// SummaryRanges() Initializes the object with an empty stream. 
// void addNum(int value) Adds the integer value to the stream. 
// int[][] getIntervals() Returns a summary of the integers in the stream 
//currently as a list of disjoint intervals [starti, endi]. The answer should be sorted 
//by starti. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", 
//"addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//Output
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//Explanation
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // return [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= value <= 10⁴ 
// At most 3 * 10⁴ calls will be made to addNum and getIntervals. 
// 
//
// 
// Follow up: What if there are lots of merges and the number of disjoint 
//intervals is small compared to the size of the data stream? 
//
// 👍 1278 👎 288


//leetcode submit region begin(Prohibit modification and deletion)

class SummaryRanges {

    Integer[] rangesFinish = new Integer[10001];
    Integer[] rangesStart = new Integer[10001];
    Integer[] ranges = new Integer[10001];
    int[][] temp = new int[10001][2];
    TreeSet<Integer> numbers = new TreeSet<>();
    Pair<Integer, int[][]> cache;

    public SummaryRanges() {
    }

    public void addNum(int value) {
        rangesFinish[value] = value;
        rangesStart[value] = value;
        int realStart = setStart(value);
        int realFinish = setFinish(value);
        ranges[realStart] = realFinish;
        numbers.add(value);
//        if (realStart == value || realFinish == value) {
        cache = null;
//        }

    }

    public int[][] getIntervals() {
        if (cache != null) return cache.getValue();
        int idx = 0;
        Integer start = numbers.first();
        while (start != null) {
            temp[idx] = new int[]{start, ranges[start]};
            start = numbers.higher(ranges[start]);
            idx++;
        }
        int[][] res = new int[idx][2];
        System.arraycopy(temp, 0, res, 0, idx);
        cache = new Pair<>(0, res);
        return res;
    }

    private int setFinish(int index) {

        if (index == rangesFinish.length || rangesFinish[index] == null) {
            return index - 1;
        }
        rangesFinish[index] = setFinish(rangesFinish[index] + 1);
        return rangesFinish[index];
    }

    private int setStart(int index) {
        if (index < 0 || rangesStart[index] == null) {
            return index + 1;
        }
        rangesStart[index] = setStart(rangesStart[index] - 1);
        return rangesStart[index];
    }


}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)


public class DataStreamAsDisjointIntervals extends SummaryRanges {
}