package leetcode.editor.en.Q438;

import java.util.*;

//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// 👍 9132 👎 282


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int mod = 7919;
    int[] cache;

    public List<Integer> findAnagrams(String s, String p) {
        cache = new int[26];
        for (int i = 'a'; i <= 'z'; i++) {
            cache[i - 'a'] = -1;
            cache[i - 'a'] = hashChar((char) i, 0);
        }
        //Rabin-Karp
        List<Integer> result = new Stack<>();
        if (s.length() < p.length()) return result;
        int hashToBeFound = hashString(p);
        int left = 0;
        int right = 0;

        int windowHash = 0;
        while (right < s.length()) {
            windowHash += hashChar(s.charAt(right), p.length() - (right - left + 1));
            if ((right - left + 1) < p.length()) {
                right++;
                continue;
            } else if ((right - left + 1) > p.length()) {
                windowHash -= hashChar(s.charAt(left), p.length() - (1));
                left++;
            }
            if (windowHash == hashToBeFound) result.add(left);
            right++;
        }
        return result;

    }

    private int hashString(String s) {
        int hash = 0;
        for (int i = 1; i <= s.length(); i++) {
            hash += hashChar(s.charAt(i - 1), s.length() - i);
        }
        return hash;
    }


    private int hashChar(char c, int idx) {
//        return (c - 'a') + 1 % 113;
        //using the idx of the string is a collision safe hash,
        // but to search for anagrams, we take benefit of the collissions
        // so we are using the idx of the letter
        int charCode = (c - 'a') + 1 % mod;
        if (cache[charCode - 1] != -1) return cache[charCode - 1];
        int base = 26;
        idx = (('z' - 'a') - (c - 'a'));

        int multiplier = safePow(base, idx);
        cache[charCode - 1] = (charCode * multiplier) % mod;
        return cache[charCode - 1];
    }

    private int safePow(int base, int raise) {

        int n = 1;
        for (int i = 0; i < raise; i++) {
            n = (n * base) % mod;
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindAllAnagramsInAString extends Solution {
}