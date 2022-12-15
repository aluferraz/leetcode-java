package leetcode.editor.en.Q241;

import java.util.*;

//Given a string expression of numbers and operators, return all possible 
//results from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// The test cases are generated such that the output values fit in a 32-bit 
//integer and the number of different results does not exceed 10⁴. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// All the integer values in the input expression are in the range [0, 99]. 
// 
//
// 👍 4395 👎 222


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final char MULTIPLICATION = '*';
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private char[] expressionArr;
    private String expression;
    private Set<Character> operatorSet = new HashSet<>();

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        operatorSet.add(MULTIPLICATION);
        operatorSet.add(ADDITION);
        operatorSet.add(SUBTRACTION);
        expressionArr = expression.toCharArray();
        return dfs(0, expressionArr.length - 1);
    }

    private List<Integer> dfs(int start, int end) {
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < end; i++) {
            if (operatorSet.contains(expressionArr[i])) {
                List<Integer> leftList = dfs(start, i - 1);
                List<Integer> rightList = dfs(i + 1, end);
                for (Integer num1 : leftList) {
                    for (Integer num2 : rightList) {
                        Integer totalVal = calculate(num1, num2, expressionArr[i]);
                        res.add(totalVal);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression.substring(start, end + 1)));
        }
        return res;
    }

    private Integer calculate(Integer num1, Integer num2, char operator) {
        switch (operator) {
            case MULTIPLICATION:
                return num1 * num2;
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            default:
                return -1;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class DifferentWaysToAddParentheses extends Solution {
}