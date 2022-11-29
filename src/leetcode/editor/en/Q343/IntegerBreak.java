package leetcode.editor.en.Q343;

import java.util.*;

//Given an integer n, break it into the sum of k positive integers, where k >= 2
//, and maximize the product of those integers. 
//
// Return the maximum product you can get. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 58 
// 
//
// 👍 3344 👎 350


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] cache;

    public int integerBreak(int n) {
        cache = new int[n + 1];
        return integerBreakHelper(n);
    }

    public int integerBreakHelper(int n) {
        if (cache[n] != 0) return cache[n];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int maxProd = 0;
        for (int i = 1; i <= Math.floorDiv(n, 2) + 1; i++) {
            int op1 = n - i;
            int op2 = i;
            int maxOp = integerBreakHelper(op1) * integerBreakHelper(op2);
            maxProd = Math.max(maxOp, maxProd);
            maxOp = integerBreakHelper(op1) * op2;
            maxProd = Math.max(maxOp, maxProd);
            maxOp = op1 * integerBreakHelper(op2);
            maxProd = Math.max(maxOp, maxProd);
            maxProd = Math.max((op1 * op2), maxProd);
        }
        cache[n] = maxProd;
        return maxProd;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class IntegerBreak extends Solution {
}