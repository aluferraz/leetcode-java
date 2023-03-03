package leetcode.editor.en.Q456;

import java.util.*;

import javafx.util.Pair;

//Given an array of n integers nums, a 132 pattern is a subsequence of three 
//integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < 
//nums[j]. 
//
// Return true if there is a 132 pattern in nums, otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: false
//Explanation: There is no 132 pattern in the sequence.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,4,2]
//Output: true
//Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,3,2,0]
//Output: true
//Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
// 0] and [-1, 2, 0].
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 👍 5449 👎 309


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {

        int[] minUntil = new int[nums.length];
        Stack<Integer> monodecreasing = new Stack<>();
        for (int k = 0; k < nums.length; k++) {
            while (!monodecreasing.isEmpty() && nums[monodecreasing.peek()] < nums[k]) {
                monodecreasing.pop();
            }
            if (!monodecreasing.isEmpty()) {
                int j = monodecreasing.peek();
                if (j > 0) {
                    int i = minUntil[j - 1];
                    if (i < j && i < k && nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }

            monodecreasing.add(k);

            if (k > 0) {
                minUntil[k] = minUntil[k - 1];
                if (nums[k] < nums[minUntil[k]]) {
                    minUntil[k] = k;
                }
            }
        }


        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class One32Pattern extends Solution {
}