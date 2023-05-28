package leetcode.editor.en.Q1406;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[] cache;

    public String stoneGameIII(int[] stoneValue) {

        cache = new Integer[stoneValue.length];

        int ans = stoneGameIII(0, stoneValue);
        if (ans == 0) return "Tie";
        if (ans > 0) return "Alice";
        return "Bob";

    }


    private int stoneGameIII(int i, int[] stoneValue) {
        if (i >= stoneValue.length) return 0;
        if (cache[i] != null) return cache[i];

        int score = Integer.MIN_VALUE;

        int stoneSum = 0;

        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            stoneSum += stoneValue[j];
            int scoreChoosingStone = stoneSum - stoneGameIII(j + 1, stoneValue);
            score = Math.max(scoreChoosingStone, score);
        }

        cache[i] = score;
        return score;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class StoneGameIii extends Solution {
}