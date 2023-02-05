package leetcode.editor.en.Q215;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 👍 13084 👎 653


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Build heap has a time complexity of O(N), emulating with priority queue.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int res = pq.peek();
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }

    private void placeNum(int num, int k, LinkedList<Integer> order) {
        if (order.size() == k && num <= order.getLast()) return;

        order.add(num);
        if (order.size() > k) {
            order.remove(0);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KthLargestElementInAnArray extends Solution {
}