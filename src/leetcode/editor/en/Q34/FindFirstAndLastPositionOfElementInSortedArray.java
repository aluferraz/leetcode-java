package leetcode.editor.en.Q34;

import java.util.*;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// 👍 14653 👎 357


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int foundAt = binarySearch(nums, target, left, right);
        if (foundAt == -1) return new int[]{-1, -1};
        int rightBoundary = foundAt;
        int leftBoundary = foundAt;
        while (foundAt != -1) {

            foundAt = binarySearch(nums, target, rightBoundary + 1, right);
            if (foundAt != -1) {
                rightBoundary = foundAt;
            }

        }

        foundAt = leftBoundary;
        while (foundAt != -1) {
            foundAt = binarySearch(nums, target, left, leftBoundary - 1);
            if (foundAt != -1) {
                leftBoundary = foundAt;
            }
        }
        return new int[]{leftBoundary, rightBoundary};
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left < 0 || right >= nums.length) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // right-left is to avoid overflow;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindFirstAndLastPositionOfElementInSortedArray extends Solution {
}