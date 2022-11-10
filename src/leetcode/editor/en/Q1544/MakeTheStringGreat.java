package leetcode.editor.en.Q1544;

import java.util.*;

//Given a string s of lower and upper case English letters. 
//
// A good string is a string which doesn't have two adjacent characters s[i] 
//and s[i + 1] where: 
//
// 
// 0 <= i <= s.length - 2 
// s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-
//case or vice-versa. 
// 
//
// To make the string good, you can choose two adjacent characters that make 
//the string bad and remove them. You can keep doing this until the string becomes 
//good. 
//
// Return the string after making it good. The answer is guaranteed to be 
//unique under the given constraints. 
//
// Notice that an empty string is also good. 
//
// 
// Example 1: 
//
// 
//Input: s = "leEeetcode"
//Output: "leetcode"
//Explanation: In the first step, either you choose i = 1 or i = 2, both will 
//result "leEeetcode" to be reduced to "leetcode".
// 
//
// Example 2: 
//
// 
//Input: s = "abBAcC"
//Output: ""
//Explanation: We have many possible scenarios, and all lead to the same answer.
// For example:
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
// 
//
// Example 3: 
//
// 
//Input: s = "s"
//Output: "s"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only lower and upper case English letters. 
// 
//
// 👍 1464 👎 67


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        char[] sAsArr = s.toCharArray();
        int p = 0;
        for (int i = 0; i < sAsArr.length; i++) {
            if (p > 0 && Math.abs(sAsArr[i] - sAsArr[p - 1]) == 32) {
                p--;
            } else {
                sAsArr[p] = sAsArr[i];
                p++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            sb.append(sAsArr[i]);
        }
        return sb.toString();

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MakeTheStringGreat extends Solution {
}