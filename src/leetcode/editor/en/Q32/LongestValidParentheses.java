package leetcode.editor.en.Q32;

import java.util.*;

import javafx.util.Pair;

//Given a string containing just the characters '(' and ')', return the length 
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// 👍 10715 👎 340


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        Stack<Integer> valids = new Stack<>();
        int[] balanced = new int[s.length()];
        Arrays.fill(balanced, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                    valids.add(i);
                    break;
                case ')':
                    if (valids.isEmpty()) continue;
                    int start = valids.pop();
                    while (start > 0 && balanced[start - 1] != -1) {
                        start = balanced[start - 1];
                    }
                    balanced[i] = start;
                    longest = Math.max(longest, i - start + 1);
                    longest = Math.max(longest, i - start + 1);
            }
        }

        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestValidParentheses extends Solution {
}