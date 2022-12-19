package leetcode.editor.en.Q709;

import java.util.*;

//Given a string s, return the string after replacing every uppercase letter 
//with the same lowercase letter. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello"
//Output: "hello"
// 
//
// Example 2: 
//
// 
//Input: s = "here"
//Output: "here"
// 
//
// Example 3: 
//
// 
//Input: s = "LOVELY"
//Output: "lovely"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of printable ASCII characters. 
// 
//
// 👍 1378 👎 2519


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += ('a' - 'A');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ToLowerCase extends Solution {
}