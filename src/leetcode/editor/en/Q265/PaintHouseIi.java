package leetcode.editor.en.Q265;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;

    public int minCostII(int[][] costs) {
        cache = new Integer[costs.length][costs[0].length + 1];
        return minCostII(0, costs[0].length, costs);
    }

    private int minCostII(int i, int cantBe, int[][] costs) {
        if (i == costs.length) {
            return 0;
        }
        if (cache[i][cantBe] != null) {
            return cache[i][cantBe];
        }

        int[] colors = costs[i];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < colors.length; j++) {
            if (j == cantBe) continue;
            int cost = colors[j] + minCostII(i + 1, j, costs);
            ans = Math.min(ans, cost);
        }
        cache[i][cantBe] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PaintHouseIi extends Solution {
}