package leetcode.editor.en.Q9;

import java.util.*;

//Given an integer x, return true if x is a palindrome, and false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it 
//becomes 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string?
//
// 👍 7960 👎 2360


//leetcode submit region begin(Prohibit modification and deletion)class Solution {
class Solution{
    public boolean isPalindrome(int x) {
        String palindromeS = String.valueOf(x);
        int right = palindromeS.length() - 1;
        int left = 0;
        while (left <= right) {
            if (palindromeS.charAt(left) != palindromeS.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


public class PalindromeNumber extends Solution {
}