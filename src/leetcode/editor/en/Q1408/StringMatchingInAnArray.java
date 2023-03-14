package leetcode.editor.en.Q1408;

import java.util.*;

import javafx.util.Pair;

//Given an array of string words, return all strings in words that is a 
//substring of another word. You can return the answer in any order. 
//
// A substring is a contiguous sequence of characters within a string 
//
// 
// Example 1: 
//
// 
//Input: words = ["mass","as","hero","superhero"]
//Output: ["as","hero"]
//Explanation: "as" is substring of "mass" and "hero" is substring of 
//"superhero".
//["hero","as"] is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: words = ["leetcode","et","code"]
//Output: ["et","code"]
//Explanation: "et", "code" are substring of "leetcode".
// 
//
// Example 3: 
//
// 
//Input: words = ["blue","green","bu"]
//Output: []
//Explanation: No string of words is substring of another string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 30 
// words[i] contains only lowercase English letters. 
// All the strings of words are unique. 
// 
//
// 👍 727 👎 81


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> stringMatching(String[] words) {
        TreeSet<String> res = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) continue;
                if (words[j].indexOf(words[i]) != -1) {
                    res.add(words[i]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class StringMatchingInAnArray extends Solution {
}