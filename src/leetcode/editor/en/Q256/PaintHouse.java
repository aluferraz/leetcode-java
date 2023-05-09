package leetcode.editor.en.Q256;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;

    public int minCost(int[][] costs) {
        cache = new Integer[costs.length][4];
        return minCost(0, 3, costs);
    }

    public int minCost(int i, int cantBe, int[][] costs) {
        if (i == costs.length) return 0;
        int red = costs[i][0];
        int blue = costs[i][1];
        int green = costs[i][2];

        int ans = 0;
        if (cache[i][cantBe] != null) {
            return cache[i][cantBe];
        }

        int useRed = red + minCost(i + 1, 0, costs);
        int useBlue = blue + minCost(i + 1, 1, costs);
        int useGreen = green + minCost(i + 1, 2, costs);

        switch (cantBe) {
            case 0 -> {
                ans = Math.min(useGreen, useBlue);
            }
            case 1 -> {
                ans = Math.min(useRed, useGreen);
            }
            case 2 -> {
                ans = Math.min(useRed, useBlue);
            }
            default -> {
                ans = Math.min(useRed, useBlue);
                ans = Math.min(ans, useGreen);
            }
        }
        cache[i][cantBe] = ans;

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PaintHouse extends Solution {
}