package leetcode.editor.en.Q1626;

import java.util.*;

import javafx.util.Pair;

//You are the manager of a basketball team. For the upcoming tournament, you
//want to choose the team with the highest overall score. The score of the team is
//the sum of scores of all the players in the team.
//
// However, the basketball team is not allowed to have conflicts. A conflict
//exists if a younger player has a strictly higher score than an older player. A
//conflict does not occur between players of the same age.
//
// Given two lists, scores and ages, where each scores[i] and ages[i]
//represents the score and age of the iᵗʰ player, respectively, return the highest overall
//score of all possible basketball teams.
//
//
// Example 1:
//
//
//Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
//Output: 34
//Explanation: You can choose all the players.
//
//
// Example 2:
//
//
//Input: scores = [4,5,6,5], ages = [2,1,2,1]
//Output: 16
//Explanation: It is best to choose the last 3 players. Notice that you are
//allowed to choose multiple people of the same age.
//
//
// Example 3:
//
//
//Input: scores = [1,2,3,5], ages = [8,9,10,1]
//Output: 6
//Explanation: It is best to choose the first 3 players.
//
//
//
// Constraints:
//
//
// 1 <= scores.length, ages.length <= 1000
// scores.length == ages.length
// 1 <= scores[i] <= 10⁶
// 1 <= ages[i] <= 1000
//
//
// 👍 1586 👎 46


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] scoresAndAges;
    boolean[] hasCache;
    int[] cache;

    public int bestTeamScore(int[] scores, int[] ages) {
        cache = new int[scores.length];
        hasCache = new boolean[scores.length];
        scoresAndAges = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            scoresAndAges[i][0] = scores[i];
            scoresAndAges[i][1] = ages[i];
        }
        Arrays.sort(scoresAndAges, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int res = 0;
        for (int i = 0; i < scoresAndAges.length; i++) {
            res = Math.max(res, LCISum(i));
        }
        return res;
    }

    private int LCISum(int i) {
        if (i == scoresAndAges.length) {
            return 0;
        }
        if (hasCache[i]) return cache[i];
        int best = scoresAndAges[i][0];
        for (int j = i + 1; j < scoresAndAges.length; j++) {
            if (scoresAndAges[j][0] >= scoresAndAges[i][0]) {
                best = Math.max(best, LCISum(j) + scoresAndAges[i][0]);
            }
        }
        cache[i] = best;
        hasCache[i] = true;
        return cache[i];

    }
}

//leetcode submit region end(Prohibit modification and deletion)


public class BestTeamWithNoConflicts extends Solution {
}