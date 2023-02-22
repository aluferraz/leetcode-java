package leetcode.editor.en.Q448;

import java.util.*;

import javafx.util.Pair;

//Given an array nums of n integers where nums[i] is in the range [1, n], 
//return an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// 
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may 
//assume the returned list does not count as extra space. 
//
// 👍 8067 👎 429


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(i + 1);
        }
        for (int num : nums) {
            res.remove(num);
        }
        return new ArrayList<>(res);

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindAllNumbersDisappearedInAnArray extends Solution {
}