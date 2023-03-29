package leetcode.editor.en.Q205;

import java.util.*;

import javafx.util.Pair;

//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same 
//character, but a character may map to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// 
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// 
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
//
// 👍 6412 👎 1366


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[256];
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (alphabet[c1] == -1) {
                //Unseen
                alphabet[c1] = c2;
                c1 = c2;

            } else {
                c1 = (char) (alphabet[c1]);
            }
            if (c1 != c2) return false;

        }
        int[] counter = new int[256];
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] < 0) continue;
            counter[alphabet[i]]++;
            if (counter[alphabet[i]] >= 2) return false;
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class IsomorphicStrings extends Solution {
}