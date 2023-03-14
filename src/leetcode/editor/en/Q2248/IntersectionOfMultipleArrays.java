package leetcode.editor.en.Q2248;

import java.util.*;

import javafx.util.Pair;

//Given a 2D integer array nums where nums[i] is a non-empty array of distinct 
//positive integers, return the list of integers that are present in each array of 
//nums sorted in ascending order.
//
// 
// Example 1: 
//
// 
//Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//Output: [3,4]
//Explanation: 
//The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4
//], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4]. 
//
// Example 2: 
//
// 
//Input: nums = [[1,2,3],[4,5,6]]
//Output: []
//Explanation: 
//There does not exist any integer present both in nums[0] and nums[1], so we 
//return an empty list [].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= sum(nums[i].length) <= 1000 
// 1 <= nums[i][j] <= 1000 
// All the values of nums[i] are unique. 
// 
//
// 👍 476 👎 24


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] counter = new int[1001];
        for (int[] row : nums) {
            for (int num : row) {
                counter[num]++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class IntersectionOfMultipleArrays extends Solution {
}