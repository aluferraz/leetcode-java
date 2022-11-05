package leetcode.editor.en.Q77;

//Given two integers n and k, return all possible combinations of k numbers 
//chosen from the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
//be the same combination.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 👍 5257 👎 166


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        fillList(result, new LinkedList<>(), 1, n, k);
        return result;
    }

    public void fillList(List<List<Integer>> result, LinkedList<Integer> row, int start, int n, int k) {
        if (row.size() == k) {
            result.add(new LinkedList<>(row));
            return;
        }
        for (int i = start; i <= n; i++) {
            row.add(i);
            fillList(result, row, i + 1, n, k);
            row.removeLast();
        }
    }

}

//leetcode submit region end(Prohibit modification and deletion)
public class Combinations extends Solution {
}