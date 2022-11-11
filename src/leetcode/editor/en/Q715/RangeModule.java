package leetcode.editor.en.Q715;


//A Range Module is a module that tracks ranges of numbers. Design a data 
//structure to track the ranges represented as half-open intervals and query about them.
// 
//
// A half-open interval [left, right) denotes all the real numbers x where left 
//<= x < right. 
//
// Implement the RangeModule class: 
//
// 
// RangeModule() Initializes the object of the data structure. 
// void addRange(int left, int right) Adds the half-open interval [left, right),
// tracking every real number in that interval. Adding an interval that partially 
//overlaps with currently tracked numbers should add any numbers in the interval [
//left, right) that are not already tracked. 
// boolean queryRange(int left, int right) Returns true if every real number in 
//the interval [left, right) is currently being tracked, and false otherwise. 
// void removeRange(int left, int right) Stops tracking every real number 
//currently being tracked in the half-open interval [left, right). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", 
//"queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//Output
//[null, null, null, true, false, true]
//
//Explanation
//RangeModule rangeModule = new RangeModule();
//rangeModule.addRange(10, 20);
//rangeModule.removeRange(14, 16);
//rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is 
//being tracked)
//rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17
// in [13, 15) are not being tracked)
//rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is 
//still being tracked, despite the remove operation)
// 
//
// 
// Constraints: 
//
// 
// 1 <= left < right <= 10⁹ 
// At most 10⁴ calls will be made to addRange, queryRange, and removeRange. 
// 
//
// 👍 1158 👎 93


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.NavigableMap;

public class RangeModule {
    NavigableMap<Integer, Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();

    }

    public void addRange(int left, int right) {
        Integer leftBoundary = ranges.floorKey(left);
        Integer rightBoundary = ranges.floorKey(right);
        if (leftBoundary == null && rightBoundary == null) {
            ranges.put(left, right);
        } else if (leftBoundary != null && ranges.get(leftBoundary) >= left) {
            ranges.put(leftBoundary, Math.max(ranges.get(rightBoundary), Math.max(right, ranges.get(leftBoundary))));
        } else {
            ranges.put(left, Math.max(right, ranges.get(rightBoundary)));
        }
        NavigableMap<Integer, Integer> subMap = ranges.subMap(left, false, right, true);
        Set<Integer> set = new HashSet<Integer>(subMap.keySet());
        ranges.keySet().removeAll(set);

    }

    public boolean queryRange(int left, int right) {
        Integer leftBoundary = ranges.floorKey(left);
        if (leftBoundary == null) return false;
        int rightBoundary = ranges.get(leftBoundary);
        return rightBoundary >= right;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = ranges.floorKey(left);
        Integer end = ranges.floorKey(right);
        if (end != null && ranges.get(end) > right) {
            ranges.put(right, ranges.get(end));
        }
        if (start != null && ranges.get(start) > left) {
            ranges.put(start, left);
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = ranges.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        ranges.keySet().removeAll(set);
    }

}
