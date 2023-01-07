package leetcode.editor.en.Q118;

import java.util.*;

//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
// 
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
//
// 👍 8839 👎 290


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generateInterative(int numRows) {
        // 1ms
        List<List<Integer>> res = new ArrayList<>(numRows * 2);

        if (numRows >= 1) {
            res.add(List.of(1));
        }

        if (numRows >= 2) {
            res.add(List.of(1, 1));
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>((i + 1) * 2);
            int size = i + 1;
            List<Integer> prev = res.get(i - 1);
            for (int j = 0; j < size; j++) {
                if (j == 0 || j == size - 1) {
                    row.add(1);
                    continue;
                }
                int value = prev.get(j - 1) + prev.get(j);
                row.add(value);
            }
            res.add(row);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        pascalHelper(numRows, res);
        return res;
    }

    private List<Integer> pascalHelper(int row, List<List<Integer>> res) {
        List<Integer> elements = new ArrayList<>(row);
        elements.add(1);
        if (row == 1) {
            res.add(elements);
            return elements;
        }
        List<Integer> prev = pascalHelper(row - 1, res);
        for (int i = 1; i < row - 1; i++) {
            int value = prev.get(i - 1) + prev.get(i);
            elements.add(value);
        }
        elements.add(1);
        res.add(elements);
        return elements;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PascalsTriangle extends Solution {
}