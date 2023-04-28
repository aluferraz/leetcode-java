package leetcode.editor.en.Q839;

import java.util.*;

import javafx.util.Pair;

//Two strings X and Y are similar if we can swap two letters (in different 
//positions) of X, so that it equals Y. Also two strings X and Y are similar if they 
//are equal. 
//
// For example, "tars" and "rats" are similar (swapping at positions 0 and 2), 
//and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", 
//or "arts". 
//
// Together, these form two connected groups by similarity: {"tars", "rats", 
//"arts"} and {"star"}. Notice that "tars" and "arts" are in the same group even 
//though they are not similar. Formally, each group is such that a word is in the 
//group if and only if it is similar to at least one other word in the group. 
//
// We are given a list strs of strings where every string in strs is an anagram 
//of every other string in strs. How many groups are there? 
//
// 
// Example 1: 
//
// 
//Input: strs = ["tars","rats","arts","star"]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: strs = ["omv","ovm"]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 300 
// 1 <= strs[i].length <= 300 
// strs[i] consists of lowercase letters only. 
// All words in strs have the same length and are anagrams of each other. 
// 
//
// 👍 1513 👎 189


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSimilarGroups(String[] strs) {
        int[] parents = new int[strs.length];
        Arrays.fill(parents, -1);

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int iParent = find(i, parents);
                    int jParent = find(j, parents);
                    union(iParent, jParent, parents);
                }
            }
        }

        int ans = 0;
        for (int parent : parents) {
            if (parent < 0) {
                ans++;
            }
        }
        return ans;
    }

    private void union(int i, int j, int[] parents) {
        if (i == j) return;
        if (parents[j] < parents[i]) {
            union(j, i, parents);
            return;
        }
        parents[i] += parents[j];
        parents[j] = i;
    }

    private int find(int i, int[] parents) {
        while (parents[i] >= 0) {
            i = parents[i];
        }
        return i;
    }

    private boolean isSimilar(String a, String b) {
        ArrayList<Integer> diffs = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs.add(i);
            }
        }
        if (diffs.size() == 0) return true;
        if (diffs.size() == 2) {
            return a.charAt(diffs.get(0)) == b.charAt(diffs.get(1)) &&
                    a.charAt(diffs.get(1)) == b.charAt(diffs.get(0));
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SimilarStringGroups extends Solution {
}