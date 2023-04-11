package leetcode.editor.en.Q2390;

import java.util.*;

import javafx.util.Pair;

//You are given a string s, which contains stars *. 
//
// In one operation, you can: 
//
// 
// Choose a star in s. 
// Remove the closest non-star character to its left, as well as remove the 
//star itself. 
// 
//
// Return the string after all stars have been removed. 
//
// Note: 
//
// 
// The input will be generated such that the operation is always possible. 
// It can be shown that the resulting string will always be unique. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "leet**cod*e"
//Output: "lecoe"
//Explanation: Performing the removals from left to right:
//- The closest character to the 1ˢᵗ star is 't' in "leet**cod*e". s becomes 
//"lee*cod*e".
//- The closest character to the 2ⁿᵈ star is 'e' in "lee*cod*e". s becomes 
//"lecod*e".
//- The closest character to the 3ʳᵈ star is 'd' in "lecod*e". s becomes 
//"lecoe".
//There are no more stars, so we return "lecoe". 
//
// Example 2: 
//
// 
//Input: s = "erase*****"
//Output: ""
//Explanation: The entire string is removed, so we return an empty string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters and stars *. 
// The operation above can be performed on s. 
// 
//
// 👍 1239 👎 84


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeStars(String s) {
        LinkedList<Character> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*' && !res.isEmpty()) {
                res.pollLast();
                continue;
            }
            res.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c :
                res) {
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemovingStarsFromAString extends Solution {
}