package leetcode.editor.en.Q279;

import java.util.*;

//Given an integer n, return the least number of perfect square numbers that 
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// 👍 8166 👎 354


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] cache;

    public int numSquares(int n) {
        int[] squares = getSquares(n);
        cache = new int[n + 1];
        return minAdd(squares, n);

    }

    private int minAdd(int[] squares, int target) {
        if (cache[target] != 0) return cache[target];
        int nextIdx = Arrays.binarySearch(squares, target);
        if (nextIdx >= 0) {
            //We found the target
            cache[target] = 1;
            return 1;
        }
        int result = Integer.MAX_VALUE;
        int closestNumberIdx = Math.abs(nextIdx) - 2; // https://www.freecodecamp.org/news/how-to-use-arrays-binarysearch-in-java/
        for (int i = closestNumberIdx; i >= 0; i--) {
            int newTarget = target - squares[i];
            int newResult = 1 + minAdd(squares, newTarget);
            result = Math.min(newResult, result);
        }
        cache[target] = result;
        return result;
    }


    private int[] getSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int nextSquare = i * i;
            if (nextSquare > n) break;
            squares.add(i * i);
        }

        int[] squaresArray = new int[squares.size()];
        int i = 0;
        for (int square : squares) {
            squaresArray[i] = square;
            i++;
        }
        return squaresArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PerfectSquares extends Solution {
}