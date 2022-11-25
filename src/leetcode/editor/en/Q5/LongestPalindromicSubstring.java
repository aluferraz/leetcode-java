package leetcode.editor.en.Q5;

import java.util.*;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// 👍 22728 👎 1318


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 1;
        int leftFinal = 0;
        int rightFinal = 1;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            int lenght = 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                lenght = right - left + 1;
                left--;
                right++;
            }
            if (lenght > maxLength) {
                leftFinal = left + 1;
                rightFinal = right;
                maxLength = lenght;
            }
            left = i - 1;
            right = i;
            lenght = 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                lenght = right - left + 1;
                left--;
                right++;
            }
            if (lenght > maxLength) {
                leftFinal = left + 1;
                rightFinal = right;
                maxLength = lenght;
            }
        }
        return s.substring(leftFinal, rightFinal);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestPalindromicSubstring extends Solution {
}