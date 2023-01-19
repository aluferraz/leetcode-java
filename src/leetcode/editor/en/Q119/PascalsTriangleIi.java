package leetcode.editor.en.Q119;

import java.util.*;

import javafx.util.Pair;

//Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the 
//Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
// 
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// 
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
// 
// Example 3: 
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra 
//space? 
//
// 👍 3464 👎 292


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        List<Integer> prev = getRow(rowIndex - 1);
        row.add(1);
        for (int i = 1; i < rowIndex; i++) {
            row.add(prev.get(i - 1) + prev.get(i));
        }
        row.add(1);
        return row;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PascalsTriangleIi extends Solution {
}