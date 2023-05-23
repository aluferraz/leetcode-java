package leetcode.editor.en.Q403;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();

    public boolean canCross(int[] stones) {
        LinkedHashSet<Integer> stonesSet = new LinkedHashSet<>();
        for (int stone : stones) {
            stonesSet.add(stone);
        }
        return canCrossHelper(0, 1, stonesSet, stones[stones.length - 1]);
    }

    public boolean canCrossHelper(int i, int k, LinkedHashSet<Integer> stones, int target) {
        if (i == target) return true;
        if (i + (k - 1) > target) return false;


        Pair<Integer, Integer> cacheKey = new Pair<>(i, k);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        boolean ans = false;
        if (k - 1 > 0) {
            if (stones.contains(i + (k - 1))) {
                ans = canCrossHelper(i + (k - 1), k - 1, stones, target);
                if (ans) return ans;
            }
        }
        if (stones.contains(i + k)) {
            ans = canCrossHelper(i + k, (k), stones, target);
            if (ans) return ans;
        }
        if (i > 0 && stones.contains(i + k + 1)) {
            ans = canCrossHelper(i + k + 1, (k + 1), stones, target);
            if (ans) return ans;
        }

        cache.put(cacheKey, ans);
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FrogJump extends Solution {
}