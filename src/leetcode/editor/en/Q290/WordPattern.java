package leetcode.editor.en.Q290;
import java.util.*;

//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
//
// 👍 5582 👎 644


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        int wordsPos = 0;
        String[] matches = new String[26];
        // HashMap<Character,String> matches = new HashMap<>();
        HashSet<String> existingWords = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String target = words[wordsPos];
            int wIdx = c - 'a';
            if(matches[wIdx] != null){
                //    if(matches.containsKey(c)){
                //    if(!matches.get(c).equals(target)){
                if(!matches[wIdx].equals(target)){
                    return false;
                }

            }else{
                if(existingWords.contains(target)) return false;
                matches[wIdx] = words[wordsPos];
                // matches.put(c, words[wordsPos]);
                existingWords.add(words[wordsPos]);

            }
            wordsPos++;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class WordPattern extends Solution {}