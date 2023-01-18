package leetcode.editor.en.Q926;

import java.util.*;

import javafx.util.Pair;

//A binary string is monotone increasing if it consists of some number of 0's (
//possibly none), followed by some number of 1's (also possibly none). 
//
// You are given a binary string s. You can flip s[i] changing it from 0 to 1 
//or from 1 to 0. 
//
// Return the minimum number of flips to make s monotone increasing. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110"
//Output: 1
//Explanation: We flip the last digit to get 00111.
// 
//
// Example 2: 
//
// 
//Input: s = "010110"
//Output: 2
//Explanation: We flip to get 011111, or alternatively 000111.
// 
//
// Example 3: 
//
// 
//Input: s = "00011000"
//Output: 2
//Explanation: We flip to get 00000000.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either '0' or '1'. 
// 
//
// 👍 3036 👎 124


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int minFlips = N; //Worst case - Just to act as a Maximum variable
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zeros++;
            else ones++;
        }
        if (ones == 0 || zeros == 0) return 0;
        minFlips = Math.min(minFlips, zeros); //Let's flip every zero into one as a starting point.
        int onesSoFar = 0;
        int zeroesSoFar = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones--;
                onesSoFar++;
            }
            zeroesSoFar = N - i - 1 - ones;
            minFlips = Math.min(minFlips, (zeroesSoFar + onesSoFar) );
        }
        return minFlips;
    }


// DP Approach:


//    Integer[][] cache;
//
//    public int minFlipsMonoIncr(String s) {
//        cache = new Integer[s.length()][2];
//        return minFlipsMonoIncrHelper(0, false, s);
//    }
//
//    private int minFlipsMonoIncrHelper(int i, boolean sawOne, String s) {
//        if (i == s.length()) {
//            return 0;
//        }
//        int cacheKey = sawOne ? 1 : 0;
//        if (cache[i][cacheKey] != null) {
//            return cache[i][cacheKey];
//        }
//
//        char c = s.charAt(i);
//        //If I saw a one before me, I need to have only ones for now on.
//        int minFlips;
//        if (sawOne) {
//            if (c == '0') {
//                minFlips = 1 + minFlipsMonoIncrHelper(i + 1, sawOne, s);
//            } else {
//                minFlips = minFlipsMonoIncrHelper(i + 1, sawOne, s);
//            }
//        } else {
//            if (c == '0') {
//                minFlips = minFlipsMonoIncrHelper(i + 1, sawOne, s);
//            } else {
//                minFlips = minFlipsMonoIncrHelper(i + 1, true, s); //keep it
//                int minFlipsFliping = 1 + minFlipsMonoIncrHelper(i + 1, false, s); // flip it
//                minFlips = Math.min(minFlips, minFlipsFliping);
//            }
//        }
//        cache[i][cacheKey] = minFlips;
//        return minFlips;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FlipStringToMonotoneIncreasing extends Solution {
}