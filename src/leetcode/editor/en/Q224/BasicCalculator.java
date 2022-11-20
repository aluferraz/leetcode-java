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
    public int calculate(String s) {
        String safeCalc = "(" + s + ")+0"; //Handle dry runs like "1", "-1", etc
        return calculateHelper(s, 0);
    }

    private int calculateHelper(String s, Integer pos) {
        if (pos == s.length()) return calculateHelper(s, pos + 1);
        char c = getNextChar(s, pos);
        return 0;
    }

    private char getNextChar(String s, Integer pos) {
        char c = s.charAt(pos);
        while (pos < s.length() && c == ' ') {
            pos++;
            c = s.charAt(pos);
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BasicCalculator extends Solution {
}