package leetcode.editor.en.Q416;

import java.util.*;

//Given a non-empty array nums containing only positive integers, find if the 
//array can be partitioned into two subsets such that the sum of elements in both 
//subsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 👍 9497 👎 159


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        List<Integer> possibilities = new ArrayList<>();
        HashSet<Integer> possibilitiesSet = new HashSet<>();
        HashMap<Integer, Integer> elements = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            elements.put(num, elements.getOrDefault(num, 0) + 1);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (elements.containsKey(target)) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            int size = possibilities.size();
            if (nums[i] == target || possibilitiesSet.contains(target - nums[i])) {
                return true;
            }
            int count = elements.get(nums[i]);
            count--;
            if (count == 0) {
                elements.remove(nums[i]);
            } else {
                elements.put(nums[i], count);
            }

            for (int j = 0; j < size; j++) {
                int partialSum = possibilities.get(j);
                int newSum = (partialSum + nums[i]);
                if (possibilitiesSet.contains(newSum)) continue;
                if (elements.containsKey(target - newSum) || (newSum == target)) {
                    return true;
                }
                if (newSum < target) {
                    possibilities.add(newSum);
                    possibilitiesSet.add(newSum);
                }
            }
            if (!possibilitiesSet.contains(nums[i])) {
                possibilities.add(nums[i]);
                possibilitiesSet.add(nums[i]);
            }


        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PartitionEqualSubsetSum extends Solution {
}