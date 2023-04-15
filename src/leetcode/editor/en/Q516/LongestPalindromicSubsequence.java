package leetcode.editor.en.Q516;

import java.util.*;

import javafx.util.Pair;

//Given a string s, find the longest palindromic subsequence's length in s. 
//
// A subsequence is a sequence that can be derived from another sequence by 
//deleting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
//
// 👍 7563 👎 282


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;

    public int longestPalindromeSubseq(String s) {
        cache = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(0, s.length() - 1, s);
    }

    public int longestPalindromeSubseq(
            int left,
            int right,
            String s) {
        if (left > right) return 0;
        if (left == right) return 1;

        if (cache[left][right] != null) {
            return cache[left][right];
        }

        int best = 0;

        if (s.charAt(left) == s.charAt(right)) {
            best = Math.max(best, (longestPalindromeSubseq(left + 1, right - 1, s) + 2));
        }
        best = Math.max(best, longestPalindromeSubseq(left + 1, right, s));
        best = Math.max(best, longestPalindromeSubseq(left, right - 1, s));
        cache[left][right] = best;
        return best;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestPalindromicSubsequence extends Solution {
}