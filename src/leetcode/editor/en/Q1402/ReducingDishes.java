package leetcode.editor.en.Q1402;

import java.net.Inet4Address;
import java.util.*;

import javafx.util.Pair;

//A chef has collected data on the satisfaction level of his n dishes. Chef can 
//cook any dish in 1 unit of time. 
//
// Like-time coefficient of a dish is defined as the time taken to cook that 
//dish including previous dishes multiplied by its satisfaction level i.e. time[i] * 
//satisfaction[i]. 
//
// Return the maximum sum of like-time coefficient that the chef can obtain 
//after dishes preparation. 
//
// Dishes can be prepared in any order and the chef can discard some dishes to 
//get this maximum value. 
//
// 
// Example 1: 
//
// 
//Input: satisfaction = [-1,-8,0,5,-9]
//Output: 14
//Explanation: After Removing the second and last dish, the maximum total like-
//time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
//Each dish is prepared in one unit of time. 
//
// Example 2: 
//
// 
//Input: satisfaction = [4,3,2]
//Output: 20
//Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
// 
//
// Example 3: 
//
// 
//Input: satisfaction = [-1,-4,-5]
//Output: 0
//Explanation: People do not like the dishes. No dish is prepared.
// 
//
// 
// Constraints: 
//
// 
// n == satisfaction.length 
// 1 <= n <= 500 
// -1000 <= satisfaction[i] <= 1000 
// 
//
// 👍 1995 👎 201


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int mult = 1;
        int positiveSplit = binarySearch(0, satisfaction);
        int rawSum = 0;
        int rawSub = 0;
        for (int i = positiveSplit; i < satisfaction.length; i++) {
            max += (mult * satisfaction[i]);
            rawSum += (satisfaction[i]);
            mult++;
        }

        for (int i = positiveSplit - 1; i >= 0; i--) {
            int subtract = satisfaction[i];
            int consider = ((rawSum + rawSub) + max) + subtract;
            rawSub += satisfaction[i];
            mult++;
            max = Math.max(consider, max);

        }
        return max;
    }

    private int binarySearch(int target, int[] satisfaction) {
        int left = 0;
        int right = satisfaction.length;
        int res = satisfaction.length;
        while (left < right) {
            int mid = Math.floorDiv((left + right), 2);
            if (satisfaction[mid] == target) {
                res = Math.min(res, mid);
                right = mid;
            } else if (satisfaction[mid] < target) {
                left = mid + 1;
            } else {
                res = Math.min(res, mid);
                right = mid;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ReducingDishes extends Solution {
}