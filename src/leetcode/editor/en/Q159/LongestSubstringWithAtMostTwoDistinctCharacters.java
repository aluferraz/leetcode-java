package leetcode.editor.en.Q159;

import java.util.*;

//Given a string s, return the length of the longest substring that contains at 
//most two distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba"
//Output: 3
//Explanation: The substring is "ece" which its length is 3.
// 
//
// Example 2: 
//
// 
//Input: s = "ccaabbb"
//Output: 5
//Explanation: The substring is "aabbb" which its length is 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of English letters. 
// 
//
// 👍 1973 👎 31


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int k = 2;
        //HashMap<Character, Integer> distinct = new HashMap<>();
        int[] letters = new int[58];
        int result = 0;
        int distinct = 0;
        while (right < s.length()) {
            while (right < s.length() && distinct <= k) {
                int rightIdx = s.charAt(right) - 'A';
                if (letters[rightIdx] == 0) {
                    distinct++; //new letter
                }
                letters[rightIdx]++;
                if (distinct <= k) {
                    result = Math.max(result, right - left + 1);
                }
                right++;
                while (left <= right && distinct > k) {
                    int leftIdx = s.charAt(left) - 'A';
                    letters[leftIdx]--;
                    if (letters[leftIdx] == 0) {
                        distinct--;
                    }
                    left++;
                }
            }
            right++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestSubstringWithAtMostTwoDistinctCharacters extends Solution {
}