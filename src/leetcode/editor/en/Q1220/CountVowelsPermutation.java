package leetcode.editor.en.Q1220;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
import java.math.BigInteger;

class Solution {
    BigInteger[][] cache;

    public int countVowelPermutation(int n) {
        BigInteger ans = new BigInteger("0");
        cache = new BigInteger[26][n + 1];
        ans = ans.add(countVowelPermutation('a', n - 1));
        ans = ans.add(countVowelPermutation('e', n - 1));
        ans = ans.add(countVowelPermutation('i', n - 1));
        ans = ans.add(countVowelPermutation('o', n - 1));
        ans = ans.add(countVowelPermutation('u', n - 1));
        return ans.mod(new BigInteger("1000000007")).intValue();
    }

    public BigInteger countVowelPermutation(char c, int n) {
        if (n == 0) {
            return new BigInteger("1");
        }
        BigInteger ans = new BigInteger("0");
        if (cache[c - 'a'][n] != null) {
            return cache[c - 'a'][n];
        }
        switch (c) {
            case 'a' -> {
                ans = ans.add(countVowelPermutation('e', n - 1));
            }
            case 'e' -> {
                ans = ans.add(countVowelPermutation('a', n - 1));
                ans = ans.add(countVowelPermutation('i', n - 1));
            }
            case 'i' -> {
                ans = ans.add(countVowelPermutation('a', n - 1));
                ans = ans.add(countVowelPermutation('e', n - 1));
                ans = ans.add(countVowelPermutation('o', n - 1));
                ans = ans.add(countVowelPermutation('u', n - 1));
            }
            case 'o' -> {
                ans = ans.add(countVowelPermutation('i', n - 1));
                ans = ans.add(countVowelPermutation('u', n - 1));
            }
            case 'u' -> {
                ans = ans.add(countVowelPermutation('a', n - 1));
            }

        }
        cache[c - 'a'][n] = ans;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CountVowelsPermutation extends Solution {
}