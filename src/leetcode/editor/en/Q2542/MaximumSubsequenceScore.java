package leetcode.editor.en.Q2542;

import java.util.*;
import java.util.function.BinaryOperator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] combined = new int[nums1.length][3];
        for (int i = 0; i < nums1.length; i++) {
            combined[i] = new int[]{nums1[i], nums2[i]};
        }
        //We want the greatest MIN and the greatest SUM possible
        Arrays.sort(combined, (a, b) -> {
            if (a[1] == b[1]) {
                return -Integer.compare(a[0], b[0]);
            }
            return -Integer.compare(a[1], b[1]);
        });

        long total = 0;
        int min = combined[0][1];
        long ans = 0;
        PriorityQueue<Integer> usedOnSum = new PriorityQueue<>();
        for (int i = 0; i < combined.length; i++) {
            usedOnSum.add(combined[i][0]);
            total += (long) (combined[i][0]);
            min = combined[i][1];
            //When we pass K, we need to remove a number from the sum.
            //the multiplier will always be the current i;
            if (usedOnSum.size() > k) {
                total -= usedOnSum.poll(); //We remove the less we can from the sum.
            }
            if (usedOnSum.size() == k) {
                //When we reach K, we evaluate.
                ans = Math.max(ans, total * min);
            }

        }

        return ans;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumSubsequenceScore extends Solution {
}