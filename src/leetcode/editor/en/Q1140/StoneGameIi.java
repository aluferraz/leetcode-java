package leetcode.editor.en.Q1140;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final static int ALICE = 0;
    HashMap<Pair<Integer, Integer>, Integer> cache;

    public int stoneGameII(int[] piles) {
        cache = new HashMap<>();
        int aliceScore = stoneGameII(ALICE, 0, 1, piles);
        int totalStones = Arrays.stream(piles).sum();

        //totalStones = aliceScore + bobScore;

        int bobScore = (totalStones - aliceScore) / 2;


        return totalStones - bobScore;

    }

    private int stoneGameII(int player, int i, int m, int[] piles) {
        if (i >= piles.length) return 0;
        Pair<Integer, Integer> cacheKey = new Pair<>(i, m);
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
        int score = Integer.MIN_VALUE;

        int maxReach = 2 * m;
        int scoreSum = 0;
        int nextPlayer = (player + 1) % 2;
        int boundary = Math.min(i + maxReach, piles.length);
        int x = 0;
        for (int j = i; j < boundary; j++) {
            scoreSum += piles[j];
            x++;
            int newM = Math.max(x, m);
            int newStart = j + 1;
            int finalScore = scoreSum - stoneGameII(nextPlayer, newStart, newM, piles);
            score = Math.max(score, finalScore);
        }

        cache.put(cacheKey, score);
        return score;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class StoneGameIi extends Solution {
}