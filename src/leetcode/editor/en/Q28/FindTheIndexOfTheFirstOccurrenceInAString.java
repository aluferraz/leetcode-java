package leetcode.editor.en.Q28;

import java.util.*;

//Given two strings needle and haystack, return the index of the first 
//occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// 
// Example 1: 
//
// 
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
// 
//
// Example 2: 
//
// 
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack and needle consist of only lowercase English characters. 
// 
//
// 👍 1172 👎 89


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Knuth–Morris–Pratt
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int[] needleKMP = buildKMPArray(needle);

        int haystackIdx = 0;
        int needleIdx = 0;
        char[] haystackAsArr = haystack.toCharArray();
        char[] needleAsArr = needle.toCharArray();

        while (haystackIdx + (needleKMP.length - needleIdx) <= haystackAsArr.length) {
            if (needleIdx == needleKMP.length) break;
            if (needleAsArr[needleIdx] == haystackAsArr[haystackIdx]) {
                needleIdx++;
                haystackIdx++;
            } else {
                if (needleIdx > 0) {
                    needleIdx = needleKMP[needleIdx - 1] + 1;
                } else {
                    haystackIdx++;
                }
            }
        }

        if (needleIdx != needleKMP.length) return -1;
        return haystackIdx - needleAsArr.length;
    }

    private int[] buildKMPArray(String s) {
        int[] patterns = new int[s.length()];
        Arrays.fill(patterns, -1);
        int left = 0;
        char[] sAsArr = s.toCharArray();
        for (int i = 1; i < sAsArr.length; i++) {
            if (sAsArr[left] == sAsArr[i]) {
                patterns[i] = left;
                left++;
            } else {
                if (left > 0) {
                    left = patterns[left - 1] + 1;
                    i--; //Re-check
                }
            }
        }
        return patterns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindTheIndexOfTheFirstOccurrenceInAString extends Solution {
}