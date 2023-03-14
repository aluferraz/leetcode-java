package leetcode.editor.en.Q1933;

import java.util.*;

import javafx.util.Pair;

//A value-equal string is a string where all characters are the same. 
//
// 
// For example, "1111" and "33" are value-equal strings. 
// In contrast, "123" is not a value-equal string. 
// 
//
// Given a digit string s, decompose the string into some number of consecutive 
//value-equal substrings where exactly one substring has a length of 2 and the 
//remaining substrings have a length of 3. 
//
// Return true if you can decompose s according to the above rules. Otherwise, 
//return false. 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: s = "000111000"
//Output: false
//Explanation: s cannot be decomposed according to the rules because ["000", "11
//1", "000"] does not have a substring of length 2.
// 
//
// Example 2: 
//
// 
//Input: s = "00011111222"
//Output: true
//Explanation: s can be decomposed into ["000", "111", "11", "222"].
// 
//
// Example 3: 
//
// 
//Input: s = "011100022233"
//Output: false
//Explanation: s cannot be decomposed according to the rules because of the 
//first '0'.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of only digits '0' through '9'. 
// 
//
// 👍 46 👎 11


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public boolean isDecomposable(String s) {
        cache = new Integer[s.length()][2];
        return isDecomposable(s, 0, true);
    }

    public boolean isDecomposable(String s, int i, boolean canUse) {
        if (i == s.length()) return !canUse; //Must arrive here with false

        if (cache[i][canUse ? 1 : 0] != null) return false;
        HashSet<Character> chars = new HashSet<>();
        if (canUse) {
            if (i + 2 > s.length()) return false;
            for (int j = i; j < i + 2; j++) {
                chars.add(s.charAt(j));
            }
            if (chars.size() == 1) {
                if (isDecomposable(s, i + 2, false)) return true;
            }
        }
        chars.clear();
        if (i + 3 > s.length()) return false;
        for (int j = i; j < i + 3; j++) {
            chars.add(s.charAt(j));
        }
        if (chars.size() == 1) {
            if (isDecomposable(s, i + 3, canUse)) {
                return true;
            }
        }
        cache[i][canUse ? 1 : 0] = 0;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CheckIfStringIsDecomposableIntoValueEqualSubstrings extends Solution {
}