package leetcode.editor.en.Q1323;
import java.util.*;

//You are given a positive integer num consisting only of digits 6 and 9. 
//
// Return the maximum number you can get by changing at most one digit (6 
//becomes 9, and 9 becomes 6). 
//
// 
// Example 1: 
//
// 
//Input: num = 9669
//Output: 9969
//Explanation: 
//Changing the first digit results in 6669.
//Changing the second digit results in 9969.
//Changing the third digit results in 9699.
//Changing the fourth digit results in 9666.
//The maximum number is 9969.
// 
//
// Example 2: 
//
// 
//Input: num = 9996
//Output: 9999
//Explanation: Changing the last digit 6 to 9 results in the maximum number.
// 
//
// Example 3: 
//
// 
//Input: num = 9999
//Output: 9999
//Explanation: It is better not to apply any change.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 10⁴ 
// num consists of only 6 and 9 digits. 
// 
//
// 👍 1647 👎 155


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum69Number (int num) {
        String numAsString = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        for(int i = 0; i < numAsString.length(); i++){
            char c = numAsString.charAt(i);
            if(c == '6' && !changed) {
                sb.append('9');
                changed = true;
            }else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class Maximum69Number extends Solution {}