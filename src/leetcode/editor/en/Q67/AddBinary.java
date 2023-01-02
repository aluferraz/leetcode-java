package leetcode.editor.en.Q67;

import java.util.*;

//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// 
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
//
// 👍 6478 👎 680


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
    public String addBinary(String a, String b) {
        //If the inputs are 0
        if (a.charAt(0) == '0' && b.charAt(0) == '0') {
            return "0";
        }
        // Initialize result
        StringBuilder result = new StringBuilder("");

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result.append((char) (s % 2 + '0'));

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }

        // Remove leading zeros, if any
        int start = result.length() - 1;

        while (start >= 0 && result.charAt(start) == '0') {
            start--;
        }

        if (start != result.length() - 1) {
            result.delete(start + 1, result.length());
        }

        return result.reverse().toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)


public class AddBinary extends Solution {
}