package leetcode.editor.en.Q540;

import java.util.*;

import javafx.util.Pair;

//You are given a sorted array consisting of only integers where every element 
//appears exactly twice, except for one element which appears exactly once. 
//
// Return the single element that appears only once. 
//
// Your solution must run in O(log n) time and O(1) space. 
//
// 
// Example 1: 
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// 
// Example 2: 
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 👍 8010 👎 126


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = Math.floorDiv((left + right), 2);
            if (mid % 2 == 1) {
                mid--;
            }
            if (mid < (nums.length - 1) && nums[mid] == nums[mid + 1]) {
                left += 2; //Next even index
            } else {
                right = mid; // Narrow the search
            }
        }
        return nums[left];

    }
// Not constant space
//    public int singleNonDuplicate(int[] nums) {
//        int idx = singleNonDuplicate(0, nums.length, nums);
//        return nums[idx];
//
//    }

//    public int singleNonDuplicate(int left, int right, int[] nums) {
//        if (!(left < right)) return -1;
//        int mid = Math.floorDiv((left + right), 2);
//        boolean found = true;
//        if (mid + 1 < nums.length) {
//            if (nums[mid + 1] == nums[mid]) found = false;
//        }
//        if (found && mid > 0) {
//            if (nums[mid - 1] == nums[mid]) found = false;
//        }
//        if (found) {
//            return mid;
//        }
//
//        return Math.max(singleNonDuplicate(left, mid, nums), singleNonDuplicate(mid + 1, right, nums));
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SingleElementInASortedArray extends Solution {
}