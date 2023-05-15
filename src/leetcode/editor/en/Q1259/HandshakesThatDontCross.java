package leetcode.editor.en.Q1259;

import java.math.BigInteger;
import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    BigInteger[] cache;

    public int numberOfWays(int numPeople) {
        cache = new BigInteger[numPeople + 1];
        return numberOfWaysHelper(numPeople).mod(new BigInteger("1000000007")).intValue();
    }


    public BigInteger numberOfWaysHelper(int numPeople) {
        if (numPeople % 2 == 1) return new BigInteger("0");
        if (numPeople == 0) return new BigInteger("1");
        if (cache[numPeople] != null) return cache[numPeople];
        BigInteger ans = new BigInteger("0");

        for (int i = 0; i < numPeople; i += 2) {
            BigInteger right = numberOfWaysHelper(numPeople - 2 - i);
            BigInteger left = numberOfWaysHelper(i);
            ans = ans.add(left.multiply(right));
        }
        cache[numPeople] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class HandshakesThatDontCross extends Solution {
}