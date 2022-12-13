package leetcode.editor.en.Q394;

import java.util.*;

//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; there are no extra 
//white spaces, square brackets are well-formed, etc. Furthermore, you may assume 
//that the original data does not contain any digits and that digits are only for 
//those repeat numbers, k. For example, there will not be input like 3a or 2[4]. 
//
// The test cases are generated so that the length of the output will never 
//exceed 10⁵. 
//
// 
// Example 1: 
//
// 
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// 
//
// Example 2: 
//
// 
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
// 
//
// Example 3: 
//
// 
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
//
// 👍 9930 👎 440


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int strPos = 0;

    public String decodeString(String s) {
        return decodeStringRec(s );
    }

    private String decodeStringRec(String s) {
        if (strPos >= s.length()) return "";
        char c = s.charAt(strPos);
        StringBuilder sb = new StringBuilder();
        if (c == '[') {
            strPos++;
            return decodeStringRec(s);
        } else if (c == ']') {
            return "";
        } else if (Character.isDigit(c)) {
            StringBuilder numberString = new StringBuilder();
            while (Character.isDigit(c)) {
                numberString.append(c);
                strPos++;
                c = s.charAt(strPos);
            }
            int repeat = Integer.valueOf(numberString.toString());
            String nextBlock = decodeStringRec(s);
            for (int i = 0; i < repeat; i++) {
                sb.append(nextBlock);
            }
            strPos++;
            sb.append(decodeStringRec(s));

        } else {
            sb.append(c);
            strPos++;
            sb.append(decodeStringRec(s));
        }
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class DecodeString extends Solution {
}