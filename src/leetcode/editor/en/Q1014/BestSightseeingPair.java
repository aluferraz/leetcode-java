package leetcode.editor.en.Q1014;

import java.util.*;

import javafx.util.Pair;
import leetcode.editor.en.Q169.MajorityElement;

//You are given an integer array values where values[i] represents the value of 
//the iᵗʰ sightseeing spot. Two sightseeing spots i and j have a distance j - i 
//between them. 
//
// The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + 
//i - j: the sum of the values of the sightseeing spots, minus the distance 
//between them. 
//
// Return the maximum score of a pair of sightseeing spots. 
//
// 
// Example 1: 
//
// 
//Input: values = [8,1,5,2,6]
//Output: 11
//Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// Example 2: 
//
// 
//Input: values = [1,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= values.length <= 5 * 10⁴ 
// 1 <= values[i] <= 1000 
// 
//
// 👍 2312 👎 52


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        LinkedList<int[]> monoStack = new LinkedList<>();
        monoStack.add(new int[]{values[0], 0});
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            int num = values[i];
            int[] prev = monoStack.peekLast();
            int bestPairHere = (num + prev[0] + (prev[1] - i));
            max = Math.max(max, bestPairHere);
            while (!monoStack.isEmpty() && (monoStack.peekLast()[0] - (i - prev[1])) <= num) {
                monoStack.pollLast();
            }
            if (monoStack.isEmpty()) {
                monoStack.addFirst(new int[]{num, i});
            }
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BestSightseeingPair extends Solution {
}