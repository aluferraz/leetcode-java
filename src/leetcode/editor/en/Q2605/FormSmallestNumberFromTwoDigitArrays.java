package leetcode.editor.en.Q2605;

import java.util.*;

import javafx.util.Pair;

//Given two arrays of unique digits nums1 and nums2, return the smallest number 
//that contains at least one digit from each array.
//
// 
// Example 1: 
//
// 
//Input: nums1 = [4,1,3], nums2 = [5,7]
//Output: 15
//Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 
//from nums2. It can be proven that 15 is the smallest number we can have.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
//Output: 3
//Explanation: The number 3 contains the digit 3 which exists in both arrays.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// All digits in each array are unique. 
// 
//
// 👍 149 👎 7


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        TreeSet<Integer> n1 = new TreeSet<>();
        TreeSet<Integer> n2 = new TreeSet<>();
        for (int n : nums1) {
            n1.add(n);
        }
        for (int n : nums2) {
            n2.add(n);
        }

        for (int n : n1) {
            if (n2.contains(n)) {
                return n;
            }
        }

        return Math.min(n1.first(), n2.first()) * 10 + Math.max(n1.first(), n2.first());

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FormSmallestNumberFromTwoDigitArrays extends Solution {
}