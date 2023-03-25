package leetcode.editor.en.Q1636;

import java.util.*;

import javafx.util.Pair;

//Given an array of integers nums, sort the array in increasing order based on 
//the frequency of the values. If multiple values have the same frequency, sort 
//them in decreasing order. 
//
// Return the sorted array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,2,2,3]
//Output: [3,1,1,2,2,2]
//Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has 
//a frequency of 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,1,3,2]
//Output: [1,3,3,2,2]
//Explanation: '2' and '3' both have a frequency of 2, so they are sorted in 
//decreasing order.
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//Output: [5,-1,4,4,-6,-6,1,1,1] 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// 👍 2274 👎 85


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.getValue() == b.getValue()){
                return Integer.compare(b.getKey(), a.getKey());
            }
            return Integer.compare(a.getValue(), b.getValue());
        });
        pq.addAll(frequency.entrySet());

        int i = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> next = pq.poll();
            int nextNumber = next.getKey();
            int repeat = next.getValue();
            int fillUntil = i + repeat;
            for (; i < fillUntil; i++) {
                nums[i] = nextNumber;
            }
        }

        return nums;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SortArrayByIncreasingFrequency extends Solution {
}