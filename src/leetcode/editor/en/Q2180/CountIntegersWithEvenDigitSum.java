package leetcode.editor.en.Q2180;

import java.util.*;

import javafx.util.Pair;

//Given a positive integer num, return the number of positive integers less 
//than or equal to num whose digit sums are even. 
//
// The digit sum of a positive integer is the sum of all its digits. 
//
// 
// Example 1: 
//
// 
//Input: num = 4
//Output: 2
//Explanation:
//The only integers less than or equal to 4 whose digit sums are even are 2 and 
//4.    
// 
//
// Example 2: 
//
// 
//Input: num = 30
//Output: 14
//Explanation:
//The 14 integers less than or equal to 30 whose digit sums are even are
//2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 1000 
// 
//
// 👍 463 👎 21


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i ++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int digitSum = 0;
            for (int j = 0; j < sb.length(); j++) {
                digitSum += Character.getNumericValue(sb.charAt(j));
            }
            if (digitSum % 2 == 0) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CountIntegersWithEvenDigitSum extends Solution {
}