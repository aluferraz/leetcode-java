package leetcode.editor.en.Q639;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;

    private int MOD = 1000000007;

    public int numDecodings(String s) {
        if (
                s.charAt(0) == '0' ||
                        s.contains("30" ) ||
                        s.contains("40" ) ||
                        s.contains("50" ) ||
                        s.contains("60" ) ||
                        s.contains("70" ) ||
                        s.contains("80" ) ||
                        s.contains("90" ) ||
                        s.contains("00" )
        ) return 0;
        cache = new Integer[s.length()][11];


        return (numDecodingsHelper(s.length() - 1, new StringBuilder(s)) % MOD);


    }

    private int numDecodingsHelper(int i, StringBuilder s) {
        if (i < 0) return 1;
        int ans = 0;
        char c = s.charAt(i);
        int cacheKey = c == '*' ? 10 : c - '0';


        if (cache[i][cacheKey] != null) {
            return cache[i][cacheKey];
        }

        if (c == '*') {
            for (int j = 1; j <= 9; j++) {
                s.setCharAt(i, String.valueOf(j).charAt(0));
                ans = (ans % MOD + (numDecodingsHelper(i, s) % MOD));
            }
            s.setCharAt(i, '*');
            cache[i][cacheKey] = ans;
            return ans;
        }
        int current = Character.getNumericValue(c);
        if (current == 0) {
            char prevC = s.charAt(i - 1);
            if (prevC == '*') {
                ans = (2 * (numDecodingsHelper(i - 2, s) % MOD) % MOD);
            } else {
                ans = (numDecodingsHelper(i - 2, s) % MOD);
            }
            cache[i][cacheKey] = ans;
            return ans;
        }
        ans = numDecodingsHelper(i - 1, s) % MOD;
        if (i > 0) {
            char prevC = s.charAt(i - 1);
            if (prevC == '*') {
                for (int j = 1; j <= 9; j++) {
                    int prev = j;
                    int combination = (prev * 10) + current;
                    if (combination >= 1 && combination <= 26) {
                        ans = (ans % MOD + (numDecodingsHelper(i - 2, s) % MOD));
                    }
                }
            } else {
                int prev = Character.getNumericValue(prevC);
                int combination = (prev * 10) + current;
                if (combination >= 10 && combination <= 26) {
                    ans = (ans % MOD + (numDecodingsHelper(i - 2, s) % MOD));
                }
            }
        }
        cache[i][cacheKey] = ans;
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DecodeWaysIi extends Solution {
}