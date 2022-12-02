package leetcode.editor.en.Q202;
import java.util.*;

//Write an algorithm to determine if a number n is happy. 
//
// A happy number is a number defined by the following process: 
//
// 
// Starting with any positive integer, replace the number by the sum of the 
//squares of its digits. 
// Repeat the process until the number equals 1 (where it will stay), or it 
//loops endlessly in a cycle which does not include 1. 
// Those numbers for which this process ends in 1 are happy. 
// 
//
// Return true if n is a happy number, and false if not. 
//
// 
// Example 1: 
//
// 
//Input: n = 19
//Output: true
//Explanation:
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 👍 7421 👎 934


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashSet<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        if(seen.contains(n)) return false;
        seen.add(n);
        String number = Integer.toString(n);
        int next = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt( String.valueOf(number.charAt(i) ));
            next += (int) Math.pow(digit,2);
        }
        if(next == 1) return true;
        return isHappy(next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class HappyNumber extends Solution {}