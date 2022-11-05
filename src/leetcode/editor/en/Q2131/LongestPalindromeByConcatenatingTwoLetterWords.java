package leetcode.editor.en.Q2131;

//You are given an array of strings words. Each element of words consists of 
//two lowercase English letters. 
//
// Create the longest possible palindrome by selecting some elements from words 
//and concatenating them in any order. Each element can be selected at most once. 
//
//
// Return the length of the longest palindrome that you can create. If it is 
//impossible to create any palindrome, return 0. 
//
// A palindrome is a string that reads the same forward and backward. 
//
// 
// Example 1: 
//
// 
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of 
//length 6.
//Note that "clgglc" is another longest palindrome that can be created.
// 
//
// Example 2: 
//
// 
//Input: words = ["ab","ty","yt","lc","cl","ab"]
//Output: 8
//Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt",
// of length 8.
//Note that "lcyttycl" is another longest palindrome that can be created.
// 
//
// Example 3: 
//
// 
//Input: words = ["cc","ll","xx"]
//Output: 2
//Explanation: One longest palindrome is "cc", of length 2.
//Note that "ll" is another longest palindrome that can be created, and so is 
//"xx".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] consists of lowercase English letters. 
// 
//
// 👍 1230 👎 26


import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static int longestPalindrome(String[] words) {
        return new Solution().longestPalindrome(words);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String[] words) {
        int pairs = 0;
        int selfPalindrome = 0;
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            int count = 0;
            if (wordsMap.containsKey(word)) {
                count = wordsMap.get(word);
            }
            count++;
            wordsMap.put(word, count);
        }

        for (String word : words) {
            if (!wordsMap.containsKey(word)) continue;

            decreaseCount(word, wordsMap);
            StringBuilder wordPairBuilder = new StringBuilder();
            wordPairBuilder.append(word);
            String wordPair = wordPairBuilder.reverse().toString();

            if (wordsMap.containsKey(wordPair)) {
                pairs++;
                decreaseCount(wordPair, wordsMap);
            } else {
                if (word.equals(wordPair) && selfPalindrome == 0) { // Self palindrome
                    selfPalindrome++;
                }
            }
        }
        return (pairs * 4) + (2 * selfPalindrome);
    }

    public void decreaseCount(String word, HashMap<String, Integer> wordsMap) {
        int count = wordsMap.get(word);
        count--;
        if (count == 0) {
            wordsMap.remove(word);
        } else {
            wordsMap.put(word, count);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
