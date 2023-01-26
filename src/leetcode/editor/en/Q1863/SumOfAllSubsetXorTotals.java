package leetcode.editor.en.Q1863;

import java.util.*;

import javafx.util.Pair;

//The XOR total of an array is defined as the bitwise XOR of all its elements, 
//or 0 if the array is empty. 
//
// 
// For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1. 
// 
//
// Given an array nums, return the sum of all XOR totals for every subset of 
//nums. 
//
// Note: Subsets with the same elements should be counted multiple times. 
//
// An array a is a subset of an array b if a can be obtained from b by deleting 
//some (possibly zero) elements of b. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3]
//Output: 6
//Explanation: The 4 subsets of [1,3] are:
//- The empty subset has an XOR total of 0.
//- [1] has an XOR total of 1.
//- [3] has an XOR total of 3.
//- [1,3] has an XOR total of 1 XOR 3 = 2.
//0 + 1 + 3 + 2 = 6
// 
//
// Example 2: 
//
// 
//Input: nums = [5,1,6]
//Output: 28
//Explanation: The 8 subsets of [5,1,6] are:
//- The empty subset has an XOR total of 0.
//- [5] has an XOR total of 5.
//- [1] has an XOR total of 1.
//- [6] has an XOR total of 6.
//- [5,1] has an XOR total of 5 XOR 1 = 4.
//- [5,6] has an XOR total of 5 XOR 6 = 3.
//- [1,6] has an XOR total of 1 XOR 6 = 7.
//- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
//0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
// 
//
// Example 3: 
//
// 
//Input: nums = [3,4,5,6,7,8]
//Output: 480
//Explanation: The sum of all XOR totals for every subset is 480.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 12 
// 1 <= nums[i] <= 20 
// 
//
// 👍 1170 👎 104


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        traverse(nums, 0, 0);
        return sum;
    }

    private void traverse(int[] nums, int index, int cur) {
        for (int i = index; i < nums.length; i++) {
            int curVal = cur ^ nums[i];
            sum += curVal;
            traverse(nums, i + 1, curVal);
        }
    }
//    public int subsetXORSum(int[] nums) {
//        int res = 0;
//        ArrayList<List<Integer>> subsets = new ArrayList<>();
//
//        for (int num : nums) {
//            int size = subsets.size();
//            for (int j = 0; j < size; j++) {
//                List<Integer> prev = subsets.get(j);
//                ArrayList<Integer> newArr = new ArrayList<>(prev);
//                newArr.add(num);
//                subsets.add(newArr);
//                int xor = 0;
//                for (Integer seqNum : newArr) {
//                    xor ^= seqNum;
//                }
//                res += xor;
//            }
//            subsets.add(new ArrayList<>(List.of(num)));
//            res += num;
//
//        }
//
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SumOfAllSubsetXorTotals extends Solution {
}