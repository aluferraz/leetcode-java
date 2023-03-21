package leetcode.editor.en.Q796;

import java.util.*;

import javafx.util.Pair;

//Given two strings s and goal, return true if and only if s can become goal 
//after some number of shifts on s. 
//
// A shift on s consists of moving the leftmost character of s to the rightmost 
//position. 
//
// 
// For example, if s = "abcde", then it will be "bcdea" after one shift. 
// 
//
// 
// Example 1: 
// Input: s = "abcde", goal = "cdeab"
//Output: true
// 
// Example 2: 
// Input: s = "abcde", goal = "abced"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s and goal consist of lowercase English letters. 
// 
//
// 👍 2647 👎 108


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                if ((s.substring(i) + s.substring(0, i)).equals(goal)){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RotateString extends Solution {
}