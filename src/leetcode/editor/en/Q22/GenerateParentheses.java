package leetcode.editor.en.Q22;

import java.util.*;

//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// 👍 16005 👎 618


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, new Stack<>(), result);
        return result;
    }

    private void generateParenthesis(int openRemaining, int closingRemaining, Stack<Character> combination, List<String> result) {
        if (openRemaining == 0 && 0 == closingRemaining) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> validStack = new Stack<>();
            for (Character character : combination) {
                if (character == '(') validStack.push(character);
                else if (validStack.size() > 0) validStack.pop();
                sb.append(character);
            }
            if (validStack.size() == 0) result.add(sb.toString());
            return;
        }
        if (openRemaining > 0) {
            combination.push('(');
            generateParenthesis(openRemaining - 1, closingRemaining, combination, result);
            combination.pop();
        }
        if (closingRemaining > 0) {
            combination.push(')');
            generateParenthesis(openRemaining, closingRemaining - 1, combination, result);
            combination.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class GenerateParentheses extends Solution {
}