package leetcode.editor.en.Q1134;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isArmstrong(int n) {
        String s = String.valueOf(n);
        int power = s.length();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(Character.getNumericValue(s.charAt(i)), power);
        }
        return sum == n;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ArmstrongNumber extends Solution {
}