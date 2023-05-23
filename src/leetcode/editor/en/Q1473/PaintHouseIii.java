package leetcode.editor.en.Q1473;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][][] cache;
    private int INF = 100000000;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        cache = new Integer[m][n + 1][target + 1];
        int ans = paintHouses(0, houses, cost, m, n, target, -1);
        if (ans >= INF) return -1;
        return ans;
    }


    private int paintHouses(int i, int[] houses, int[][] costs, int m, int n, int target, int prev) {
        if (i == m) {
            if (target == 0) return 0;
            return INF;
        }
        if (target < 0) return INF;

        if (prev != -1 && cache[i][prev][target] != null) {
            return cache[i][prev][target];
        }
        int ans = INF;
        int neighborhood = (prev != houses[i] ? 1 : 0);
        if (houses[i] != 0) {
            ans = paintHouses(i + 1, houses, costs, m, n, target - neighborhood, houses[i]);
        } else {
            for (int color = 1; color <= n; color++) {
                int cost = costs[i][color - 1];
                neighborhood = (i == 0 || prev != color ? 1 : 0);
                int costOfPainting = cost + paintHouses(i + 1, houses, costs, m, n, target - neighborhood, color);
                ans = Math.min(ans, costOfPainting);
            }

        }
        if (prev != -1) cache[i][prev][target] = ans;
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class PaintHouseIii extends Solution {
}