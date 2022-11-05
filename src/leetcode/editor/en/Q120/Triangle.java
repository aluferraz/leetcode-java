package leetcode.editor.en.Q120;

import java.util.*;

//Given a triangle array, return the minimum path sum from top to bottom. 
//
// For each step, you may move to an adjacent number of the row below. More 
//formally, if you are on index i on the current row, you may move to either index i 
//or index i + 1 on the next row. 
//
// 
// Example 1: 
//
// 
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined 
//above).
// 
//
// Example 2: 
//
// 
//Input: triangle = [[-10]]
//Output: -10
// 
//
// 
// Constraints: 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//Follow up: Could you do this using only 
//O(n) extra space, where 
//n is the total number of rows in the triangle?
//
// 👍 7152 👎 450


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashMap<String, Integer> cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new HashMap<>();
        return minimumAtPath(0, 0, triangle);
    }

    public int minimumAtPath(int i, int rowNumber, List<List<Integer>> triangle) {
        String cacheKey = i + "-" + rowNumber;
        if (this.cache.containsKey(cacheKey)) {
            return this.cache.get(cacheKey);
        }
        if (rowNumber == triangle.size()) {
            return 0;
        }

        List<Integer> row = triangle.get(rowNumber);
        int currentVal = row.get(i);
        int minimumAtLeft = minimumAtPath(i, rowNumber + 1, triangle);
        int minimumAtRight = minimumAtPath(i + 1, rowNumber + 1, triangle);
        int minimumResult = currentVal + Math.min(minimumAtLeft, minimumAtRight);
        this.cache.put(cacheKey, minimumResult);
        return minimumResult;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class Triangle extends Solution {
}