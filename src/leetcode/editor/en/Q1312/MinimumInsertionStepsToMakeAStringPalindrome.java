package leetcode.editor.en.Q1312;

import java.util.*;

import javafx.util.Pair;

//Given a string s. In one step you can insert any character at any index of 
//the string. 
//
// Return the minimum number of steps to make s palindrome. 
//
// A Palindrome String is one that reads the same backward as well as forward. 
//
// 
// Example 1: 
//
// 
//Input: s = "zzazz"
//Output: 0
//Explanation: The string "zzazz" is already palindrome we do not need any 
//insertions.
// 
//
// Example 2: 
//
// 
//Input: s = "mbadm"
//Output: 2
//Explanation: String can be "mbdadbm" or "mdbabdm".
// 
//
// Example 3: 
//
// 
//Input: s = "leetcode"
//Output: 5
//Explanation: Inserting 5 characters the string becomes "leetcodocteel".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
//
// 👍 3613 👎 48


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer cache[][];

    public int minInsertions(String s) {
        cache = new Integer[s.length()][s.length()];
        int left = 0;
        int right = s.length() - 1;

        return minInsertions(left, right, s);
    }

    private int minInsertions(int left, int right, String s) {
        if (left >= right) {
            return 0;
        }
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        int lChar = s.charAt(left);
        int rChar = s.charAt(right);
        if (lChar == rChar) {
            cache[left][right] = minInsertions(left + 1, right - 1, s);
            return cache[left][right];
        }
        int moveLeft = minInsertions(left + 1, right, s);
        int moveRight = minInsertions(left, right - 1, s);
        cache[left][right] = 1 + Math.min(moveLeft, moveRight);
        return cache[left][right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumInsertionStepsToMakeAStringPalindrome extends Solution {
}