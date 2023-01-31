package leetcode.editor.en.Q1249;

import java.util.*;

import javafx.util.Pair;

//Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in
//any positions ) so that the resulting parentheses string is valid and return any
//valid string.
//
// Formally, a parentheses string is valid if and only if:
//
//
// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid
//strings, or
// It can be written as (A), where A is a valid string.
//
//
//
// Example 1:
//
//
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
//
//
// Example 2:
//
//
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
//
//
// Example 3:
//
//
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁵
// s[i] is either'(' , ')', or lowercase English letter.
//
//
// 👍 5537 👎 103


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String minRemoveToMakeValid(String s) {
        int[] closing = new int[s.length()];

        if (s.charAt(s.length() - 1) == ')') closing[s.length() - 1] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            closing[i] = closing[i + 1] + (s.charAt(i) == ')' ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (closing[i] - (open + 1) >= 0) {
                    sb.append(c);
                    open++;
                }
            } else if (c == ')') {
                if (open > 0) {
                    sb.append(c);
                    open--;
                }
            } else {
                sb.append(c);
            }


        }
        return sb.toString();

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumRemoveToMakeValidParentheses extends Solution {
}