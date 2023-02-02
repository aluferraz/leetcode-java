package leetcode.editor.en.Q1071;

import java.util.*;

import javafx.util.Pair;

//For two strings s and t, we say "t divides s" if and only if s = t + ... + t (
//i.e., t is concatenated with itself one or more times). 
//
// Given two strings str1 and str2, return the largest string x such that x 
//divides both str1 and str2. 
//
// 
// Example 1: 
//
// 
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
// 
//
// Example 2: 
//
// 
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 and str2 consist of English uppercase letters. 
// 
//
// 👍 2157 👎 365


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int[] str1Cnt = countStr(str1);
        int[] str2Cnt = countStr(str2);
        for (int i = 0; i < str1Cnt.length; i++) {
            //Must have same letters
            if (str2Cnt[i] > 0 && str1Cnt[i] == 0 || str1Cnt[i] > 0 && str2Cnt[i] == 0) {
                return "";
            }
        }

        for (int i = str2.length(); i >= 0; i--) {
            if (i == 0 || str1.length() % i != 0) continue;
            String cut = str2.substring(0, i);
            StringBuilder sb = new StringBuilder(cut);
            int repeat = str1.length() / i;
            for (int j = 1; j < repeat; j++) {
                sb.append(cut);
            }

            if (sb.toString().equals(str1)) {
                sb = new StringBuilder(cut);
                if ((str2.length() - i) % cut.length() != 0) continue;
                repeat = str2.length() / cut.length();
                for (int j = 1; j < repeat; j++) {
                    sb.append(cut);
                }
                if (sb.toString().equals(str2)) {
                    return str2.substring(0, i);
                }
            }
        }
        return "";
    }


    private int[] countStr(String str) {
        int[] strCnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            strCnt[str.charAt(i) - 'A']++;
        }
        return strCnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class GreatestCommonDivisorOfStrings extends Solution {
}