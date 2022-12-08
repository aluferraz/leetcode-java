package leetcode.editor.en.Q76;

import java.util.*;

//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// 👍 13797 👎 603


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> tCount = countChars(t);
        int left = 0;
        int right = 0;
        int[] result = new int[]{-1, Integer.MAX_VALUE - 1};

        Set<Character> missingLetters = new HashSet<>(tCount.keySet());
        HashMap<Character, Integer> sCount = new HashMap<>();
        while (right < s.length()) {
            Character cur = s.charAt(right);
            sCount.put(cur, sCount.getOrDefault(cur, 0) + 1);
            if (tCount.containsKey(cur) && sCount.get(cur) >= tCount.get(cur)) {
                missingLetters.remove(cur);
            }
            while (missingLetters.size() == 0 && left <= right) {
                Character leftChar = s.charAt(left);
                if (result[1] - result[0] >= right - left) {
                    result[0] = left;
                    result[1] = right;
                }
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && sCount.get(leftChar) < tCount.get(leftChar)) {
                    missingLetters.add(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        if (result[0] == -1) return "";
        return s.substring(result[0], result[1] + 1);
    }

    private HashMap<Character, Integer> countChars(String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        return tCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumWindowSubstring extends Solution {
}