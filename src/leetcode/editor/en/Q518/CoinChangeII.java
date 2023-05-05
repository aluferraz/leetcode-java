package leetcode.editor.en.Q518;


import javafx.util.Pair;

import java.util.*;

class Solution {
    Integer[][] cache;

    public int change(int amount, int[] coins) {
        cache = new Integer[coins.length][amount + 1];
        Arrays.sort(coins);
        return change(0, amount, coins);
    }


    private int change(int i, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins[i] > amount) return 0;
        if (cache[i][amount] != null) return cache[i][amount];
        int ans = 0;
        for (int j = i; j < coins.length; j++) {
            if (coins[j] > amount) break;
            ans += change(j, amount - coins[j], coins);
        }
        cache[i][amount] = ans;
        return ans;
    }

}

public class CoinChangeII extends Solution {
}
