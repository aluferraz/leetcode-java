package leetcode.editor.en.Q128;

import java.util.*;

import javafx.util.Pair;

//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 👍 14994 👎 624


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            longest = Math.max(sequenceLength(num, numbers), longest);
        }
        return longest;
    }

    private int sequenceLength(int num, HashSet<Integer> numbers) {
        if (!numbers.contains(num)) return 0;
        numbers.remove(num);
        return 1 + sequenceLength(num + 1, numbers) + sequenceLength(num - 1, numbers);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestConsecutiveSequence extends Solution {
}