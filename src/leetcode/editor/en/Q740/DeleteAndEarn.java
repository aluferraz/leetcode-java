package leetcode.editor.en.Q740;

import java.util.*;

import javafx.util.Pair;

//You are given an integer array nums. You want to maximize the number of 
//points you get by performing the following operation any number of times: 
//
// 
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must 
//delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// 
// 
//
// Return the maximum number of points you can earn by applying the above 
//operation some number of times. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,2]
//Output: 6
//Explanation: You can perform the following operations:
//- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//- Delete 2 to earn 2 points. nums = [].
//You earn a total of 6 points.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: You can perform the following operations:
//- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//
//- Delete a 3 again to earn 3 points. nums = [3].
//- Delete a 3 once more to earn 3 points. nums = [].
//You earn a total of 9 points. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 👍 6357 👎 327


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Integer[] cache;

    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt() + 1;
        cache = new Integer[max];
        int[] counter = new int[max];
        for (int num : nums) {
            counter[num]++;
        }
        return deleteAndEarn(0, counter);

    }

    public int deleteAndEarn(int i, int[] counter) {

        if (i >= counter.length) {
            return 0;
        }
        if (cache[i] != null) return cache[i];
        if (counter[i] == 0) {
            return deleteAndEarn(i + 1, counter);
        }

        int use = (counter[i] * i) + deleteAndEarn(i + 2, counter);
        int doNotUse = deleteAndEarn(i + 1, counter);
        cache[i] = Math.max(use, doNotUse);
        return cache[i];


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DeleteAndEarn extends Solution {
}