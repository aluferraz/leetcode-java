package leetcode.editor.en.Q402;

import java.util.*;

import javafx.util.Pair;

//Given string num representing a non-negative integer num, and an integer k, 
//return the smallest possible integer after removing k digits from num. 
//
// 
// Example 1: 
//
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
//which is the smallest.
// 
//
// Example 2: 
//
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
//
// Example 3: 
//
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with 
//nothing which is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num consists of only digits. 
// num does not have any leading zeros except for the zero itself. 
// 
//
// 👍 7257 👎 301


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        HashSet<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < num.length() && k > 0; i++) {
            int cDigit = Character.getNumericValue(num.charAt(i));
            while (!stack.isEmpty() && k > 0 && cDigit < Character.getNumericValue(num.charAt(stack.peekLast()))) {
                k--;
                toRemove.add(stack.pollLast());
            }
            stack.add(i);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (!toRemove.contains(i)) {
                if (res.length() == 0 && num.charAt(i) == '0') continue;
                res.append(num.charAt(i));
            }
        }
        while (k > 0 && res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }

        if (res.length() == 0) res.append(0);
        return res.toString();
    }


}


//leetcode submit region end(Prohibit modification and deletion)


public class RemoveKDigits extends Solution {
}