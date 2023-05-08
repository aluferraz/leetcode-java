package leetcode.editor.en.Q91;

import java.util.*;

//A message containing letters from A-Z can be encoded into numbers using the 
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
//
// 👍 9170 👎 4136


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer cache[];

    public int numDecodings(String s) {
        if (s.charAt(0) == '0'
                || s.contains("00")
                || s.contains("30")
                || s.contains("40")
                || s.contains("50")
                || s.contains("60")
                || s.contains("70")
                || s.contains("80")
                || s.contains("90")
        ) return 0;

        cache = new Integer[s.length()];
        return Math.max(decodeWays(s.length() - 1, s), 0);
    }

    private int decodeWays(int i, String s) {
        if (i < 0) {
            return 1;
        }
        if (cache[i] != null) return cache[i];

        int ans = 0;
        int cur = Character.getNumericValue(s.charAt(i));
        if (cur == 0) {
            cache[i] = decodeWays(i - 2, s);
            return cache[i];
        }
        ans += decodeWays(i - 1, s);
        if (i > 0) {
            int prev = Character.getNumericValue(s.charAt(i - 1));
            int comp = (prev * 10) + cur;
            if (comp >= 10 && comp <= 26) {
                ans += decodeWays(i - 2, s);
            }
        }
        cache[i] = ans;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DecodeWays extends Solution {
}