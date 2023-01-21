package leetcode.editor.en.Q506;

import java.util.*;

import javafx.util.Pair;

//You are given an integer array score of size n, where score[i] is the score 
//of the iᵗʰ athlete in a competition. All the scores are guaranteed to be unique. 
//
// The athletes are placed based on their scores, where the 1ˢᵗ place athlete 
//has the highest score, the 2ⁿᵈ place athlete has the 2ⁿᵈ highest score, and so on.
// The placement of each athlete determines their rank: 
//
// 
// The 1ˢᵗ place athlete's rank is "Gold Medal". 
// The 2ⁿᵈ place athlete's rank is "Silver Medal". 
// The 3ʳᵈ place athlete's rank is "Bronze Medal". 
// For the 4ᵗʰ place to the nᵗʰ place athlete, their rank is their placement 
//number (i.e., the xᵗʰ place athlete's rank is "x"). 
// 
//
// Return an array answer of size n where answer[i] is the rank of the iᵗʰ 
//athlete. 
//
// 
// Example 1: 
//
// 
//Input: score = [5,4,3,2,1]
//Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//Explanation: The placements are [1ˢᵗ, 2ⁿᵈ, 3ʳᵈ, 4ᵗʰ, 5ᵗʰ]. 
//
// Example 2: 
//
// 
//Input: score = [10,3,8,9,4]
//Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//Explanation: The placements are [1ˢᵗ, 5ᵗʰ, 3ʳᵈ, 2ⁿᵈ, 4ᵗʰ].
//
// 
//
// 
// Constraints: 
//
// 
// n == score.length 
// 1 <= n <= 10⁴ 
// 0 <= score[i] <= 10⁶ 
// All the values in score are unique. 
// 
//
// 👍 878 👎 43


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] scores) {
        TreeMap<Integer, String> scoreSort = new TreeMap<>(Comparator.reverseOrder());
        String[] res = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            scoreSort.put(scores[i], "");
        }
        int i = 0;
        for (Map.Entry<Integer, String> entry : scoreSort.entrySet()) {
            String val = String.valueOf(i + 1);
            if (i == 0) val = "Gold Medal";
            if (i == 1) val = "Silver Medal";
            if (i == 2) val = "Bronze Medal";
            scoreSort.put(entry.getKey(), val);
            i++;
        }
        for (i = 0; i < scores.length; i++) {
            res[i] = scoreSort.get(scores[i]);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class RelativeRanks extends Solution {
}