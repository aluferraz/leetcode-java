package leetcode.editor.en.Q1675;

import java.util.*;

import javafx.util.Pair;

//You are given an array nums of n positive integers. 
//
// You can perform two types of operations on any element of the array any 
//number of times: 
//
// 
// If the element is even, divide it by 2. 
// 
//
// 
// For example, if the array is [1,2,3,4], then you can do this operation on 
//the last element, and the array will be [1,2,3,2]. 
// 
// 
// If the element is odd, multiply it by 2.
// 
// For example, if the array is [1,2,3,4], then you can do this operation on 
//the first element, and the array will be [2,2,3,4]. 
// 
// 
//
//
// The deviation of the array is the maximum difference between any two 
//elements in the array. 
//
// Return the minimum deviation the array can have after performing some number 
//of operations. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 1
//Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], 
//then the deviation will be 3 - 2 = 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,1,5,20,3]
//Output: 3
//Explanation: You can transform the array after two operations to [4,2,5,5,3], 
//then the deviation will be 5 - 2 = 3.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,10,8]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 5 * 10⁹ 
// 
//
// 👍 2108 👎 110


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minimumDeviation(int[] nums) {
        if (nums.length == 1) return nums[0];
        TreeSet<Integer> values = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                values.add(num * 2);
            } else {
                values.add(num);
            }
        }


        int res = Integer.MAX_VALUE;
        while (values.last() % 2 == 0) { // We don't want the even to be odd again
            int max = values.last();
            values.remove(max);
            values.add(max / 2);
            if (values.size() == 1) return 0;
            res = Math.min(res, values.last() - values.first());
        }

        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimizeDeviationInArray extends Solution {
}