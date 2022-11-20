package leetcode.editor.en.Q90;

import java.util.*;

//Given an integer array nums that may contain duplicates, return all possible 
//subsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// 👍 7009 👎 196


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> exisiting = new HashSet<>();
        result.add(new ArrayList<>());
        exisiting.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> prev = result.get(i);
                List<Integer> newList = new ArrayList<>(prev);
                newList.add(num);
                if (!exisiting.contains(newList)) {
                    exisiting.add(newList);
                    result.add(newList);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SubsetsIi extends Solution {
}