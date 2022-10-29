package leetcode.editor.en.Q189;

//Given an array, rotate the array to the right by k steps, where k is non-
//negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three 
//different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 👍 11875 👎 1427


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int idx = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx = (i + k) % nums.length;
            result[idx] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
