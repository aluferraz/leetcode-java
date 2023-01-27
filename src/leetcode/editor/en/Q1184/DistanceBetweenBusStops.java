package leetcode.editor.en.Q1184;

import java.util.*;

import javafx.util.Pair;

//A bus has n stops numbered from 0 to n - 1 that form a circle. We know the 
//distance between all pairs of neighboring stops where distance[i] is the distance 
//between the stops number i and (i + 1) % n. 
//
// The bus goes along both directions i.e. clockwise and counterclockwise. 
//
// Return the shortest distance between the given start and destination stops. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: distance = [1,2,3,4], start = 0, destination = 1
//Output: 1
//Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1. 
//
// 
//
// Example 2: 
//
// 
//
// 
//Input: distance = [1,2,3,4], start = 0, destination = 2
//Output: 3
//Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
// 
//
// 
//
// Example 3: 
//
// 
//
// 
//Input: distance = [1,2,3,4], start = 0, destination = 3
//Output: 4
//Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^4 
// distance.length == n 
// 0 <= start, destination < n 
// 0 <= distance[i] <= 10^4 
// 
//
// 👍 643 👎 65


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        int resf = 0;
        int pos = start;
        while (pos != destination) {
            if (pos == destination) {
                break;
            }
            resf += distance[pos];
            pos = (pos + 1) % distance.length;
        }

        pos = start;
        int resb = 0;
        while (pos != destination) {
            if (pos == destination) {
                break;
            }
            pos = (pos - 1);
            if (pos == -1) {
                pos = distance.length - 1;
            }
            resb += distance[pos];

        }
        return Math.min(resf, resb);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class DistanceBetweenBusStops extends Solution {
}