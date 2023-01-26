package leetcode.editor.en.Q804;

import java.util.*;

import javafx.util.Pair;

//International Morse Code defines a standard encoding where each letter is 
//mapped to a series of dots and dashes, as follows: 
//
// 
// 'a' maps to ".-", 
// 'b' maps to "-...", 
// 'c' maps to "-.-.", and so on. 
// 
//
// For convenience, the full table for the 26 letters of the English alphabet 
//is given below: 
//
// 
//[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--
//","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.
//."] 
//
// Given an array of strings words where each word can be written as a 
//concatenation of the Morse code of each letter. 
//
// 
// For example, "cab" can be written as "-.-..--...", which is the 
//concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the 
//transformation of a word. 
// 
//
// Return the number of different transformations among all words we have. 
//
// 
// Example 1: 
//
// 
//Input: words = ["gin","zen","gig","msg"]
//Output: 2
//Explanation: The transformation of each word is:
//"gin" -> "--...-."
//"zen" -> "--...-."
//"gig" -> "--...--."
//"msg" -> "--...--."
//There are 2 different transformations: "--...-." and "--...--.".
// 
//
// Example 2: 
//
// 
//Input: words = ["a"]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 12 
// words[i] consists of lowercase English letters. 
// 
//
// 👍 2188 👎 1430


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{
                ".-", "-...", "-.-.",
                "-..", ".", "..-.",
                "--.", "....", "..",
                ".---", "-.-", ".-..",
                "--", "-.", "---",
                ".--.", "--.-", ".-.",
                "...", "-", "..-",
                "...-", ".--",
                "-..-", "-.--",
                "--.."
        };
        HashSet<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class UniqueMorseCodeWords extends Solution {
}