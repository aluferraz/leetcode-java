package leetcode.editor.en.Q1416;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;
import leetcode.editor.en.Q868.BinaryGap;

//A program was supposed to print an array of integers. The program forgot to 
//print whitespaces and the array is printed as a string of digits s and all we 
//know is that all integers in the array were in the range [1, k] and there are no 
//leading zeros in the array. 
//
// Given the string s and the integer k, return the number of the possible 
//arrays that can be printed as s using the mentioned program. Since the answer may be 
//very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: s = "1000", k = 10000
//Output: 1
//Explanation: The only possible array is [1000]
// 
//
// Example 2: 
//
// 
//Input: s = "1000", k = 10
//Output: 0
//Explanation: There cannot be an array that was printed this way and has all 
//integer >= 1 and <= 10.
// 
//
// Example 3: 
//
// 
//Input: s = "1317", k = 2000
//Output: 8
//Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31
//,7],[1,3,17],[1,3,1,7]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only digits and does not contain leading zeros. 
// 1 <= k <= 10⁹ 
// 
//
// 👍 1050 👎 37


//leetcode submit region begin(Prohibit modification and deletion)
import java.math.BigInteger;

class Solution {

    private static final long MOD = 1000000007L;
    BigInteger[] cache;

    public int numberOfArrays(String s, int k) {
        cache = new BigInteger[s.length()];
        BigInteger ans = numberOfArrays(0, s, new BigInteger(String.valueOf(k)));
        return ans.mod(new BigInteger("1000000007")).intValue();

    }

    private BigInteger numberOfArrays(int i, String s, BigInteger k) {
        if (i == s.length()) {
            return new BigInteger("1");
        }
        int c = Character.getNumericValue(s.charAt(i));
        if (c == 0) {
            return new BigInteger("0");
        }
        if (cache[i] != null) {
            return cache[i];
        }

        BigInteger num = new BigInteger("0");
        BigInteger ans = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        for (int j = i; j < s.length(); j++) {
            num = num.multiply(ten);
            num = num.add(new BigInteger(String.valueOf(s.charAt(j))));
            if (num.compareTo(k) <= 0) {
                ans = ans.add(numberOfArrays(j + 1, s, k));
            } else {
                break;
            }
        }
        ans = ans.mod(new BigInteger("1000000007"));
        cache[i] = ans;

        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class RestoreTheArray extends Solution {
}