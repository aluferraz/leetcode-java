package leetcode.editor.en.Q319;

import java.util.*;

import javafx.util.Pair;

//There are n bulbs that are initially off. You first turn on all the bulbs, 
//then you turn off every second bulb. 
//
// On the third round, you toggle every third bulb (turning on if it's off or 
//turning off if it's on). For the iᵗʰ round, you toggle every i bulb. For the nᵗʰ 
//round, you only toggle the last bulb. 
//
// Return the number of bulbs that are on after n rounds. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: 1
//Explanation: At first, the three bulbs are [off, off, off].
//After the first round, the three bulbs are [on, on, on].
//After the second round, the three bulbs are [on, off, on].
//After the third round, the three bulbs are [on, off, off]. 
//So you should return 1 because there is only one bulb is on. 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// 👍 1619 👎 2301


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int next = 1;

    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return bulbSwitchHelper(1, n);
    }

    public int bulbSwitchHelper(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        next += 2;
        return 1 + bulbSwitchHelper(i + next, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BulbSwitcher extends Solution {
}