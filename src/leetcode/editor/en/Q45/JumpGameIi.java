package leetcode.editor.en.Q45;

import java.util.*;

//You are given a 0-indexed array of integers nums of length n. You are 
//initially positioned at nums[0]. 
//
// Each element nums[i] represents the maximum length of a forward jump from 
//index i. In other words, if you are at nums[i], you can jump to any nums[i + j] 
//where: 
//
// 
// 0 <= j <= nums[i] and 
// i + j < n 
// 
//
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are 
//generated such that you can reach nums[n - 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
//
// 👍 10133 👎 354


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int[] cost = new int[nums.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[nums.length - 1] = 0;
        SegmentTree segTree = new SegmentTree(cost);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                int minCost = segTree.query(i + 1, Math.min(i + nums[i] + 1, nums.length));
                cost[i] = 1 + minCost;
                segTree.update(i, cost[i]);
                target = i;
            }
        }
        return cost[0];
    }


    class SegmentTree {
        private int[] tree;
        private int n;

        SegmentTree(int[] array) {
            n = array.length;
            this.tree = new int[2 * n];
            System.arraycopy(array, 0, tree, n, n);
            for (int i = n - 1; i >= 0; i--) {
                tree[i] = Math.min(tree[2 * i], tree[(2 * i) + 1]);
            }
        }

        public void update(int idx, int value) {
            int i = n + idx;
            tree[i] = value;
            while (i > 1) {
                i = (i / 2);
                int before = tree[i];
                tree[i] = Math.min(tree[2 * i], tree[(2 * i) + 1]);
                if (before == tree[i]) return;
            }

        }

        public int query(int start, int end) {
            int from = start + n;
            int to = end + n;
            int min = Integer.MAX_VALUE;
            while (from < to) {
                if ((from & 1) == 1) { // from is odd
                    min = Math.min(tree[from], min);
                    from++;
                }

                if ((to & 1) == 1) { // two odd
                    to--;
                    min = Math.min(tree[to], min);
                }
                from = from / 2;
                to = to / 2;
            }
            return min;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class JumpGameIi extends Solution {
}