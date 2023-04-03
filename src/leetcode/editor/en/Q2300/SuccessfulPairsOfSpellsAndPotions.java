package leetcode.editor.en.Q2300;

import java.util.*;

import javafx.util.Pair;

//You are given two positive integer arrays spells and potions, of length n and 
//m respectively, where spells[i] represents the strength of the iᵗʰ spell and 
//potions[j] represents the strength of the jᵗʰ potion. 
//
// You are also given an integer success. A spell and potion pair is considered 
//successful if the product of their strengths is at least success. 
//
// Return an integer array pairs of length n where pairs[i] is the number of 
//potions that will form a successful pair with the iᵗʰ spell. 
//
// 
// Example 1: 
//
// 
//Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//Output: [4,0,3]
//Explanation:
//- 0ᵗʰ spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
//- 1ˢᵗ spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
//- 2ⁿᵈ spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
//Thus, [4,0,3] is returned.
// 
//
// Example 2: 
//
// 
//Input: spells = [3,1,2], potions = [8,5,8], success = 16
//Output: [2,0,2]
//Explanation:
//- 0ᵗʰ spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
//- 1ˢᵗ spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful. 
//- 2ⁿᵈ spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful. 
//Thus, [2,0,2] is returned.
// 
//
// 
// Constraints: 
//
// 
// n == spells.length 
// m == potions.length 
// 1 <= n, m <= 10⁵ 
// 1 <= spells[i], potions[i] <= 10⁵ 
// 1 <= success <= 10¹⁰ 
// 
//
// 👍 1372 👎 30


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            //spell * X = success;
            // x = success / spell;
            int spell = spells[i];
            int target = (int) Math.ceil((double) success / (double) spell);
            int index = binarySearch(potions, target);
            res[i] = potions.length - index;
        }
        return res;
    }

    private int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (found(array[mid], target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == array.length) return left;
        if (!found(array[left], target)) return array.length;
        return left;
    }

    private boolean found(int subject, int target) {
        return subject >= target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SuccessfulPairsOfSpellsAndPotions extends Solution {
}