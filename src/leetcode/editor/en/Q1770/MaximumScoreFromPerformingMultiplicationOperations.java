package leetcode.editor.en.Q1770;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashMap<Pair<Integer, Pair<Integer, Integer>>, Integer> cache;

    public int maximumScore(int[] nums, int[] multipliers) {
        cache = new HashMap<>();
        return maximumScore(0, nums.length - 1, 0, nums, multipliers);
    }

    private int maximumScore(int start, int end, int op, int[] nums, int[] multipliers) {
        if (op == multipliers.length) return 0;

        Pair<Integer, Pair<Integer, Integer>> cacheKey = new Pair<>(op, new Pair<>(start, end));
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        int chooseStart = (nums[start] * multipliers[op]) + maximumScore(start + 1, end, op + 1, nums, multipliers);
        int chooseEnd = (nums[end] * multipliers[op]) + maximumScore(start, end - 1, op + 1, nums, multipliers);

        int ans = Math.max(chooseStart, chooseEnd);
        cache.put(cacheKey, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumScoreFromPerformingMultiplicationOperations extends Solution {
}