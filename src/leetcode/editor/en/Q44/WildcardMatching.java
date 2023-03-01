package leetcode.editor.en.Q44;

import java.util.*;

import javafx.util.Pair;

//Given an input string (s) and a pattern (p), implement wildcard pattern 
//matching with support for '?' and '*' where: 
//
// 
// '?' Matches any single character. 
// '*' Matches any sequence of characters (including the empty sequence). 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not 
//match 'b'.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length, p.length <= 2000 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '?' or '*'. 
// 
//
// 👍 6525 👎 276


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = "" == ""; //Base case
        boolean patternForEmpty = true;
        //The only way for an empty string match a pattern is if the pattern contains only '*'
        for (int i = 1; i <= p.length(); i++) {
            if (patternForEmpty && p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
                patternForEmpty = false;
            }
        }

        //Compare anything to the pattern "" will be false, except for the base-case [0][0]
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class WildcardMatching extends Solution {
}