package leetcode.editor.en.Q150;

import java.util.*;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, and /. Each operand may be an integer or 
//another expression. 
//
// Note that division between two integers should truncate toward zero. 
//
// It is guaranteed that the given RPN expression is always valid. That means 
//the expression would always evaluate to a result, and there will not be any 
//division by zero operation. 
//
// 
// Example 1: 
//
// 
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
//
// 
// Constraints: 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the 
//range [-200, 200]. 
// 
//
// 👍 4727 👎 790


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> expressions = new LinkedList<>();
        for (String token : tokens) {
            int op1;
            int op2;
            switch (token) {
                case "+":
                    op2 = expressions.pop();
                    op1 = expressions.pop();
                    expressions.push(op1 + op2);
                    break;
                case "-":
                    op2 = expressions.pop();
                    op1 = expressions.pop();
                    expressions.push(op1 - op2);
                    break;
                case "*":
                    op2 = expressions.pop();
                    op1 = expressions.pop();
                    expressions.push(op1 * op2);
                    break;
                case "/":
                    op2 = expressions.pop();
                    op1 = expressions.pop();
                    double result = op1 / op2;
                    if (result < 0) {
                        result = Math.ceil(result);
                    }
                    result = Math.floor(result);
                    expressions.push((int) result);
                    break;
                default:
                    expressions.push(Integer.parseInt(token));
            }
        }
        return expressions.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class EvaluateReversePolishNotation extends Solution {
}