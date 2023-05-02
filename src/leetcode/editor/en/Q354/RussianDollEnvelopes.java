package leetcode.editor.en.Q354;

import java.util.*;

import javafx.util.Pair;

//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
//represents the width and the height of an envelope.
//
// One envelope can fit into another if and only if both the width and height
//of one envelope are greater than the other envelope's width and height.
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one
//inside the other).
//
// Note: You cannot rotate an envelope.
//
//
// Example 1:
//
//
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3]
//=> [5,4] => [6,7]).
//
//
// Example 2:
//
//
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= envelopes.length <= 10⁵
// envelopes[i].length == 2
// 1 <= wi, hi <= 10⁵
//
//
// 👍 5035 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int START = 1;
    int END = -1;


    public int maxEnvelopes(int[][] envelopes) {
        //https://www.youtube.com/watch?v=ibf-ILexbqQ

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(-a[1], -b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] longest = new int[envelopes.length + 1];
        Arrays.fill(longest, -1);
        longest[1] = 0;


        for (int i = 0; i < envelopes.length; i++) {
            int maxPossibleLSI = i + 1;
            int pos = binarySearch(1, maxPossibleLSI, envelopes[i][1], longest, envelopes);
            if (longest[pos] == -1 || envelopes[i][1] < envelopes[longest[pos]][1]) {
                longest[pos] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < longest.length; i++) {
            if (longest[i] != -1) {
                ans = i;
            }
        }
        return ans;
    }

    private int binarySearch(int left, int right, int target, int[] longest, int[][] envelopes) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (longest[mid] == -1 || envelopes[longest[mid]][1] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class RussianDollEnvelopes extends Solution {
}