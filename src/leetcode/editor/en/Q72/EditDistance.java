package leetcode.editor.en.Q72;

import java.util.*;

//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
//
// 👍 10556 👎 121


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int[] rowBehind = new int[word2.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[0][i] = i;
//        }
        for (int i = 0; i < rowBehind.length; i++) {
            rowBehind[i] = i;
        }
        int[] row = new int[word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            row = new int[word2.length() + 1];
            row[0] = i;
            for (int j = 1; j < row.length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    row[j] = rowBehind[j - 1];
                } else {
                    row[j] = Math.min(rowBehind[j], Math.min(row[j - 1], rowBehind[j - 1])) + 1;
                }
            }
            rowBehind = row;
        }
        return row[word2.length()];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class EditDistance extends Solution {
}