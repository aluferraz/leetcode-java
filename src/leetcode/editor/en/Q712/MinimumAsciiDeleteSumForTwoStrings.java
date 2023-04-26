package leetcode.editor.en.Q712;

import java.util.*;

import javafx.util.Pair;

//Given two strings s1 and s2, return the lowest ASCII sum of deleted 
//characters to make two strings equal. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum 
//possible to achieve this.
// 
//
// Example 2: 
//
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers 
//of 433 or 417, which are higher.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1 and s2 consist of lowercase English letters. 
// 
//
// 👍 2442 👎 69


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer cache[][];

    public int minimumDeleteSum(String s1, String s2) {
        cache = new Integer[s1.length() + 1][s2.length() + 1];
        return minimumDeleteSum(0, 0, s1, s2);
    }

    private int minimumDeleteSum(int i, int j, String s1, String s2) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int best = Integer.MAX_VALUE;
        if (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 == c2) {
                int use = minimumDeleteSum(i + 1, j + 1, s1, s2);
                best = Math.min(use, best);
            }
            int del1 = (int) c1 + minimumDeleteSum(i + 1, j, s1, s2);
            best = Math.min(del1, best);
            int del2 = (int) c2 + minimumDeleteSum(i, j + 1, s1, s2);
            best = Math.min(del2, best);

        } else if (i < s1.length()) {
            char c1 = s1.charAt(i);
            best = (int) c1 + minimumDeleteSum(i + 1, j, s1, s2);
        } else if (j < s2.length()) {
            char c2 = s2.charAt(j);
            best = (int) c2 + minimumDeleteSum(i, j + 1, s1, s2);

        }
        cache[i][j] = best;
        return best;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumAsciiDeleteSumForTwoStrings extends Solution {
}