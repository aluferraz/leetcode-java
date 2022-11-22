package leetcode.editor.en.Q17;

import java.util.*;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// 👍 13291 👎 779


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Character, Character[]> digitsMap = new HashMap<>();

    Solution() {
        this.digitsMap = new HashMap<>();
        this.digitsMap.put('2', new Character[]{'a', 'b', 'c'});
        this.digitsMap.put('3', new Character[]{'d', 'e', 'f'});
        this.digitsMap.put('4', new Character[]{'g', 'h', 'i'});
        this.digitsMap.put('5', new Character[]{'j', 'k', 'l'});
        this.digitsMap.put('6', new Character[]{'m', 'n', 'o'});
        this.digitsMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        this.digitsMap.put('8', new Character[]{'t', 'u', 'v'});
        this.digitsMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        letterCombinations(digits, 0, new Stack<>(), result);
        return result;
    }

    public void letterCombinations(String digits, int idx, Stack<Character> combination, List<String> result) {
        if (idx == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character character : combination) {
                sb.append(character);
            }
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(idx);
        Character[] possibleLetters = this.digitsMap.get(digit);
        for (Character letter : possibleLetters) {
            combination.push(letter);
            letterCombinations(digits, idx + 1, combination, result);
            combination.pop();
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LetterCombinationsOfAPhoneNumber extends Solution {
}