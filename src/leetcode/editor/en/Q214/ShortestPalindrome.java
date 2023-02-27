package leetcode.editor.en.Q214;

import java.util.*;

//You are given a string s. You can convert s to a palindrome by adding 
//characters in front of it. 
//
// Return the shortest palindrome you can find by performing this 
//transformation. 
//
// 
// Example 1: 
// Input: s = "aacecaaa"
//Output: "aaacecaaa"
// 
// Example 2: 
// Input: s = "abcd"
//Output: "dcbabcd"
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of lowercase English letters only. 
// 
//
// 👍 3028 👎 213


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {

        /**
         * We want to find the longest palindrome at the beginning of the string.
         * once we have that, the remaining must be reversed and prepended to the string.
         */

        //Naive approach
//        int max = 0;
//        for (int i = 1; i <= s.length(); i++) {
//            if (isPalindrome(s.substring(0, i))) {
//                max = i;
//            }
//        }

//        String longestPalindrome = s.substring(0, max);
//        String nonPalindrome = s.substring(max);
//        // We must make nonPalidrome a palindrome
//
//
//        return new StringBuilder(nonPalindrome).reverse() + longestPalindrome + nonPalindrome;
        /*
        *
        * https://www.youtube.com/watch?v=c4akpqTwE5g
        *
        * */

        //https://www.youtube.com/watch?v=c4akpqTwE5g
        String reversed = new StringBuilder(s).reverse().toString();
        String forcePalindrome = s + "#" + reversed;
        int[] kmpArray = buildKMPArray(forcePalindrome);

        int differsAt = kmpArray[kmpArray.length - 1] + 1;

        // "banana"
        // "banana ananab"
        // "ananab banana"
        // "ANANAb bANANA"
        // Shortest will be banana + ("ananab" - "anana" ) = "bananab"
        String prefix = reversed.substring(0, (reversed.length() - (differsAt)));
        return prefix + s;
    }

    private int[] buildKMPArray(String s) {
        int[] pattern = new int[s.length()];
        Arrays.fill(pattern, -1);
        int j = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                pattern[i] = j;
                j++;
                i++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestPalindrome extends Solution {
}