package leetcode.editor.en.Q2466;

import java.util.*;

import javafx.util.Pair;

//Given the integers zero, one, low, and high, we can construct a string by 
//starting with an empty string, and then at each step perform either of the 
//following: 
//
// 
// Append the character '0' zero times. 
// Append the character '1' one times. 
// 
//
// This can be performed any number of times. 
//
// A good string is a string constructed by the above process having a length 
//between low and high (inclusive). 
//
// Return the number of different good strings that can be constructed 
//satisfying these properties. Since the answer can be large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: low = 3, high = 3, zero = 1, one = 1
//Output: 8
//Explanation: 
//One possible valid good string is "011". 
//It can be constructed as follows: "" -> "0" -> "01" -> "011". 
//All binary strings from "000" to "111" are good strings in this example.
// 
//
// Example 2: 
//
// 
//Input: low = 2, high = 3, zero = 1, one = 2
//Output: 5
//Explanation: The good strings are "00", "11", "000", "110", and "011".
// 
//
// 
// Constraints: 
//
// 
// 1 <= low <= high <= 10⁵ 
// 1 <= zero, one <= low 
// 
//
// 👍 352 👎 22


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Long[] cache;
    long MOD = 1000000007L;

    public int countGoodStrings(int low, int high, int zero, int one) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < zero; i++) {
            zeros.append('0');
        }
        StringBuilder ones = new StringBuilder();
        for (int i = 0; i < one; i++) {
            ones.append('1');
        }
        cache = new Long[ high + 1];
        return countGoodStrings(new StringBuilder(), low, high, zeros.toString(), ones.toString()).intValue();
    }


    public Long countGoodStrings(StringBuilder sb, int low, int high, String zero, String one) {
        if (sb.length() == high) {
            return 1L;
        }
        if (cache[sb.length()] != null) {
            return cache[sb.length()];
        }
        long ans = 0;
        if (sb.length() >= low && sb.length() <= high) {
            ans = (ans + 1) % MOD;
        }
        if (sb.length() + zero.length() <= high) {
            sb.append(zero);
            ans = (ans + countGoodStrings(sb, low, high, zero, one)) % MOD;
            sb.delete(sb.length() - zero.length(), sb.length());
        }
        if (sb.length() + one.length() <= high) {
            sb.append(one);
            ans = (ans + countGoodStrings(sb, low, high, zero, one)) % MOD;
            sb.delete(sb.length() - one.length(), sb.length());
        }
        ans %= MOD;
        cache[sb.length()] = ans;
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class CountWaysToBuildGoodStrings extends Solution {
}