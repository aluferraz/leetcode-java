package leetcode.editor.en.Q125;

import java.util.*;

import javafx.util.Pair;

//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// 👍 6251 👎 6758


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char lChar = Character.toLowerCase(s.charAt(left));
            while (!Character.isAlphabetic(lChar) && !Character.isDigit(lChar)) {
                left++;
                if (left > right) return true; //Was a palindrome until here
                lChar = Character.toLowerCase(s.charAt(left));
            }

            char rChar = Character.toLowerCase(s.charAt(right));
            while (!Character.isAlphabetic(rChar) && !Character.isDigit(rChar)) {
                right--;
                if (right < left) return true;
                rChar = Character.toLowerCase(s.charAt(right));
            }
            if (lChar != rChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ValidPalindrome extends Solution {
}