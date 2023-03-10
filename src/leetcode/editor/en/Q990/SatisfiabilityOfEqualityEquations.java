package leetcode.editor.en.Q990;

import java.util.*;

import javafx.util.Pair;

//You are given an array of strings equations that represent relationships 
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
//
// 👍 3326 👎 50


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] equalities = new int[26];

        Arrays.fill(equalities, -1);

        for (String equation : equations) {
            if (equation.indexOf("==") != -1) {
                int fistLetter = equation.charAt(0) - 'a';
                int lastLetter = equation.charAt(equation.length() - 1) - 'a';

                int rootFirstLetter = find(fistLetter, equalities);
                int rootLastLetter = find(lastLetter, equalities);

                union(rootFirstLetter, rootLastLetter, equalities);
            }
        }
        for (String equation : equations) {

            if (equation.indexOf("!=") != -1) {
                int fistLetter = equation.charAt(0) - 'a';
                int lastLetter = equation.charAt(equation.length() - 1) - 'a';
                int rootFirstLetter = find(fistLetter, equalities);
                int rootLastLetter = find(lastLetter, equalities);
                if (rootFirstLetter == rootLastLetter) return false;
            }
        }

        return true;
    }

    private int find(int i, int[] parents) {
        while (parents[i] >= 0) {
            i = parents[i];
        }
        return i;
    }

    private void union(int i, int j, int[] parents) {
        if (i == j) return;
        if (parents[j] < parents[i]) {
            union(j, i, parents);
            return;
        }
        parents[j] += parents[i];
        parents[i] = j;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SatisfiabilityOfEqualityEquations extends Solution {
}