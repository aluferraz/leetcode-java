package leetcode.editor.en.Q875;

import java.util.*;

import javafx.util.Pair;

//Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has 
//piles[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
//chooses some pile of bananas and eats k bananas from that pile. If the pile has less 
//than k bananas, she eats all of them instead and will not eat any more bananas 
//during this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
//before the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h 
//hours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// 👍 6573 👎 313


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
//        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
//            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }
        long left = 1; // Best case
        long right = (((long) max * piles.length)) + 1L; // worst case
        while (left < right) {
            long mid = Math.floorDiv((left + right), 2);
            if (canEat(piles, (int) mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;

    }

    private boolean canEat(int[] piles, int k, int h) {
        int left = 0;
        int currentTime = 0;
        while (currentTime <= h && left < piles.length) {
            int pile = piles[left];
            int timeNeeded = (int) Math.ceil(pile / (double) k);
            currentTime += timeNeeded;
            if (currentTime <= h) left++;
        }
        return (left == piles.length);


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KokoEatingBananas extends Solution {
}