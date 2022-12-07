package leetcode.editor.en.Q340;

import java.util.*;

//Given a string s and an integer k, return the length of the longest substring 
//of s that contains at most k distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3. 
//
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: The substring is "aa" with length 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
//
// 👍 2522 👎 76


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
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


public class LongestSubstringWithAtMostKDistinctCharacters extends Solution {
}