package leetcode.editor.en.Q1498;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;

//You are given an array of integers nums and an integer target. 
//
// Return the number of non-empty subsequences of nums such that the sum of the 
//minimum and maximum element on it is less or equal to target. Since the answer 
//may be too large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,5,6,7], target = 9
//Output: 4
//Explanation: There are 4 subsequences that satisfy the condition.
//[3] -> Min value + max value <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// Example 2: 
//
// 
//Input: nums = [3,3,6,8], target = 10
//Output: 6
//Explanation: There are 6 subsequences that satisfy the condition. (nums can 
//have repeated numbers).
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
// 
//
// Example 3: 
//
// 
//Input: nums = [2,3,3,4,6,7], target = 12
//Output: 61
//Explanation: There are 63 non-empty subsequences, two of them do not satisfy 
//the condition ([6,7], [7]).
//Number of valid subsequences (63 - 2 = 61).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= target <= 10⁶ 
// 
//
// 👍 2570 👎 229


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        BigInteger ans = new BigInteger("0");
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }
            ans = ans.add(new BigInteger("2").pow((right - left)));
            left++;

        }
        return ans.mod(new BigInteger("1000000007")).intValue();

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition extends Solution {
}