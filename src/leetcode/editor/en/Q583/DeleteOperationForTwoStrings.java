package leetcode.editor.en.Q583;

import java.util.*;

//Given two strings word1 and word2, return the minimum number of steps 
//required to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
//
// 👍 4663 👎 71


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        String longestCommon = longestCommonSubsequenceHelper(word1, word2);
        int p1 = 0;
        int p2 = 0;
        int result = 0;
        for (int i = 0; i < longestCommon.length(); i++) {
            while (p1 < word1.length() && word1.charAt(p1) != longestCommon.charAt(i)) {
                result++;
                p1++;
            }
            while (p2 < word2.length() && word2.charAt(p2) != longestCommon.charAt(i)) {
                result++;
                p2++;
            }
            p1++;
            p2++;
        }
        while (p2 < word2.length()) {
            result++;
            p2++;
        }
        while (p1 < word1.length()) {
            result++;
            p1++;
        }

        return result;
    }

    public String longestCommonSubsequenceHelper(String text1, String text2) {
        StringBuilder[] rowBehind = new StringBuilder[text2.length() + 1];
        Arrays.fill(rowBehind, new StringBuilder());
        StringBuilder[] row = new StringBuilder[text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            row = new StringBuilder[text2.length() + 1];
            row[0] = new StringBuilder();
            for (int j = 1; j < row.length; j++) {
                StringBuilder longestSoFar = rowBehind[j];
                if (row[j - 1].length() > rowBehind[j].length()) {
                    longestSoFar = row[j - 1];
                }
                row[j] = new StringBuilder(longestSoFar);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    row[j] = new StringBuilder(rowBehind[j - 1]).append(text2.charAt(j - 1));
                }
            }
            rowBehind = row;
        }
        return row[text2.length()].toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DeleteOperationForTwoStrings extends Solution {
}