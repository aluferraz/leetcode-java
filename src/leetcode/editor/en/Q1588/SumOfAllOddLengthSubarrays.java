package leetcode.editor.en.Q1588;

import java.util.*;

import javafx.util.Pair;

//Given an array of positive integers arr, return the sum of all possible odd-
//length subarrays of arr. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,4,2,5,3]
//Output: 58
//Explanation: The odd-length subarrays of arr and their sums are:
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: 3
//Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum 
//is 3. 
//
// Example 3: 
//
// 
//Input: arr = [10,11,12]
//Output: 66
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
//
// 
// Follow up: 
//
// Could you solve this problem in O(n) time complexity? 
//
// 👍 3016 👎 226


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public int sumOddLengthSubarrays(int[] arr) {
        int[] presum = presumArray(arr);
        cache = new Integer[arr.length][2];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int sub = (i > 0 ? presum[i - 1] : 0);
            Integer[] sumForward = sumOddLengthSubarraysHelper(i, presum);
            int startingHere = (sumForward[0] - (sumForward[1] * sub));
            res += startingHere;
        }
        return res;
    }

    private int[] presumArray(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] + arr[i];
        }
        return res;
    }

    public Integer[] sumOddLengthSubarraysHelper(int i, int[] arr) {
        if (i >= arr.length) {
            return new Integer[]{0, 0};
        }
        if (cache[i][0] != null) return cache[i];
        Integer[] res = sumOddLengthSubarraysHelper(i + 2, arr);
        res[0] += arr[i];
        res[1]++;
        cache[i] = new Integer[]{res[0], res[1]};
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SumOfAllOddLengthSubarrays extends Solution {
}