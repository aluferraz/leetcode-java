package leetcode.editor.en.Q844;

import java.util.*;

//Given two strings s and t, return true if they are equal when both are typed 
//into empty text editors. '#' means a backspace character. 
//
// Note that after backspacing an empty text, the text will continue empty. 
//
// 
// Example 1: 
//
// 
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
// 
//
// Example 2: 
//
// 
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
// 
//
// Example 3: 
//
// 
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 200 
// s and t only contain lowercase letters and '#' characters. 
// 
//
// 
// Follow up: Can you solve it in O(n) time and O(1) space? 
//
// 👍 5754 👎 265


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            p1 = nextLetter(s, p1);
            p2 = nextLetter(t, p2);
            char c1 = p1 < 0 ? Character.MIN_VALUE : s.charAt(p1);
            char c2 = p2 < 0 ? Character.MIN_VALUE : t.charAt(p2);
            if (c1 != c2) return false;
            p1--;
            p2--;
        }
        return true;
    }


    private int nextLetter(String s, int idx) {
        int result = -1;
        if (idx < 0) return result;
        if (s.charAt(idx) != '#') return idx;
        int rewind = 0;
        while (idx >= 0 && (s.charAt(idx) == '#' || rewind > 0)) {
            if (s.charAt(idx) == '#') rewind++;
            else rewind--;
            idx--;
        }
        if (idx < 0) return result;
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BackspaceStringCompare extends Solution {
}