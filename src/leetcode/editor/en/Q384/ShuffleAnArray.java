package leetcode.editor.en.Q384;

import java.util.*;

//Given an integer array nums, design an algorithm to randomly shuffle the 
//array. All permutations of the array should be equally likely as a result of the 
//shuffling. 
//
// Implement the Solution class: 
//
// 
// Solution(int[] nums) Initializes the object with the integer array nums. 
// int[] reset() Resets the array to its original configuration and returns it. 
//
// int[] shuffle() Returns a random shuffling of the array. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//Output
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
//                       // Any permutation of [1,2,3] must be equally likely 
//to be returned.
//                       // Example: return [3, 1, 2]
//solution.reset();      // Resets the array back to its original configuration 
//[1,2,3]. Return [1, 2, 3]
//solution.shuffle();    // Returns the random shuffling of array [1,2,3]. 
//Example: return [1, 3, 2]
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50 
// -10⁶ <= nums[i] <= 10⁶ 
// All the elements of nums are unique. 
// At most 10⁴ calls in total will be made to reset and shuffle. 
// 
//
// 👍 1016 👎 794


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] original;
    Integer[] shuffled;

    public Solution(int[] nums) {
        original = new int[nums.length];
        shuffled = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
            shuffled[i] = nums[i];
        }
    }

    public int[] reset() {
        return original;
    }

    public Integer[] shuffle() {
        Arrays.sort(shuffled, (o1, o2) -> {
            int result = new Random().nextInt(3);
            if (result == 2) return -1;
            return result;
        });
        return shuffled;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)


public class ShuffleAnArray extends Solution {
}