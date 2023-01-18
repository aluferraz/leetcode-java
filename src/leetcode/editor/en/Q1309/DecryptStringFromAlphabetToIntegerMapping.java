package leetcode.editor.en.Q1309;

import java.util.*;

import javafx.util.Pair;

//You are given a string s formed by digits and '#'. We want to map s to 
//English lowercase characters as follows: 
//
// 
// Characters ('a' to 'i') are represented by ('1' to '9') respectively. 
// Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
// 
//
// Return the string formed after mapping. 
//
// The test cases are generated so that a unique mapping will always exist. 
//
// 
// Example 1: 
//
// 
//Input: s = "10#11#12"
//Output: "jkab"
//Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
// 
//
// Example 2: 
//
// 
//Input: s = "1326#"
//Output: "acz"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of digits and the '#' letter. 
// s will be a valid string such that mapping is always possible. 
// 
//
// 👍 1261 👎 86


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                int number = Integer.parseInt(s.substring(i - 2, i));
                i -= 3;
                sb.append((char) ('a' + number - 1));
            } else {
                sb.append((char) ('a' + Character.getNumericValue(s.charAt(i)) - 1));
                i--;
            }
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DecryptStringFromAlphabetToIntegerMapping extends Solution {
}