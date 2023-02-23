package leetcode.editor.en.Q1427;

import java.util.*;

import javafx.util.Pair;

//You are given a string s containing lowercase English letters, and a matrix 
//shift, where shift[i] = [directioni, amounti]: 
//
// 
// directioni can be 0 (for left shift) or 1 (for right shift). 
// amounti is the amount by which string s is to be shifted. 
// A left shift by 1 means remove the first character of s and append it to the 
//end. 
// Similarly, a right shift by 1 means remove the last character of s and add 
//it to the beginning. 
// 
//
// Return the final string after all operations. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc", shift = [[0,1],[1,2]]
//Output: "cab"
//Explanation: 
//[0,1] means shift to left by 1. "abc" -> "bca"
//[1,2] means shift to right by 2. "bca" -> "cab" 
//
// Example 2: 
//
// 
//Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
//Output: "efgabcd"
//Explanation:  
//[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
//[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
//[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
//[1,3] means shift to right by 3. "abcdefg" -> "efgabcd" 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s only contains lower case English letters. 
// 1 <= shift.length <= 100 
// shift[i].length == 2 
// directioni is either 0 or 1. 
// 0 <= amounti <= 100 
// 
//
// 👍 184 👎 4


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            res.add(s.charAt(i));
        }
        for (int[] op : shift) {
            int total = (op[1] % s.length());
            for (int i = 0; i < total; i++) {
                if (op[0] == 0) {
                    res.add(res.pollFirst());
                } else {
                    res.addFirst(res.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.poll());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PerformStringShifts extends Solution {
}