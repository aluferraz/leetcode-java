package leetcode.editor.en.Q43;
import java.util.*;
import javafx.util.Pair;

//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// 👍 5695 👎 2515


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public String multiply(String num1, String num2) {
        if (num2.length() < num1.length()) return multiply(num2, num1);
        Queue<String> sumQueue = new LinkedList<>();
        Deque<Integer> carryOn = new LinkedList<>();

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Character.getNumericValue(num1.charAt(i));
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j > i; j--) {
                sb.append(0);
            }
            for (int j = num2.length() - 1; j >= 0; j--) {

                int n2 = Character.getNumericValue(num2.charAt(j));
                int mult = (n1 * n2);
                if (!carryOn.isEmpty()) mult += carryOn.poll();
                String sMult = String.valueOf(mult);
                sb.append(sMult.charAt(sMult.length() - 1));
                for (int k = sMult.length() - 2; k >= 0; k--) {
                    carryOn.addLast(Character.getNumericValue(sMult.charAt(k)));
                }
            }
            while (!carryOn.isEmpty()) {
                sb.append(carryOn.poll());
            }
            sumQueue.add(sb.reverse().toString());
        }
        String res = "0";
        while (!sumQueue.isEmpty()) {
            res = addStrings(res, sumQueue.poll());
        }
        StringBuilder sb = new StringBuilder(res);
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }


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



public class MultiplyStrings extends Solution {}