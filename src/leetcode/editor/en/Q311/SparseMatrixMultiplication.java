package leetcode.editor.en.Q311;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    ans[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SparseMatrixMultiplication extends Solution {
}