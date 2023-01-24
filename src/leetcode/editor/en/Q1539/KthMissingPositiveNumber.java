package leetcode.editor.en.Q1539;

import java.util.*;

import javafx.util.Pair;

//Given an array arr of positive integers sorted in a strictly increasing order,
// and an integer k. 
//
// Return the kᵗʰ positive integer that is missing from this array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5
//ᵗʰ missing positive integer is 9.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2ⁿᵈ missing 
//positive integer is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// arr[i] < arr[j] for 1 <= i < j <= arr.length 
// 
//
// 
// Follow up: 
//
// Could you solve this problem in less than O(n) complexity? 
//
// 👍 3495 👎 254


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max = arr[arr.length - 1];
        boolean[] counter = new boolean[max + 1];
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]] = true;
        }
        for (int i = 1; i < counter.length; i++) {
            if (!counter[i]) {
                k--;
            }
            if (k == 0) return i;
        }
        return max + k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KthMissingPositiveNumber extends Solution {
}