package leetcode.editor.en.Q47;

import java.util.*;

//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 👍 6759 👎 117


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();
        permuteHelper(nums, 0, resultSet);
        return new ArrayList<>(resultSet);
    }

    private void permuteHelper(int[] nums, int pos, HashSet<List<Integer>> result) {
        if (pos == nums.length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            Arrays.stream(nums).forEach(permutation::add);
            result.add(permutation);
            return;
        }
        int i = pos;
        for (int j = pos; j < nums.length; j++) {
            swap(i, j, nums);
            permuteHelper(nums, i + 1, result);
            swap(i, j, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class PermutationsIi extends Solution {
}