package leetcode.editor.en.Q446;

//Given an integer array nums, return the number of all the arithmetic
//subsequences of nums. 
//
// A sequence of numbers is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
//
// 
// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are 
//arithmetic sequences. 
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence. 
// 
//
// A subsequence of an array is a sequence that can be formed by removing some 
//elements (possibly none) of the array. 
//
// 
// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10]. 
// 
//
// The test cases are generated so that the answer fits in 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,4,6,8,10]
//Output: 7
//Explanation: All arithmetic subsequence slices are:
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// Example 2: 
//
// 
//Input: nums = [7,7,7,7,7]
//Output: 16
//Explanation: Any subsequence of this array is arithmetic.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 👍 1840 👎 103


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<String, Long> cache;
    HashMap<Long, TreeSet<Integer>> indexMap = new HashMap<>();

    public int numberOfArithmeticSlices(int[] nums) {
        Long sum = 0L;
        cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long number = (long) nums[i];
            TreeSet<Integer> sawAt = new TreeSet<>();
            if (indexMap.containsKey(number)) {
                sawAt = indexMap.get(number);
            }
            sawAt.add(i);
            indexMap.put(number, sawAt);
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Long diff = (long) nums[j] - nums[i];
                Long target = nums[j] + diff;
                if (!indexMap.containsKey(target)) continue;
                Integer nextIndex = indexMap.get(target).ceiling(j + 1);
                if (nextIndex == null) continue;
                sum += slices(nums, nextIndex, diff, target);
            }

        }
        return sum.intValue();
    }

    public Long slices(int[] nums, int i, Long diff, Long target) {
        Long total = 0L;
        if (i == nums.length) return 0L;
        String cacheKey = i + "," + diff + "," + target;
        if (cache.containsKey(cacheKey)) {
            //System.out.println("HIT");
            return cache.get(cacheKey);
        }

        if (nums[i] == target) {
            total++;
            long newTarget = (long) nums[i] + diff;
            if (indexMap.containsKey(newTarget)) {
                Integer nextIndex = indexMap.get(newTarget).ceiling(i + 1);
                if (nextIndex != null) {
                    total += slices(nums, nextIndex, diff, newTarget);
                }
            }
        }

        long newTarget = target;
        if (indexMap.containsKey(newTarget)) {
            Integer nextIndex = indexMap.get(newTarget).ceiling(i + 1);
            if (nextIndex != null) {
                total += slices(nums, nextIndex, diff, newTarget);
            }
        }
        //Long result = total + slices(nums, i + 1, diff, target);
        cache.put(cacheKey, total);
        return total;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class ArithmeticSlicesIiSubsequence extends Solution {
}