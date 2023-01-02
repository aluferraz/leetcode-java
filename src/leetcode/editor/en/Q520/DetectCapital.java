package leetcode.editor.en.Q520;

//We define the usage of capitals in a word to be right when one of the
//following cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//
// Given a string word, return true if the usage of capitals in it is right. 
//
// 
// Example 1: 
// Input: word = "USA"
//Output: true
// 
// Example 2: 
// Input: word = "FlaG"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= word.length <= 100 
// word consists of lowercase and uppercase English letters. 
// 
//
// 👍 2384 👎 406


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            }
        }
        return uppercaseCount == 0 || uppercaseCount == word.length() || (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DetectCapital extends Solution {
}