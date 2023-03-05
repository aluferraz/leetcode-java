package leetcode.editor.en.Q2444;

import java.util.*;

import javafx.util.Pair;
import leetcode.editor.en.Q56.MergeIntervals;

//You are given an integer array nums and two integers minK and maxK. 
//
// A fixed-bound subarray of nums is a subarray that satisfies the following 
//conditions: 
//
// 
// The minimum value in the subarray is equal to minK. 
// The maximum value in the subarray is equal to maxK. 
// 
//
// Return the number of fixed-bound subarrays. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
//Output: 2
//Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1,1], minK = 1, maxK = 1
//Output: 10
//Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 
//possible subarrays.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i], minK, maxK <= 10⁶ 
// 
//
// 👍 1176 👎 22


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        ArrayList<Integer> subarray = new ArrayList<>();
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                res += count(subarray, minK, maxK);
                subarray.clear();
            } else {
                subarray.add(nums[i]);
            }
        }
        res += count(subarray, minK, maxK);
        return res;
    }

    private long count(ArrayList<Integer> subarray, int minK, int maxK) {
        if (subarray.size() == 0) return 0L;
        int lastMin = -1;
        int lastMax = -1;
        long res = 0L;
        for (int i = 0; i < subarray.size(); i++) {
            int current = subarray.get(i);

            if (current == minK) lastMin = i;
            if (current == maxK) lastMax = i;
            int n = Math.min(lastMin, lastMax) + 1;

            res += n;


        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class CountSubarraysWithFixedBounds extends Solution {
}