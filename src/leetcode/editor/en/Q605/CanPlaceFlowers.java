package leetcode.editor.en.Q605;

import java.util.*;

import javafx.util.Pair;

//You have a long flowerbed in which some of the plots are planted, and some 
//are not. However, flowers cannot be planted in adjacent plots. 
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty 
//and 1 means not empty, and an integer n, return if n new flowers can be planted 
//in the flowerbed without violating the no-adjacent-flowers rule. 
//
// 
// Example 1: 
// Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
// 
// Example 2: 
// Input: flowerbed = [1,0,0,0,1], n = 2
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] is 0 or 1. 
// There are no two adjacent flowers in flowerbed. 
// 0 <= n <= flowerbed.length 
// 
//
// 👍 4040 👎 772


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Integer cache[];

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if (flowerbed.length == 0) return n == 0;
        if (n == 0) return true;
        cache = new Integer[flowerbed.length];
        return placeFlowers(0, flowerbed) >= n;
    }

    private int placeFlowers(int i, int[] flowerbed) {
        if (i >= flowerbed.length) {
            return 0;
        }
        int res = 0;
        if (cache[i] != null) {
            return cache[i];
        }

        if (flowerbed[i] == 1) {
            res = placeFlowers(i + 2, flowerbed);
        } else {
            if ((i + 1 < flowerbed.length && flowerbed[i + 1] == 0) || i == flowerbed.length - 1) {
                res = 1 + placeFlowers(i + 2, flowerbed);
            }
            res = Math.max(res, placeFlowers(i + 1, flowerbed));
        }
        cache[i] = res;
        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class CanPlaceFlowers extends Solution {
}