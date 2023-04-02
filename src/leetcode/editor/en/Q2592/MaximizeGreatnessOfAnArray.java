package leetcode.editor.en.Q2592;

import java.util.*;

import javafx.util.Pair;

//You are given a 0-indexed integer array nums. You are allowed to permute nums 
//into a new array perm of your choosing. 
//
// We define the greatness of nums be the number of indices 0 <= i < nums.
//length for which perm[i] > nums[i]. 
//
// Return the maximum possible greatness you can achieve after permuting nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,2,1,3,1]
//Output: 4
//Explanation: One of the optimal rearrangements is perm = [2,5,1,3,3,1,1].
//At indices = 0, 1, 3, and 4, perm[i] > nums[i]. Hence, we return 4. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We can prove the optimal perm is [2,3,4,1].
//At indices = 0, 1, and 2, perm[i] > nums[i]. Hence, we return 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 242 👎 5


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeGreatness(int[] nums) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int[] perm = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer higher = counter.higherKey(num);
            if (higher == null) {
                perm[i] = counter.firstKey();
            } else {
                perm[i] = higher;
            }
            int remaining = counter.get(perm[i]);
            remaining--;
            if (remaining == 0) counter.remove(perm[i]);
            else counter.put(perm[i], remaining);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (perm[i] > nums[i]) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximizeGreatnessOfAnArray extends Solution {
}