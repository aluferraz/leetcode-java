package leetcode.editor.en.Q2640;
import java.util.*;
import javafx.util.Pair;

//We define the conversion array conver of an array arr as follows: 
//
// 
// conver[i] = arr[i] + max(arr[0..i]) where max(arr[0..i]) is the maximum 
//value of arr[j] over 0 <= j <= i. 
// 
//
// We also define the score of an array arr as the sum of the values of the 
//conversion array of arr. 
//
// Given a 0-indexed integer array nums of length n, return an array ans of 
//length n where ans[i] is the score of the prefix nums[0..i]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,7,5,10]
//Output: [4,10,24,36,56]
//Explanation: 
//For the prefix [2], the conversion array is [4] hence the score is 4
//For the prefix [2, 3], the conversion array is [4, 6] hence the score is 10
//For the prefix [2, 3, 7], the conversion array is [4, 6, 14] hence the score 
//is 24
//For the prefix [2, 3, 7, 5], the conversion array is [4, 6, 14, 12] hence the 
//score is 36
//For the prefix [2, 3, 7, 5, 10], the conversion array is [4, 6, 14, 12, 20] 
//hence the score is 56
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,2,4,8,16]
//Output: [2,4,8,16,32,64]
//Explanation: 
//For the prefix [1], the conversion array is [2] hence the score is 2
//For the prefix [1, 1], the conversion array is [2, 2] hence the score is 4
//For the prefix [1, 1, 2], the conversion array is [2, 2, 4] hence the score 
//is 8
//For the prefix [1, 1, 2, 4], the conversion array is [2, 2, 4, 8] hence the 
//score is 16
//For the prefix [1, 1, 2, 4, 8], the conversion array is [2, 2, 4, 8, 16] 
//hence the score is 32
//For the prefix [1, 1, 2, 4, 8, 16], the conversion array is [2, 2, 4, 8, 16, 3
//2] hence the score is 64
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 92 👎 3


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] max = new long[nums.length];
        long[] score = new long[nums.length];
        max[0] = nums[0];
        for(int i = 1; i < max.length; i++){
            max[i] = Math.max(max[i-1], nums[i]);
        }

        score[0] = max[0] + nums[0];

        for(int i = 1; i < score.length; i++){
            score[i] = (max[i] + nums[i]) + score[i-1];
        }
        return score;

    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class FindTheScoreOfAllPrefixesOfAnArray extends Solution {}