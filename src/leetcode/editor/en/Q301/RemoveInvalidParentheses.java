package leetcode.editor.en.Q301;

import java.util.*;

//Given a string s that contains parentheses and letters, remove the minimum 
//number of invalid parentheses to make the input string valid. 
//
// Return all the possible results. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "()())()"
//Output: ["(())()","()()()"]
// 
//
// Example 2: 
//
// 
//Input: s = "(a)())()"
//Output: ["(a())()","(a)()()"]
// 
//
// Example 3: 
//
// 
//Input: s = ")("
//Output: [""]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 25 
// s consists of lowercase English letters and parentheses '(' and ')'. 
// There will be at most 20 parentheses in s. 
// 
//
// 👍 5234 👎 256


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashSet<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        process(s, '(', ')');
//        process(new StringBuilder(s).reverse().toString(), ')', '(');
        if (result.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ')' && s.charAt(i) != '(') sb.append(s.charAt(i));
            }
            result.add(sb.toString());
        }
        return new ArrayList<>(result);
    }

    private void process(String s, char positive, char negative) {
        if (result.contains(s)) return;
        int counter = 0;
        LinkedList<Integer> idxes = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == positive) {
                counter++;
            }
            if (c == negative) {
                idxes.add(i);
                counter--;
            }
            if (counter < 0) {
                while (!idxes.isEmpty()) {
                    int idx = idxes.pollFirst();
                    if (!idxes.isEmpty() && idxes.peekFirst() == idx + 1) {
                        idxes.pollFirst();
                    }
                    String newStr = s.substring(0, idx) + s.substring(idx + 1);
                    process(newStr, positive, negative);
                }
                return;
            }
        }
        if (counter == 0) {
            if (positive == '(') result.add(s);
            else result.add(new StringBuilder(s).reverse().toString());
        } else {
            String newStr = new StringBuilder(s).reverse().toString();
            process(newStr, negative, positive);
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)


public class RemoveInvalidParentheses extends Solution {
}