package leetcode.editor.en.Q224;

import java.util.*;

//Given a string s representing a valid expression, implement a basic
//calculator to evaluate it, and return the result of the evaluation.
//
// Note: You are not allowed to use any built-in function which evaluates
//strings as mathematical expressions, such as eval().
//
//
// Example 1:
//
//
//Input: s = "1 + 1"
//Output: 2
//
//
// Example 2:
//
//
//Input: s = " 2-1 + 2 "
//Output: 3
//
//
// Example 3:
//
//
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 10⁵
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
//
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.
//
//
// 👍 4628 👎 354


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int pos;

    public int calculate(String s) {
//        char[] safeString = sanitize(s);
        int result = 0;

        while (pos < s.length()) {
            result += calculateHelper(s.toCharArray());
            pos++;
        }
        return result;
    }

//    private char[] sanitize(String s) {
//        char[] safeStr = new char[s.length() + 2];
//        safeStr[0] = '(';
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != ' ') sb.append(s.charAt(i));
//        }
//        safeStr[safeStr.length - 1] = ')';
//        return sb.toString();
//    }

    public int calculateHelper(char[] s) {
        int result = 0;
        while (pos < s.length && s[pos] != ')') {
            result += nextNumber(s);
            pos++;
        }
        return result;
    }


    private int nextNumber(char[] s) {
        if (pos >= s.length) return 0;
        char c = s[pos];
        switch (c) {
            case ' ':
                pos++;
                return nextNumber(s);
            case '+':
            case ')':
                return 0;
            case '(':
                pos++;
                return calculateHelper(s);
            case '-':
                pos++;
                int nextNumber = nextNumber(s);
                return -1 * nextNumber;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        while (pos + 1 < s.length && isNumeric(s[pos + 1])) {
            pos++;
            c = s[pos];
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isNumeric(char c) {
        return (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0');
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BasicCalculator extends Solution {
}