package leetcode.editor.en.Q727;

import java.util.*;

import javafx.util.Pair;

//Given strings s1 and s2, return the minimum contiguous substring part of s1, 
//so that s2 is a subsequence of the part. 
//
// If there is no such window in s1 that covers all characters in s2, return 
//the empty string "". If there are multiple such minimum-length windows, return the 
//one with the left-most starting index. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "abcdebdde", s2 = "bde"
//Output: "bcde"
//Explanation: 
//"bcde" is the answer because it occurs before "bdde" which has the same 
//length.
//"deb" is not a smaller window because the elements of s2 in the window must 
//occur in order.
// 
//
// Example 2: 
//
// 
//Input: s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length <= 2 * 10⁴ 
// 1 <= s2.length <= 100 
// s1 and s2 consist of lowercase English letters. 
// 
//
// 👍 1378 👎 84


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;


    public String minWindow(String s1, String s2) {
        int[] strIdxes = new int[]{0, Integer.MAX_VALUE};
        cache = new Integer[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                int end = minWindow(i, 0, s1, s2);
                if (end != -1 && (end - i) < (strIdxes[1] - strIdxes[0])) {
                    strIdxes[0] = i;
                    strIdxes[1] = end;
                }
            }
        }

        return strIdxes[1] != Integer.MAX_VALUE ? s1.substring(strIdxes[0], strIdxes[1]) : "";

    }

    public int minWindow(int i, int j, String s1, String s2) {

        if (j == s2.length()) {
            return i;
        }
        if (i == s1.length()) {
            return -1;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = minWindow(i + 1, j + 1, s1, s2);
            return cache[i][j];
        }
        cache[i][j] = minWindow(i + 1, j, s1, s2);
        return cache[i][j];
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumWindowSubsequence extends Solution {
}