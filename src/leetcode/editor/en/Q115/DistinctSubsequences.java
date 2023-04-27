package leetcode.editor.en.Q115;

import java.util.*;

import javafx.util.Pair;

//Given two strings s and t, return the number of distinct subsequences of s 
//which equals t. 
//
// The test cases are generated so that the answer fits on a 32-bit signed 
//integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from s.
//rabbbit
//rabbbit
//rabbbit
// 
//
// Example 2: 
//
// 
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from s.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 1000 
// s and t consist of English letters. 
// 
//
// 👍 5254 👎 200


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public int numDistinct(String s, String t) {
        int ans = 0;
        cache = new Integer[s.length() + 1][t.length() + 1];
        ans += numDistinct(0, 0, s, t);

        return ans;
    }

    public int numDistinct(int i, int j, String s, String t) {
        int ans = 0;
        if (j == t.length()) {
            return ++ans;
        }
        if (i == s.length()) {
            return ans;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);

        if (c1 == c2) {
            ans += numDistinct(i + 1, j + 1, s, t);
        }
        ans += numDistinct(i + 1, j, s, t);

        cache[i][j] = ans;
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DistinctSubsequences extends Solution {
}