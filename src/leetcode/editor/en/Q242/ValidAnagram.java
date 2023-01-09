package leetcode.editor.en.Q242;

import java.util.*;

//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// 
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// 👍 7917 👎 253


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(countStr(s), countStr(t));
    }

    private int[] countStr(String x) {
        int[] counter = new int[26];
        int N = x.length();
        for (int i = 0; i < N; i++) {
            counter[x.charAt(i) - 'a']++;
        }
        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ValidAnagram extends Solution {
}