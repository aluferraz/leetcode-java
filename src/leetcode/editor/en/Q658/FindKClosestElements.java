package leetcode.editor.en.Q658;

import java.util.*;

import javafx.util.Pair;

//Given a sorted integer array arr, two integers k and x, return the k closest 
//integers to x in the array. The result should also be sorted in ascending order. 
//
//
// An integer a is closer to x than an integer b if: 
//
// 
// |a - x| < |b - x|, or 
// |a - x| == |b - x| and a < b 
// 
//
// 
// Example 1: 
// Input: arr = [1,2,3,4,5], k = 4, x = 3
//Output: [1,2,3,4]
// 
// Example 2: 
// Input: arr = [1,2,3,4,5], k = 4, x = -1
//Output: [1,2,3,4]
// 
// 
// Constraints: 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr is sorted in ascending order. 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// 👍 6866 👎 553


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        for (int num : arr) {
            pq.add(new int[]{num, Math.abs(num - x)});
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll()[0]);
        }
        Collections.sort(res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindKClosestElements extends Solution {
}