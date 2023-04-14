package leetcode.editor.en.Q459;

import java.util.*;

import javafx.util.Pair;

//Given a string s, check if it can be constructed by taking a substring of it 
//and appending multiple copies of the substring together. 
//
// 
// Example 1: 
//
// 
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
// 
//
// Example 2: 
//
// 
//Input: s = "aba"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" 
//twice.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// 👍 4305 👎 387


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Boolean[] cache;

    public boolean repeatedSubstringPattern(String s) {
        cache = new Boolean[s.length()];
        return repeatedSubstringPatternHelper(1, s);
    }

    public boolean repeatedSubstringPatternHelper(int start, String s) {
        if (start == s.length()) return false;
        if (cache[start] != null) return cache[start];
        int end = Math.min(start * 2, s.length());
        String left = s.substring(0, start);
        String right = s.substring(start, end);
        StringBuilder rightBuilder = new StringBuilder();
        while (rightBuilder.length() < left.length()) {
            rightBuilder.append(right);
        }
        right = rightBuilder.toString();
        if (left.equals(right)) {
            if (end == s.length()) return true;
            if (repeatedSubstringPatternHelper(end, s)) {
                return true;
            }
        }
        cache[start] = repeatedSubstringPatternHelper(start + 1, s);
        return cache[start];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RepeatedSubstringPattern extends Solution {
}