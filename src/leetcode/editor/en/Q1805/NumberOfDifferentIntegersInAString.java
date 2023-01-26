package leetcode.editor.en.Q1805;

import java.util.*;

import javafx.util.Pair;

//You are given a string word that consists of digits and lowercase English 
//letters. 
//
// You will replace every non-digit character with a space. For example, "a123
//bc34d8ef34" will become " 123 34 8 34". Notice that you are left with some 
//integers that are separated by at least one space: "123", "34", "8", and "34". 
//
// Return the number of different integers after performing the replacement 
//operations on word. 
//
// Two integers are considered different if their decimal representations 
//without any leading zeros are different. 
//
// 
// Example 1: 
//
// 
//Input: word = "a123bc34d8ef34"
//Output: 3
//Explanation: The three different integers are "123", "34", and "8". Notice 
//that "34" is only counted once.
// 
//
// Example 2: 
//
// 
//Input: word = "leet1234code234"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: word = "a1b01c001"
//Output: 1
//Explanation: The three integers "1", "01", and "001" all represent the same 
//integer because
//the leading zeros are ignored when comparing their decimal values.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 1000 
// word consists of digits and lowercase English letters. 
// 
//
// 👍 457 👎 83


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> res = new HashSet<>();
        int left = 0;

        while (left < word.length()) {
            char c = word.charAt(left);
            StringBuilder sb = new StringBuilder();
            while (left < word.length() && Character.isDigit(c)) {
                sb.append(c);
                left++;
                if (left < word.length())
                    c = word.charAt(left);
            }
            if (sb.length() > 0) {
                while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
                res.add(sb.toString());
            }
            left++;
        }
        return res.size();


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfDifferentIntegersInAString extends Solution {
}