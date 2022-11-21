package leetcode.editor.en.Q40;

import java.util.*;

//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 👍 7326 👎 179


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> result = new HashSet<>();

        combinationsSumHelper(
                candidates,
                target,
                0,
                0,
                new Stack<>(),
                result
        );
        return new ArrayList<>(result);
    }

    private boolean combinationsSumHelper(int[] candidates,
                                          int target,
                                          int index,
                                          int runningSum,
                                          Stack<Integer> numbers,
                                          HashSet<List<Integer>> result
    ) {

        if (runningSum == target) {
            result.add(new ArrayList<>(numbers));
            return true;
        }
        if (index == candidates.length) return true;
        if (runningSum > target) return false;
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[index]) continue;
            numbers.push(candidates[i]);
            boolean shouldContinue = combinationsSumHelper(
                    candidates,
                    target,
                    i + 1,
                    runningSum + numbers.peek(),
                    numbers,
                    result
            );
            numbers.pop();
            if (!shouldContinue) break;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CombinationSumIi extends Solution {
}