package leetcode.editor.en.Q784;

import java.util.*;

//Given a string s, you can transform every letter individually to be lowercase 
//or uppercase to create another string. 
//
// Return a list of all possible strings we could create. Return the output in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
// 
//
// Example 2: 
//
// 
//Input: s = "3z4"
//Output: ["3z4","3Z4"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 12 
// s consists of lowercase English letters, uppercase English letters, and 
//digits. 
// 
//
// 👍 3886 👎 150


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permute(result, s.toCharArray(), 0);
        return result;
    }

    public void permute(List<String> result, char[] current, int pos) {
        if (pos == current.length) {
            result.add(String.valueOf(current));
            return;
        }

        char letter = current[pos];
        permute(result, current, pos + 1);
        if (Character.isAlphabetic(letter)) {
            current[pos] = toggleCase(letter);
            permute(result, current, pos + 1);
            current[pos] = toggleCase(letter);
        }

    }

    private Character toggleCase(char c) {
        if (Character.isUpperCase(c)) return Character.toLowerCase(c);
        return Character.toUpperCase(c);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LetterCasePermutation extends Solution {
}