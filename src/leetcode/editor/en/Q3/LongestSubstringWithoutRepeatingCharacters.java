package leetcode.editor.en.Q3;

//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// 👍 29855 👎 1272


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[127];
        int left = 0;
        int right = 0;
        int longestSubstring = 0;
        while (right < s.length()) {
            int idx = s.charAt(right);
            charCount[idx]++;
            while (charCount[idx] > 1) {
                int leftIdx = s.charAt(left);
                charCount[leftIdx]--;
                left++;
            }
            longestSubstring = Math.max(longestSubstring, ((right - left) + 1));
            right++;
        }
        return longestSubstring;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
