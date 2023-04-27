package leetcode.editor.en.Q258;

import java.util.*;

import javafx.util.Pair;

//Given an integer num, repeatedly add all its digits until the result has only 
//one digit, and return it. 
//
// 
// Example 1: 
//
// 
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
// 
//
// Example 2: 
//
// 
//Input: num = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
// Follow up: Could you do it without any loop/recursion in O(1) runtime? 
//
// 👍 3619 👎 1816


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        return addDigits(String.valueOf(num));
    }


    public int addDigits(String s) {
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += Character.getNumericValue(s.charAt(i));
        }
        return addDigits(String.valueOf(ans));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class AddDigits extends Solution {
}