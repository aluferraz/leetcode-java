package leetcode.editor.en.Q1151;

import java.util.*;

import javafx.util.Pair;

//Given a binary array data, return the minimum number of swaps required to 
//group all 1’s present in the array together in any place in the array. 
//
// 
// Example 1: 
//
// 
//Input: data = [1,0,1,0,1]
//Output: 1
//Explanation: There are 3 ways to group all 1's together:
//[1,1,1,0,0] using 1 swap.
//[0,1,1,1,0] using 2 swaps.
//[0,0,1,1,1] using 1 swap.
//The minimum is 1.
// 
//
// Example 2: 
//
// 
//Input: data = [0,0,0,1,0]
//Output: 0
//Explanation: Since there is only one 1 in the array, no swaps are needed.
// 
//
// Example 3: 
//
// 
//Input: data = [1,0,1,0,1,0,0,1,1,0,1]
//Output: 3
//Explanation: One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1
//].
// 
//
// 
// Constraints: 
//
// 
// 1 <= data.length <= 10⁵ 
// data[i] is either 0 or 1. 
// 
//
// 👍 1077 👎 14


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwaps(int[] data) {
        int[] presum = new int[data.length];
        presum[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            presum[i] = presum[i - 1] + data[i];
        }
        int ones = presum[presum.length - 1];
        int left = 0;
        int swaps = data.length;

        for (int right = 0; right < data.length; right++) {
            if ((right - left + 1) < ones) continue;
            if ((right - left + 1) > ones) {
                left++;
            }
            int zerosInWindow = ones - (presum[right] - (left > 0 ? presum[left - 1] : 0));
            swaps = Math.min(swaps, zerosInWindow);
        }
        return swaps;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumSwapsToGroupAll1sTogether extends Solution {
}