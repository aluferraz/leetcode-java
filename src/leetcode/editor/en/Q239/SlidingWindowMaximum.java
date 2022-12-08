package leetcode.editor.en.Q239;

import java.util.*;

//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// 👍 12995 👎 424


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //https://www.youtube.com/watch?v=DfljaUwZsOk
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && (i - k) >= queue.peekFirst()) {
                queue.pollFirst(); //outside of the window
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast(); //Not important
            }
            queue.offerLast(i);
            if (i + 1 >= k) {
                result[pos++] = nums[queue.peekFirst()];
            }
        }

        return result;


    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        TreeMap<Integer, Integer> windowNumbers = new TreeMap<>();
//        List<Integer> result = new ArrayList<>();
//        int left = 0;
//        int right = 0;
//        while (right < nums.length) {
//            windowNumbers.put(nums[right], windowNumbers.getOrDefault(nums[right], 0) + 1);
//            if ((right - left + 1) > k) {
//                int total = windowNumbers.get(nums[left]);
//                total--;
//                if (total == 0) windowNumbers.remove(nums[left]);
//                else windowNumbers.put(nums[left], total);
//                left++;
//            }
//            if ((right - left + 1) == k) result.add(windowNumbers.lastKey());
//            right++;
//        }
//        int[] resultArr = new int[result.size()];
//        for (int i = 0; i < resultArr.length; i++) {
//            resultArr[i] = result.get(i);
//        }
//        return resultArr;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SlidingWindowMaximum extends Solution {
}