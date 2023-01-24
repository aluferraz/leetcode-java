package leetcode.editor.en.Q415;

import java.util.*;

import javafx.util.Pair;

//Given two non-negative integers, num1 and num2 represented as string, return 
//the sum of num1 and num2 as a string. 
//
// You must solve the problem without using any built-in library for handling 
//large integers (such as BigInteger). You must also not convert the inputs to 
//integers directly. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "11", num2 = "123"
//Output: "134"
// 
//
// Example 2: 
//
// 
//Input: num1 = "456", num2 = "77"
//Output: "533"
// 
//
// Example 3: 
//
// 
//Input: num1 = "0", num2 = "0"
//Output: "0"
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 and num2 consist of only digits. 
// num1 and num2 don't have any leading zeros except for the zero itself. 
// 
//
// 👍 4136 👎 625


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) return addStrings(num2, num1);
        int[][] sums = new int[11][11];
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                sums[i][j] = i + j;
            }
        }
        char carryOn = '0';

        int N = num1.length();
        int M = num2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - M; i++) {
            sb.append('0');
        }
        sb.append(num2);
        num2 = sb.toString();

        sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            int d1 = Character.getNumericValue(num1.charAt(i));
            int d2 = Character.getNumericValue(num2.charAt(i));
            int sum = sums[d1][d2];
            String sSum = String.valueOf(sum);
            char newCarryOn = '0';
            char cVal = sSum.charAt(sSum.length() - 1);
            if (sSum.length() > 1) {
                newCarryOn = sSum.charAt(0);
            }
            int finalSum = sums[Character.getNumericValue(cVal)][Character.getNumericValue(carryOn)];
            sSum = String.valueOf(finalSum);
            cVal = sSum.charAt(sSum.length() - 1);
            sb.append(cVal);
            if (sSum.length() > 1) {
                carryOn = String.valueOf(sums[Character.getNumericValue(sSum.charAt(0))][Character.getNumericValue(newCarryOn)]).charAt(0);
            } else {
                carryOn = String.valueOf(sums[0][Character.getNumericValue(newCarryOn)]).charAt(0);
            }
        }
        if (carryOn != '0') {
            sb.append(carryOn);
        }

        return sb.reverse().toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class AddStrings extends Solution {
}