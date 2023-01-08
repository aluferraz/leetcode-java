package leetcode.editor.en.Q1078;

import java.util.*;

//Given two strings first and second, consider occurrences in some text of the 
//form "first second third", where second comes immediately after first, and third 
//comes immediately after second. 
//
// Return an array of all the words third for each occurrence of "first second 
//third". 
//
// 
// Example 1: 
// Input: text = "alice is a good girl she is a good student", first = "a", 
//second = "good"
//Output: ["girl","student"]
// 
// Example 2: 
// Input: text = "we will we will rock you", first = "we", second = "will"
//Output: ["we","rock"]
// 
// 
// Constraints: 
//
// 
// 1 <= text.length <= 1000 
// text consists of lowercase English letters and spaces. 
// All the words in text a separated by a single space. 
// 1 <= first.length, second.length <= 10 
// first and second consist of lowercase English letters. 
// 
//
// 👍 395 👎 318


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        LinkedList<String> res = new LinkedList<>();
        for (int i = 1; i < words.length - 1; i++) {
            if (words[i].equals(second) && words[i - 1].equals(first)) {
                res.addFirst(words[i + 1]);
            }
        }
        String[] result = new String[res.size()];
        int i = 0;
        while (res.size() > 0) {
            result[i] = res.pop();
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class OccurrencesAfterBigram extends Solution {
}