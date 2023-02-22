package leetcode.editor.en.Q454;

import java.util.*;

import javafx.util.Pair;

//Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, 
//return the number of tuples (i, j, k, l) such that: 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//Output: 2
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// 👍 4377 👎 125


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> nums12 = combineArrays(nums1, nums2);
        HashMap<Integer, Integer> nums34 = combineArrays(nums3, nums4);
        int res = 0;
        for (Map.Entry<Integer, Integer> kv : nums12.entrySet()) {
            int complement = -kv.getKey();
            if (nums34.containsKey(complement)) {
                res += (kv.getValue() * nums34.get(complement));
            }
        }
        return res;
    }

    private HashMap<Integer, Integer> combineArrays(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums12 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                nums12.put(sum, nums12.getOrDefault(sum, 0) + 1);
            }
        }
        return nums12;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FourSumIi extends Solution {
}