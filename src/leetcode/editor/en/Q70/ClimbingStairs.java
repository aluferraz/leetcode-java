package leetcode.editor.en.Q70;

import java.util.*;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
//
// 👍 15194 👎 445


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int twoBehind = 1;
        int oneBehind = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = twoBehind + oneBehind;
            twoBehind = oneBehind;
            oneBehind = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ClimbingStairs extends Solution {
}