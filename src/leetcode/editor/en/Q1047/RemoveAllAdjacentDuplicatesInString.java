package leetcode.editor.en.Q1047;

import java.util.*;

//You are given a string s consisting of lowercase English letters. A duplicate 
//removal consists of choosing two adjacent and equal letters and removing them. 
//
// We repeatedly make duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//can be proven that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent 
//and equal, and this is the only possible move.  The result of this move is that 
//the string is "aaca", of which only "aa" is possible, so the final string is 
//"ca".
// 
//
// Example 2: 
//
// 
//Input: s = "azxxzy"
//Output: "ay"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
//
// 👍 4586 👎 190


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        char[] result = s.toCharArray();
        int p = 0;
        for (int i = 0; i < result.length; i++) {
            if (p > 0 && result[i] == result[p - 1]) {
                p--;
            } else {
                result[p] = result[i];
                p++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemoveAllAdjacentDuplicatesInString extends Solution {
}