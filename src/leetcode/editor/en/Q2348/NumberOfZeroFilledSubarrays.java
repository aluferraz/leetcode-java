package leetcode.editor.en.Q2348;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return the number of subarrays filled with 0. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,0,0,2,0,0,4]
//Output: 6
//Explanation: 
//There are 4 occurrences of [0] as a subarray.
//There are 2 occurrences of [0,0] as a subarray.
//There is no occurrence of a subarray with a size more than 2 filled with 0. 
//Therefore, we return 6. 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0,2,0,0]
//Output: 9
//Explanation:
//There are 5 occurrences of [0] as a subarray.
//There are 3 occurrences of [0,0] as a subarray.
//There is 1 occurrence of [0,0,0] as a subarray.
//There is no occurrence of a subarray with a size more than 3 filled with 0. 
//Therefore, we return 9.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,10,2019]
//Output: 0
//Explanation: There is no subarray filled with 0. Therefore, we return 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 👍 1038 👎 39


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            int j = i;
            long subarrays = 0L;
            while (i < nums.length && nums[i] == 0) {
                //Number of arrays that contains i:
                // (n-i) + i * (n-i) == (n-i)*(i + 1);
                int len = (i - j + 1);
                int pos = (i - j);
                long subarraysCount = (len - pos) + ((long) (len - pos) * pos);
                subarrays += subarraysCount;
                i++;
            }
            res += subarrays;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfZeroFilledSubarrays extends Solution {
}