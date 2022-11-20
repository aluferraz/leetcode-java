package leetcode.editor.en.Q263;

import java.util.*;

//An ugly number is a positive integer whose prime factors are limited to 2, 3, 
//and 5. 
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 👍 2168 👎 1311


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://www.geeksforgeeks.org/distinct-prime-factors-of-an-array/
    public boolean isUgly(int n) {
        if(n == Integer.MIN_VALUE) return false;
        n = Math.abs(n);
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for (int i = 0; i < n + 1; i++)
            prime.add(0);
        int p = 2;
        while (p * p <= n) {
            if (prime.get(p) == 0) {
                for (int i = 2 * p; i < n + 1; i += p)
                    prime.set(i, 1);
            }
            p += 1;
        }

        for (int i = 5; i < n; i++) {
            if (prime.get(i) == 0 && i > 5 && (n % i == 0))
                return false;
            //allPrimes.add(i);
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class UglyNumber extends Solution {
}