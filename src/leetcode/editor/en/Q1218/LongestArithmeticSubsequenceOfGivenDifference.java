package leetcode.editor.en.Q1218;

import java.util.*;

import javafx.util.Pair;

//Given an integer array arr and an integer difference, return the length of 
//the longest subsequence in arr which is an arithmetic sequence such that the 
//difference between adjacent elements in the subsequence equals difference. 
//
// A subsequence is a sequence that can be derived from arr by deleting some or 
//no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,4], difference = 1
//Output: 4
//Explanation: The longest arithmetic subsequence is [1,2,3,4]. 
//
// Example 2: 
//
// 
//Input: arr = [1,3,5,7], difference = 1
//Output: 1
//Explanation: The longest arithmetic subsequence is any single element.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
//Output: 4
//Explanation: The longest arithmetic subsequence is [7,5,3,1].
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
//
// 👍 1403 👎 48


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[] cache;
    HashMap<Integer, TreeSet<Integer>> numsMap = new HashMap<>();

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        cache = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numsMap.computeIfAbsent(arr[i], (v) -> new TreeSet<>()).add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(longestSubsequence(i, arr, difference), ans);
        }
        return ans;
    }


    public int longestSubsequence(int i, int[] arr, int difference) {
        int ans = 1;
        if (i == arr.length) {
            return ans;
        }
        if (cache[i] != null) {
            return cache[i];
        }

        int num = arr[i];

        int target = difference + num;

        if (numsMap.containsKey(target)) {
            TreeSet<Integer> idxes = numsMap.get(target);
            Integer higher = idxes.higher(i);
            if (higher != null) {
                SortedSet<Integer> next = idxes.subSet(higher, true, idxes.last(), true);
                for (int j : next) {
                    if (j > i) {
                        ans = Math.max(longestSubsequence(j, arr, difference) + 1, ans);
                    }
                }
            }
        }

        cache[i] = ans;
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestArithmeticSubsequenceOfGivenDifference extends Solution {
}