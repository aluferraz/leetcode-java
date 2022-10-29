package leetcode.editor.en.Q977;

//Given an integer array nums sorted in non-decreasing order, return an array 
//of the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, 
//could you find an 
//O(n) solution using a different approach?
//
// 👍 6698 👎 169


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int[] result = new int[nums.length];
        if (nums.length < 2) {
            result[0] = nums[0] * nums[0];
            return result;
        }
        int pos = 0;
        while ((left + 1 < nums.length) && nums[left + 1] < 0) {
            left++;
        }
        int right = left + 1;
        while (left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[pos] = nums[left] * nums[left];
                pos++;
                left--;
            } else {
                result[pos] = nums[right] * nums[right];
                pos++;
                right++;
            }
        }
        while (left >= 0) {
            result[pos] = nums[left] * nums[left];
            pos++;
            left--;
        }
        while (right < nums.length) {
            result[pos] = nums[right] * nums[right];
            pos++;
            right++;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
