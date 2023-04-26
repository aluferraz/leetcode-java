package leetcode.editor.en.Q646;

import java.util.*;

import javafx.util.Pair;

//You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and 
//lefti < righti. 
//
// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can 
//be formed in this fashion. 
//
// Return the length longest chain which can be formed. 
//
// You do not need to use up all the given intervals. You can select pairs in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: pairs = [[1,2],[2,3],[3,4]]
//Output: 2
//Explanation: The longest chain is [1,2] -> [3,4].
// 
//
// Example 2: 
//
// 
//Input: pairs = [[1,2],[7,8],[4,5]]
//Output: 3
//Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
// 
//
// 
// Constraints: 
//
// 
// n == pairs.length 
// 1 <= n <= 1000 
// -1000 <= lefti < righti <= 1000 
// 
//
// 👍 2943 👎 113


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer cache[];
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Arrays::compare);
        cache = new Integer[pairs.length];
        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            ans = Math.max(ans, findLongestChain(i, pairs));
        }
        return ans;
    }

    public int findLongestChain(int i, int[][] pairs) {
        if (i == pairs.length) {
            return 0;
        }
        if(cache[i] != null){
            return cache[i];
        }
        int bound = pairs[i][1];
        int ans = 1;
        for (int j = i + 1; j < pairs.length; j++) {
            if (pairs[j][0] > bound) {
                ans = Math.max(ans, 1 + findLongestChain(j, pairs));
            }
        }
        cache[i] = ans;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumLengthOfPairChain extends Solution {
}