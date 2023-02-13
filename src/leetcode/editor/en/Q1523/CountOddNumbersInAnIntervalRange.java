package leetcode.editor.en.Q1523;
import java.util.*;
import javafx.util.Pair;

//Given two non-negative integers low and high. Return the count of odd numbers 
//between low and high (inclusive). 
//
// 
// Example 1: 
//
// 
//Input: low = 3, high = 7
//Output: 3
//Explanation: The odd numbers between 3 and 7 are [3,5,7]. 
//
// Example 2: 
//
// 
//Input: low = 8, high = 10
//Output: 1
//Explanation: The odd numbers between 8 and 10 are [9]. 
//
// 
// Constraints: 
//
// 
// 0 <= low <= high <= 10^9 
// 
//
// 👍 1591 👎 103


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countOdds(int low, int high) {
        double tot =  (double)(high - low) + 1.0;
        if(low % 2 == 1 || high % 2 == 1) return (int) Math.ceil( tot / 2.0);
        return (int) Math.floor(tot / 2.0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class CountOddNumbersInAnIntervalRange extends Solution {}