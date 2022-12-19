package leetcode.editor.en.Q739;

import java.util.*;

//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait 
//after the iᵗʰ day to get a warmer temperature. If there is no future day for 
//which this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// 
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// 
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 👍 8780 👎 203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Single pass:
    public int[] dailyTemperatures(int[] temperatures) {
        int[] NGE = new int[temperatures.length];
//        Arrays.fill(NGE, 0);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            NGE[i] = 0;
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                NGE[prev] = i - prev;
            }
            stack.push(i);
        }

        return NGE;
    }

    //    public int[] dailyTemperatures(int[] temperatures) {
//        int[] NGE = nextGreaterElement(temperatures);
//        int[] result = new int[temperatures.length];
//        for (int i = 0; i < NGE.length; i++) {
//            if (NGE[i] == -1) result[i] = 0;
//            else result[i] = NGE[i] - i;
//        }
//        return result;
//    }
//
//    private int[] nextGreaterElement(int[] temperatures) {
//        int[] NGE = new int[temperatures.length];
//        Arrays.fill(NGE, -1);
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                NGE[stack.pop()] = i;
//            }
//            stack.push(i);
//        }
//
//        return NGE;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class DailyTemperatures extends Solution {
}