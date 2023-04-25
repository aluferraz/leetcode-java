package leetcode.editor.en.Q2653;
import java.util.*;
import javafx.util.Pair;

//Given an integer array nums containing n integers, find the beauty of each 
//subarray of size k. 
//
// The beauty of a subarray is the xᵗʰ smallest integer in the subarray if it 
//is negative, or 0 if there are fewer than x negative integers. 
//
// Return an integer array containing n - k + 1 integers, which denote the 
//beauty of the subarrays in order from the first index in the array. 
//
// 
// A subarray is a contiguous non-empty sequence of elements within an array. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
//Output: [-1,-2,-2]
//Explanation: There are 3 subarrays with size k = 3. 
//The first subarray is [1, -1, -3] and the 2ⁿᵈ smallest negative integer is -1.
// 
//The second subarray is [-1, -3, -2] and the 2ⁿᵈ smallest negative integer is -
//2. 
//The third subarray is [-3, -2, 3] and the 2ⁿᵈ smallest negative integer is -2.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-2,-3,-4,-5], k = 2, x = 2
//Output: [-1,-2,-3,-4]
//Explanation: There are 4 subarrays with size k = 2.
//For [-1, -2], the 2ⁿᵈ smallest negative integer is -1.
//For [-2, -3], the 2ⁿᵈ smallest negative integer is -2.
//For [-3, -4], the 2ⁿᵈ smallest negative integer is -3.
//For [-4, -5], the 2ⁿᵈ smallest negative integer is -4.  
//
// Example 3: 
//
// 
//Input: nums = [-3,1,2,-3,0,-3], k = 2, x = 1
//Output: [-3,0,-3,-3,-3]
//Explanation: There are 5 subarrays with size k = 2.
//For [-3, 1], the 1ˢᵗ smallest negative integer is -3.
//For [1, 2], there is no negative integer so the beauty is 0.
//For [2, -3], the 1ˢᵗ smallest negative integer is -3.
//For [-3, 0], the 1ˢᵗ smallest negative integer is -3.
//For [0, -3], the 1ˢᵗ smallest negative integer is -3. 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= k <= n 
// 1 <= x <= k 
// -50 <= nums[i] <= 50 
// 
//
// 👍 249 👎 88


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        LinkedList<Integer> sliding = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIdx = 0;
        for (int num : nums) {
            sliding.add(num);
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            if (sliding.size() == k) {
                int toRemove = sliding.pollFirst();
                int index = 0;
                for (Map.Entry<Integer, Integer> kv : numbers.entrySet()) {
                    index += kv.getValue();
                    if (index >= x) {
                        int value = kv.getKey();
                        if (value < 0) ans[ansIdx++] = value;
                        else ansIdx++;
                        break;
                    }
                }
                int total = numbers.get(toRemove);
                total--;
                if (total == 0) numbers.remove(toRemove);
                else numbers.put(toRemove, total);
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)



public class SlidingSubarrayBeauty extends Solution {}