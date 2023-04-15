package leetcode.editor.en.Q2404;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return the most frequent even element. 
//
// If there is a tie, return the smallest one. If there is no such element, 
//return -1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,2,4,4,1]
//Output: 2
//Explanation:
//The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
//We return the smallest one, which is 2. 
//
// Example 2: 
//
// 
//Input: nums = [4,4,4,9,2,4]
//Output: 4
//Explanation: 4 is the even element appears the most.
// 
//
// Example 3: 
//
// 
//Input: nums = [29,47,21,41,13,37,25,7]
//Output: -1
//Explanation: There is no even element.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2000 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 👍 608 👎 20


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> evenCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 0) {
                evenCount.put(num, evenCount.getOrDefault(num, 0) + 1);
            }
        }
        int res = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> kv : evenCount.entrySet()) {
            int num = kv.getKey();
            int frequency = kv.getValue();

            if ((frequency == count && num < res) || frequency > count) {
                res = num;
                count = frequency;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MostFrequentEvenElement extends Solution {
}