package leetcode.editor.en.Q567;

//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// 👍 7435 👎 250


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        return Solution.checkInclusion(s1, s2);
    }
}


class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        int start = 'a';
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - start]++;
        }
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            windowCount[s2.charAt(right) - start]++;
            if ((right - left + 1) > s1.length()) {
                windowCount[s2.charAt(left) - start]--;
                left++;
            }
            if (Arrays.equals(windowCount, s1Count)) return true;
            right++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
