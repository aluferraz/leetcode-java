package leetcode.editor.en.Q651;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int maxA(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][1] = 1;
        dp[0][2] = 1;
        for (int i = 1; i <= n; i++) {
            int paste = dp[i - 1][1];
            int newBuffer = dp[i - 1][1];
            int previousBuffer = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + paste;
            if (dp[i - 1][3] + dp[i - 1][2] >= dp[i][0]) { //If create a new buffer on previous step is better
                dp[i][0] = dp[i - 1][3] + dp[i - 1][2];
                paste = dp[i - 1][2];
            }

            if (i - 3 >= 0) {
                newBuffer = dp[i - 3][0];
                previousBuffer = dp[i - 3][0];
                dp[i][3] = previousBuffer + newBuffer;
                if (previousBuffer + newBuffer >= dp[i][0]) {
                    paste = newBuffer;
                }

            }
            dp[i][1] = paste;
            dp[i][2] = newBuffer;
        }
        return dp[n][0];
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class FourKeysKeyboard extends Solution {
}