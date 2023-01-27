package leetcode.editor.en.Q1137;

import java.util.*;

import javafx.util.Pair;

//The Tribonacci sequence Tn is defined as follows: 
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 
//
// Given n, return the value of Tn. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// Example 2: 
//
// 
//Input: n = 25
//Output: 1389537
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 37 
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1. 
// 
//
// 👍 2577 👎 135


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Integer[] cache;

    public int tribonacci(int n) {
        cache = new Integer[n + 1];

        cache[0] = 0;
        if (n > 0) {
            cache[1] = 1;
            if (n > 1) {
                cache[2] = 1;
            }
        }
        return tribonacciHelper(n);
    }


    private int tribonacciHelper(int n) {
        if (cache[n] != null) return cache[n];
        cache[n] = tribonacciHelper(n - 1) + tribonacciHelper(n - 2) + tribonacciHelper(n - 3);
        return cache[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NThTribonacciNumber extends Solution {
}