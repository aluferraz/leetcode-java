package leetcode.editor.en.Q1030;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int aDist = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int bDist = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return Integer.compare(aDist, bDist);
        });

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pq.add(new int[]{i, j});
            }
        }
        int[][] ans = new int[rows * cols][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MatrixCellsInDistanceOrder extends Solution {
}