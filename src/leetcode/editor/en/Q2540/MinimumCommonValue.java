package leetcode.editor.en.Q2540;

import java.util.*;

import javafx.util.Pair;

//Given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
//return the minimum integer common to both arrays. If there is no common integer 
//amongst nums1 and nums2, return -1. 
//
// Note that an integer is said to be common to nums1 and nums2 if both arrays 
//have at least one occurrence of that integer. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3], nums2 = [2,4]
//Output: 2
//Explanation: The smallest element common to both arrays is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//Output: 2
//Explanation: There are two common elements in the array 2 and 3 out of which 2
// is the smallest, so 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁹ 
// Both nums1 and nums2 are sorted in non-decreasing order. 
// 
//
// 👍 180 👎 2


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1[0] > nums2[0]) return getCommon(nums2, nums1);
        int i = 0;
        for (int num : nums1) {
            if (nums2[i] == num) return num;
            while (num > nums2[i]) {
                i++;
                if (nums2[i] == num) return num;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumCommonValue extends Solution {
}