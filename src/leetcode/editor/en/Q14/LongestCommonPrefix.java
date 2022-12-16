package leetcode.editor.en.Q14;

import java.util.*;

//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// 👍 11717 👎 3580


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int right = strs[0].length();
        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
            if (minLen == 0) return "";
            right = Math.min(minLen, right);
            while (!str.substring(0, right).equals(strs[0].substring(0, right))) {
                right--;
            }
//
//            for (int i = 0; i < minLen; i++) {
//                if (str.charAt(i) != strs[0].charAt(i)) {
//                    right = Math.min(i, right);
//                    break;
//                }
//            }
        }
        return strs[0].substring(0, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestCommonPrefix extends Solution {
}