package leetcode.editor.en.Q837;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {


    public double new21Game(int n, int k, int maxPts) {
        double[] slidingWindow = new double[maxPts + k + 1];
        double windowSum = 0;
        for (int card = k; card < maxPts + k; card++) {
            double prob = (card <= n) ? 1.0 : 0;
            slidingWindow[card] = prob;
            windowSum += prob;

        }
        for (int card = k - 1; card >= 0; card--) {
            double prob = windowSum / maxPts;

            slidingWindow[card] = prob;
            windowSum += prob;
            windowSum -= slidingWindow[card + maxPts];

        }

        return slidingWindow[0];

    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class New21Game extends Solution {
}