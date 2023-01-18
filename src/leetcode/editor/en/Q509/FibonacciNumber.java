package leetcode.editor.en.Q509;

import java.util.*;

import javafx.util.Pair;

//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
//
// 👍 5944 👎 303


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int two_behind = 0;
        int one_behind = 1;
        int res = one_behind + two_behind;
        for (int i = 2; i <= n; i++) {
            res = one_behind + two_behind;
            two_behind = one_behind;
            one_behind = res;
        }

        return res;

    }

//    Integer[] cache;
//    public int fibRec(int n) {
//        cache = new Integer[n + 1];
//        return fibHelper(n);
//    }
//
//    int fibHelper(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        if (cache[n] != null) return cache[n];
//        cache[n] = fibHelper(n - 1) + fibHelper(n - 2);
//        return cache[n];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FibonacciNumber extends Solution {
}