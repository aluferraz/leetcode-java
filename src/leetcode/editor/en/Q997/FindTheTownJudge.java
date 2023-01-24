package leetcode.editor.en.Q997;

import java.util.*;

import javafx.util.Pair;

//In a town, there are n people labeled from 1 to n. There is a rumor that one 
//of these people is secretly the town judge. 
//
// If the town judge exists, then: 
//
// 
// The town judge trusts nobody. 
// Everybody (except for the town judge) trusts the town judge. 
// There is exactly one person that satisfies properties 1 and 2. 
// 
//
// You are given an array trust where trust[i] = [ai, bi] representing that the 
//person labeled ai trusts the person labeled bi. 
//
// Return the label of the town judge if the town judge exists and can be 
//identified, or return -1 otherwise. 
//
// 
// Example 1: 
//
// 
//Input: n = 2, trust = [[1,2]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: n = 3, trust = [[1,3],[2,3]]
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 10⁴ 
// trust[i].length == 2 
// All the pairs of trust are unique. 
// ai != bi 
// 1 <= ai, bi <= n 
// 
//
// 👍 4637 👎 365


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            if (n == 1) return 1;
            return -1;
        }
        boolean[] trust_someone = new boolean[n + 1];
        int[] trusted_by = new int[n + 1];

        for (int[] pair : trust) {
            trust_someone[pair[0]] = true;
            trusted_by[pair[1]] += 1;

        }
        for (int i = 1; i <= n; i++) {
            if (trusted_by[i] == n - 1 && !trust_someone[i]) return i;
        }

        return -1;


    }
//    public int findJudge(int n, int[][] trust) {
//        if (trust.length == 0) {
//            if (n == 1) return 1;
//            return -1;
//        }
//        HashMap<Integer, HashSet<Integer>> trustees = new HashMap<>();
//        for (int[] pair : trust) {
//            trustees.computeIfAbsent(pair[0], (k) -> new HashSet()).add(pair[1]);
//        }
//        int trustNoOne = -1;
//        for (int i = 1; i <= n; i++) {
//            if (!trustees.containsKey(i)) {
//                if (trustNoOne == -1) {
//                    trustNoOne = i;
//                } else {
//                    return -1;
//                }
//            }
//        }
//
//        for (HashSet<Integer> trusts : trustees.values()) {
//            if (!trusts.contains(trustNoOne)) return -1;
//        }
//        return trustNoOne;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindTheTownJudge extends Solution {
}