package leetcode.editor.en.Q84;

import java.util.*;

import javafx.util.Pair;

//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
// 
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 👍 13577 👎 192


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {

        int[] reversed = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            reversed[heights.length - 1 - i] = heights[i];
        }

       return getMaxHeight(heights);
//        int RTL = getMaxHeight(reversed);
//        return Math.max(LTR, RTL);

    }

    private int getMaxHeight(int[] heights) {
        int[] PLE = previousLesserElement(heights);
        int[] NLE = nextLesserElement(heights);
        int[] mins = new int[heights.length];
      //  int[] res = new int[heights.length];res[0] = heights[0];
        mins[0] = heights[0];
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            if (i > 0) {
                mins[i] = Math.min(mins[i - 1], heights[i]);
            }
            int oneBar = heights[i];
            int useMin = mins[i] * (i + 1);

            int usePLE = heights[i] * (i - PLE[i]);
            int useNLE = heights[i] * ( NLE[i] - i );
            int useRange = heights[i] * (NLE[i] - 1 - PLE[i]);


            best = Math.max(best, oneBar);
            best = Math.max(best, useMin);
            best = Math.max(best, usePLE);
            best = Math.max(best, useNLE);
            best = Math.max(best, useRange);
          //  res[i] = best;
        }
        return best;
    }

    private int[] previousLesserElement(int[] arr) {
        int[] PLE = new int[arr.length];
        Arrays.fill(PLE, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                PLE[stack.pop()] = i;
            }
            stack.push(i);
        }
        return PLE;
    }

    private int[] nextLesserElement(int[] arr) {
        int[] NLE = new int[arr.length];
        Arrays.fill(NLE, arr.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                NLE[stack.pop()] = i;
            }
            stack.push(i);
        }
        return NLE;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class LargestRectangleInHistogram extends Solution {
}