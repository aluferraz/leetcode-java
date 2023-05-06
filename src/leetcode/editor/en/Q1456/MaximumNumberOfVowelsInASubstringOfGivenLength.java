package leetcode.editor.en.Q1456;

import java.util.*;

import javafx.util.Pair;

//Given a string s and an integer k, return the maximum number of vowel letters 
//in any substring of s with length k. 
//
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'. 
//
// 
// Example 1: 
//
// 
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
// 
//
// Example 2: 
//
// 
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
// 
//
// Example 3: 
//
// 
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 1 <= k <= s.length 
// 
//
// 👍 1729 👎 64


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        LinkedList<Character> window = new LinkedList<>();
        int max = 0;
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) vowels++;
            window.add(c);
            if (window.size() < k) {
                continue;
            }
            if (window.size() > k) {
                if (isVowel(window.pollFirst())) vowels--;
            }
            max = Math.max(max, vowels);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumNumberOfVowelsInASubstringOfGivenLength extends Solution {
}