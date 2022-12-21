package leetcode.editor.en.Q132;

import java.util.*;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. 
//
// Return the minimum cuts needed for a palindrome partitioning of s. 
//
// 
// Example 1: 
//
// 
//Input: s = "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 
//cut.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: s = "ab"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase English letters only. 
// 
//
// 👍 4304 👎 99


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] palindromes;

    public int minCut(String s) {
        return minCut(s.toCharArray());
    }

    public int minCut(char[] s) {
        //https://www.algoexpert.io/questions/palindrome-partitioning-min-cuts
        int[] dp = new int[s.length];
        palindromes = new boolean[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            palindromes[i][i] = true;
        }
        for (int length = 2; length <= s.length; length++) {
            for (int i = 0; i < s.length - length + 1; i++) {
                int j = i + length - 1;
                if (length == 2) {
                    palindromes[i][j] = s[i] == s[j];
                } else {
                    palindromes[i][j] = s[i] == s[j] && palindromes[i + 1][j - 1];
                }
            }
        }


        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < s.length; i++) {
            int cutsNeeded;
            if (palindromes[0][i]) {
                cutsNeeded = 0;
            } else {
                cutsNeeded = dp[i - 1] + 1;
                for (int j = i - 1; j > 0; j--) {
                    if (palindromes[j][i]) {
                        cutsNeeded = Math.min(cutsNeeded, dp[j - 1] + 1);
                    }
                }
            }
            dp[i] = cutsNeeded;
        }

        return dp[dp.length - 1];
    }

    private boolean isPalindrome(int start, int end) {
        return palindromes[start][end];
    }
//    private boolean isPalindrome(String s, int start, int end) {
//        //  System.out.println(s.substring(start, end + 1));
//        if (cache[start][end] != null) return cache[start][end];
//        int left = start;
//        int right = end;
//        while (left <= right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                cache[start][end] = false;
//                return false;
//            }
//            left++;
//            right--;
//        }
//        cache[start][end] = true;
//        return cache[start][end];
//    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class PalindromePartitioningIi extends Solution {
}