package leetcode.editor.en.Q75;

import java.util.*;

import javafx.util.Pair;

//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
//
// 👍 13583 👎 495


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length - 1);
    }

    public void sortColors(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            if (nums[left] > pivot && nums[right] < pivot) {
                swap(left, right, nums);
            }
            if (nums[left] <= pivot) {
                left++;
            }
            if (nums[right] >= pivot) {
                right--;
            }
        }

        swap(start, right, nums);
        boolean leftIsSmaller = right - 1 - start < end - (right + 1);
        if (leftIsSmaller) {
            sortColors(nums, start, right - 1);
            sortColors(nums, right + 1, end);
        } else {
            sortColors(nums, right + 1, end);
            sortColors(nums, start, right - 1);
        }

    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class SortColors extends Solution {
}