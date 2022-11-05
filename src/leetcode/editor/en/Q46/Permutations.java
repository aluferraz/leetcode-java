package leetcode.editor.en.Q46;

//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// 👍 13558 👎 226


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        //for (int i = 0; i < nums.length; i++) {
        permuteRec(result, 0, nums);
        //}
        return result;
    }

    private void permuteRec(List<List<Integer>> result, int start, int[] nums) {
        if (start == nums.length) {
            LinkedList<Integer> row = new LinkedList<>();
            for (int num : nums) {
                row.add(num);
            }
            result.add(row);
            return;
        }
        for (int j = start; j < nums.length; j++) {
            swap(start, j, nums);
            permuteRec(result, start + 1, nums);
            swap(start, j, nums);
        }

    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class Permutations extends Solution {
}