package leetcode.editor.en.Q10;

import com.sun.security.jgss.InquireType;

import java.util.*;

//Given an input string s and a pattern p, implement regular expression 
//matching with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
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
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a 
//previous valid character to match. 
// 
//
// 👍 9708 👎 1569


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] matches = new int[27];
    Boolean[][] cache;


    public boolean isMatch(String s, String p) {

        cache = new Boolean[s.length()][p.length()];
        return isMatchHelper(s, p, 0, 0);
    }

    public boolean isMatchHelper(String s, String p, int sI, int pI) {
        if (sI < s.length() && pI < p.length() && cache[sI][pI] != null) return cache[sI][pI];
        if (sI == s.length() && pI == p.length()) return true;
        if (sI == s.length()) {
            if (pI + 1 < p.length() && p.charAt(pI + 1) == '*') {
                return isMatchHelper(s, p, sI, pI + 2);
            } else {
//                cache[sI][pI] = false;
                return false;
            }
        }
        if (p.length() == pI) {
//            cache[sI][pI] = false;
            return false;
        }

        char cS = s.charAt(sI);
        char pS = p.charAt(pI);
        if (pS == '*') {
            cache[sI][pI] = isMatchHelper(s, p, sI, pI + 1); // Let's take it
            return cache[sI][pI];
        }
        boolean found = false;
        if (pI + 1 < p.length() && p.charAt(pI + 1) == '*') {
            if (cS == pS || pS == '.') {
                found = isMatchHelper(s, p, sI + 1, pI); // Let's take it
            }
            found = found || isMatchHelper(s, p, sI, pI + 2);// Can't take it anymore

        }
        if (cS == pS || pS == '.') {
            found = found || isMatchHelper(s, p, sI + 1, pI + 1); // Let's take it
        }
        cache[sI][pI] = found;
        return found;


    }


    // "ac", ".*b"
    // ".**"
    // ".*."
    // "aa", "a"
    //"aa", "aa*"


}
//leetcode submit region end(Prohibit modification and deletion)


public class RegularExpressionMatching extends Solution {
}