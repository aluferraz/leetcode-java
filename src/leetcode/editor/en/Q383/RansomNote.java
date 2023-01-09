package leetcode.editor.en.Q383;

import java.util.*;

//Given two strings ransomNote and magazine, return true if ransomNote can be 
//constructed by using the letters from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// 
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// 
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
//
// 👍 3505 👎 392


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mCounter = new int[26];
        int M = magazine.length();
        int R = ransomNote.length();
        for (int i = 0; i < M; i++) {
            mCounter[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < R; i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (mCounter[idx] == 0) return false;
            mCounter[idx]--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RansomNote extends Solution {
}