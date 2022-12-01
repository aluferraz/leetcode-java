package leetcode.editor.en.Q201;

import java.util.*;

//Given two integers left and right that represent the range [left, right], 
//return the bitwise AND of all numbers in this range, inclusive. 
//
// 
// Example 1: 
//
// 
//Input: left = 5, right = 7
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: left = 0, right = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: left = 1, right = 2147483647
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// 👍 2582 👎 192


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BitwiseAndOfNumbersRange extends Solution {
}