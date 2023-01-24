package leetcode.editor.en.Q409;

import java.util.*;

import javafx.util.Pair;

//Given a string s which consists of lowercase or uppercase letters, return the 
//length of the longest palindrome that can be built with those letters. 
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome 
//here. 
//
// 
// Example 1: 
//
// 
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose 
//length is 7.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 
//1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
//
// 👍 4240 👎 255


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] counter = new int[127];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'A']++;
        }

        int odds = 0;
        int res = s.length();
        for (int count : counter) {
            if (count % 2 != 0) odds++;
        }
        //We can only have one odd letter, so we remove the odd letters
        if (odds > 0) {
            res -= (odds - 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestPalindrome extends Solution {
}