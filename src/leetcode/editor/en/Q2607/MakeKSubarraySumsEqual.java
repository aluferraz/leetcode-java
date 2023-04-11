package leetcode.editor.en.Q2607;

import java.util.*;

import javafx.util.Pair;

//You are given a 0-indexed integer array arr and an integer k. The array arr 
//is circular. In other words, the first element of the array is the next element 
//of the last element, and the last element of the array is the previous element of 
//the first element. 
//
// You can do the following operation any number of times: 
//
// 
// Pick any element from arr and increase or decrease it by 1. 
// 
//
// Return the minimum number of operations such that the sum of each subarray 
//of length k is equal. 
//
// A subarray is a contiguous part of the array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,4,1,3], k = 2
//Output: 1
//Explanation: we can do one operation on index 1 to make its value equal to 3.
//The array after the operation is [1,3,1,3]
//- Subarray starts at index 0 is [1, 3], and its sum is 4 
//- Subarray starts at index 1 is [3, 1], and its sum is 4 
//- Subarray starts at index 2 is [1, 3], and its sum is 4 
//- Subarray starts at index 3 is [3, 1], and its sum is 4 
// 
//
// Example 2: 
//
// 
//Input: arr = [2,5,5,7], k = 3
//Output: 5
//Explanation: we can do three operations on index 0 to make its value equal to 
//5 and two operations on index 3 to make its value equal to 5.
//The array after the operations is [5,5,5,5]
//- Subarray starts at index 0 is [5, 5, 5], and its sum is 15
//- Subarray starts at index 1 is [5, 5, 5], and its sum is 15
//- Subarray starts at index 2 is [5, 5, 5], and its sum is 15
//- Subarray starts at index 3 is [5, 5, 5], and its sum is 15 
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= arr.length <= 10⁵ 
// 1 <= arr[i] <= 10⁹ 
// 
//
// 👍 260 👎 62


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Math: https://leetcode.com/problems/make-k-subarray-sums-equal/solutions/3366373/k-cycles/
    public long makeSubKSumEqual(int[] arr, int k) {
        long res = 0;
        for (int i = 0; i < k; ++i) {
            List<Integer> cycle = new ArrayList<>();
            for (int j = i; arr[j] != 0; j = (j + k) % arr.length) {
                cycle.add(arr[j]);
                arr[j] = 0;
            }
            Collections.sort(cycle);
            for (int n : cycle)
                res += Math.abs(n - cycle.get(cycle.size() / 2));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MakeKSubarraySumsEqual extends Solution {
}