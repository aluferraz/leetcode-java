package leetcode.editor.en.Q989;

import java.util.*;
import java.util.stream.Collectors;

import javafx.util.Pair;

//The array-form of an integer num is an array representing its digits in left 
//to right order. 
//
// 
// For example, for num = 1321, the array form is [1,3,2,1]. 
// 
//
// Given num, the array-form of an integer, and an integer k, return the array-
//form of the integer num + k. 
//
// 
// Example 1: 
//
// 
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
// 
//
// Example 2: 
//
// 
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
// 
//
// Example 3: 
//
// 
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
// 
//
// 
// Constraints: 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num does not contain any leading zeros except for the zero itself. 
// 1 <= k <= 10⁴ 
// 
//
// 👍 1938 👎 183


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.stream.Collectors;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i : num){
            sb.append(i);
        }
        String resStr = addStrings(
                sb.toString(),
                String.valueOf(k));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < resStr.length(); i++) {
            res.add(Character.getNumericValue(resStr.charAt(i)));
        }
        return res;

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


public class AddToArrayFormOfInteger extends Solution {
}