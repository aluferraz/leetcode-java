package leetcode.editor.en.Q790;

import java.util.*;

//You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You 
//may rotate these shapes. 
// 
// Given an integer n, return the number of ways to tile an 2 x n board. Since 
//the answer may be very large, return it modulo 10⁹ + 7. 
//
// In a tiling, every square must be covered by a tile. Two tilings are 
//different if and only if there are two 4-directionally adjacent cells on the board such 
//that exactly one of the tilings has both squares occupied by a tile. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: 5
//Explanation: The five different ways are show above.
// 
//
// Example 2: 
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
// 1 <= n <= 1000 
// 
//
// 👍 2281 👎 739


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Long[] evenCache;
    Long[] oddCache;

    //https://www.youtube.com/watch?v=fQd104LDSfU
    public int numTilings(int n) {
        evenCache = new Long[n + 1];
        oddCache = new Long[n + 1];
        Long result = even(n);
        result %= 1000000007L;
        return result.intValue();
    }


    private Long even(int n) {
        if (n == 0) return 1L;
        if (evenCache[n] != null) return evenCache[n];
        long count = 0L;
        count += even(n - 1);
        if (n >= 2) { // We can lay down
            count += evenCache[n - 2] != null ? evenCache[n - 2] : even(n - 2);
            count += (2 * (oddCache[n - 2] != null ? oddCache[n - 2] : odd(n - 2)));
        }
        count %= 1000000007L;
        evenCache[n] = count;
        return count;
    }

    private Long odd(int n) {
        if (n == 0) return 0L;
        if (oddCache[n] != null) return oddCache[n];

        long count = 0;

        count += even(n - 1) + (odd(n - 1));
        count %= 1000000007L;
        oddCache[n] = count;
        return count;
    }

}


//leetcode submit region end(Prohibit modification and deletion)


public class DominoAndTrominoTiling extends Solution {
}