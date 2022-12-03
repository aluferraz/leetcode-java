package leetcode.editor.en.Q1060;

import java.util.*;

//Given an integer array nums which is sorted in ascending order and all of its 
//elements are unique and given also an integer k, return the kᵗʰ missing number 
//starting from the leftmost number of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,7,9,10], k = 1
//Output: 5
//Explanation: The first missing number is 5.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,7,9,10], k = 3
//Output: 8
//Explanation: The missing numbers are [5,6,8,...], hence the third missing 
//number is 8.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,4], k = 3
//Output: 6
//Explanation: The missing numbers are [3,5,6,7,...], hence the third missing 
//number is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 1 <= nums[i] <= 10⁷ 
// nums is sorted in ascending order, and all the elements are unique. 
// 1 <= k <= 10⁸ 
// 
//
// 
//Follow up: Can you find a logarithmic time complexity (i.e., 
//O(log(n))) solution?
//
// 👍 1434 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    public int missingElement(int[] nums, int k) {
//        int runningK = k;
//        for (int i = 1; i < nums.length ; i++) {
//            int gap = nums[i] - nums[i-1] - 1;
//            runningK -= gap;
//            if (runningK <= 0) return nums[i-1] + k;
//            k = runningK;
//        }
//        return nums[nums.length-1] +k;
//    }
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int biggestGap = nums[right] - nums[left] - (right - left -1);
            int mid = Math.floorDiv(left + (right - left), 2);
            if (biggestGap == k) return nums[left] + k;
            if (biggestGap > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] + k;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MissingElementInSortedArray extends Solution {
}