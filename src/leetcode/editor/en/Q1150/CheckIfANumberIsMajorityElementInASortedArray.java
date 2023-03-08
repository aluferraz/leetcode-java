package leetcode.editor.en.Q1150;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums sorted in non-decreasing order and an integer 
//target, return true if target is a majority element, or false otherwise. 
//
// A majority element in an array nums is an element that appears more than 
//nums.length / 2 times in the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
//Output: true
//Explanation: The value 5 appears 5 times and the length of the array is 9.
//Thus, 5 is a majority element because 5 > 9/2 is true.
// 
//
// Example 2: 
//
// 
//Input: nums = [10,100,101,101], target = 101
//Output: false
//Explanation: The value 101 appears 2 times and the length of the array is 4.
//Thus, 101 is not a majority element because 2 > 4/2 is false.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i], target <= 10⁹ 
// nums is sorted in non-decreasing order. 
// 
//
// 👍 367 👎 34


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return -Integer.compare(a[1], b[1]);
        });

        for (Map.Entry<Integer, Integer> kv : counter.entrySet()) {
            pq.add(new int[]{kv.getKey(), kv.getValue()});
        }

        int[] max = pq.poll();

        return max[0] == target && max[1] > (nums.length / 2);


    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class CheckIfANumberIsMajorityElementInASortedArray extends Solution {
}