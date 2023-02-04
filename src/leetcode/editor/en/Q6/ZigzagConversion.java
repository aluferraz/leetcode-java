package leetcode.editor.en.Q6;

import java.util.*;

import javafx.util.Pair;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// 👍 5268 👎 11071


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        LinkedHashMap<Integer, LinkedList<Character>> zigZag = new LinkedHashMap<>();
        int row = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            zigZag.computeIfAbsent(row, (k) -> new LinkedList<>()).add(s.charAt(i));
            row += direction;
            if (row == 0) direction = 1;
            if (row == (numRows - 1)) direction = -1;

        }

        StringBuilder sb = new StringBuilder();
        int size = zigZag.size();
        for (int i = 0; i < size; i++) {
            LinkedList<Character> resultRow = zigZag.get(i);
            while (!resultRow.isEmpty()) {
                sb.append(resultRow.pollFirst());
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ZigzagConversion extends Solution {
}