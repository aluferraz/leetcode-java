package leetcode.editor.en.Q1232;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;

//You are given an array coordinates, coordinates[i] = [x, y], where [x, y] 
//represents the coordinate of a point. Check if these points make a straight line in 
//the XY plane. 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//Output: true
// 
//
// Example 2: 
//
// 
//
// 
//Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates contains no duplicate point. 
// 
//
// 👍 1202 👎 175


//leetcode submit region begin(Prohibit modification and deletion)
import java.math.BigInteger;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Pair<Integer, Integer> prevSlope = null;

        for (int i = 1; i < coordinates.length; i++) {
            Pair<Integer, Integer> slope = slope_coprime(
                    coordinates[i - 1][0],
                    coordinates[i - 1][1],
                    coordinates[i][0],
                    coordinates[i][1]
            );
            if (prevSlope == null) {
                prevSlope = slope;
            }
            if (!slope.equals(prevSlope)) return false;
        }
        return true;
    }

    private Pair<Integer, Integer> slope_coprime(int x1, int y1, int x2, int y2) {
        int deltaX = x1 - x2, deltaY = y1 - y2;
        if (deltaX == 0)
            return new Pair<>(0, 0);
        else if (deltaY == 0)
            return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        else if (deltaX < 0) {
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        int gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();

        return new Pair<>(deltaX / gcd, deltaY / gcd);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class CheckIfItIsAStraightLine extends Solution {
}