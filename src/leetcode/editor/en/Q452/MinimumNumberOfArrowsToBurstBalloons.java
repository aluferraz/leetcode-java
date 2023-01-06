package leetcode.editor.en.Q452;

import java.util.*;

//There are some spherical balloons taped onto a flat wall that represents the 
//XY-plane. The balloons are represented as a 2D integer array points where points[
//i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches 
//between xstart and xend. You do not know the exact y-coordinates of the balloons. 
//
// Arrows can be shot up directly vertically (in the positive y-direction) from 
//different points along the x-axis. A balloon with xstart and xend is burst by 
//an arrow shot at x if xstart <= x <= xend. There is no limit to the number of 
//arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any 
//balloons in its path. 
//
// Given the array points, return the minimum number of arrows that must be 
//shot to burst all balloons. 
//
// 
// Example 1: 
//
// 
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
// 
//
// Example 2: 
//
// 
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 
//arrows.
// 
//
// Example 3: 
//
// 
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 10⁵ 
// points[i].length == 2 
// -2³¹ <= xstart < xend <= 2³¹ - 1 
// 
//
// 👍 4695 👎 128


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int START = 0;
    private static final int END = 1;


    //This approach is more widely usable:
    public int findMinArrowShotsCorrect(int[][] points) {
        //https://www.youtube.com/watch?v=0gnV-rq-FZ8
        int[][] events = new int[points.length * 2][3];
        int eventsIdx = 0;
        for (int i = 0; i < points.length; i++) {
            events[eventsIdx][0] = points[i][0];
            events[eventsIdx][1] = START;
            events[eventsIdx][2] = i;
            eventsIdx++;
            events[eventsIdx][0] = points[i][1];
            events[eventsIdx][1] = END;
            events[eventsIdx][2] = i;
            eventsIdx++;
        }
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        Stack<Integer> intersecting = new Stack<>();
        boolean[] bursted = new boolean[points.length];
        int shoots = 0;

        for (int[] event : events) {
            int idx = event[2];
            if (event[1] == START) {
                intersecting.add(idx);
            } else {
                //event[1] == END
                if (!bursted[idx]) {
                    while (intersecting.size() > 0) {
                        bursted[intersecting.pop()] = true;
                    }
                    shoots++;
                }


            }
        }
        return shoots;

    }

    //This is problem-specific:
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int x_end = points[0][1];
        int shoots = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > x_end) {
                shoots++;
                x_end = points[i][1];
            }
        }
        return shoots;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumNumberOfArrowsToBurstBalloons extends Solution {
}