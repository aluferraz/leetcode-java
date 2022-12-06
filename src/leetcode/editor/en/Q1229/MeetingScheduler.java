package leetcode.editor.en.Q1229;

import java.util.*;

//Given the availability time slots arrays slots1 and slots2 of two people and 
//a meeting duration duration, return the earliest time slot that works for both 
//of them and is of duration duration. 
//
// If there is no common time slot that satisfies the requirements, return an 
//empty array. 
//
// The format of a time slot is an array of two elements [start, end] 
//representing an inclusive time range from start to end. 
//
// It is guaranteed that no two availability slots of the same person intersect 
//with each other. That is, for any two time slots [start1, end1] and [start2, 
//end2] of the same person, either start1 > end2 or start2 > end1. 
//
// 
// Example 1: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 8
//Output: [60,68]
// 
//
// Example 2: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 12
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= slots1.length, slots2.length <= 10⁴ 
// slots1[i].length, slots2[i].length == 2 
// slots1[i][0] < slots1[i][1] 
// slots2[i][0] < slots2[i][1] 
// 0 <= slots1[i][j], slots2[i][j] <= 10⁹ 
// 1 <= duration <= 10⁶ 
// 
//
// 👍 797 👎 30


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> minAvailableDuration(long[][] slots1, long[][] slots2, Long duration) {
        if (slots1.length == 0 || slots2.length == 0) return new ArrayList<>();
        Arrays.sort(slots1, ((o1, o2) -> {
            if (o1[0] == o2[0]) return Long.compare(o1[1], o2[1]);
            return Long.compare(o1[0], o2[0]);
        }));
        Arrays.sort(slots2, ((o1, o2) -> {
            if (o1[0] == o2[0]) return Long.compare(o1[1], o2[1]);
            return Long.compare(o1[0], o2[0]);
        }));

        if (slots1[0][0] < slots2[0][0]) return findSpot(slots1, slots2, duration);
        return findSpot(slots2, slots1, duration);


    }

    private List<Integer> findSpot(long[][] slots1, long[][] slots2, Long duration) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < slots1.length && j < slots2.length) {
            if (slots1[i][1] - slots1[i][0] >= duration) {
                while (j < slots2.length && (
                        slots2[j][0] > slots1[i][1] ||
                                slots2[j][1] - slots2[j][0] < duration)) {
                    j++;
                }
                if (j >= slots2.length) break;
                Long start = Math.max(slots2[j][0], slots1[i][0]);
                Long end = Math.min(slots1[i][1], slots2[j][0]);
                if (slots2[j][0] <= slots1[i][1] && end - start >= duration) {
                    result.add(start.intValue());
                    Long finish = (start + duration);
                    result.add(finish.intValue());
                    return result;
                }
            }
            i++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MeetingScheduler extends Solution {
}