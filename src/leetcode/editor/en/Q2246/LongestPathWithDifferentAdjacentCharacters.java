package leetcode.editor.en.Q2246;

import javafx.util.Pair;

import java.util.*;

//You are given a tree (i.e. a connected, undirected graph that has no cycles) 
//rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is 
//represented by a 0-indexed array parent of size n, where parent[i] is the parent of 
//node i. Since node 0 is the root, parent[0] == -1. 
//
// You are also given a string s of length n, where s[i] is the character 
//assigned to node i. 
//
// Return the length of the longest path in the tree such that no pair of 
//adjacent nodes on the path have the same character assigned to them. 
//
// 
// Example 1: 
// 
// 
//Input: parent = [-1,0,0,1,1,2], s = "abacbe"
//Output: 3
//Explanation: The longest path where each two adjacent nodes have different 
//characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3
// is returned.
//It can be proven that there is no longer path that satisfies the conditions. 
// 
//
// Example 2: 
// 
// 
//Input: parent = [-1,0,0,0], s = "aabc"
//Output: 3
//Explanation: The longest path where each two adjacent nodes have different 
//characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is 
//returned.
// 
//
// 
// Constraints: 
//
// 
// n == parent.length == s.length 
// 1 <= n <= 10⁵ 
// 0 <= parent[i] <= n - 1 for all i >= 1 
// parent[0] == -1 
// parent represents a valid tree. 
// s consists of only lowercase English letters. 
// 
//
// 👍 1199 👎 26


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int res = 0;
    Integer[] cache;

    public int longestPath(int[] parent, String s) {
        HashMap<Integer, ArrayList<Integer>> adjList = makeAdjList(parent);
        int N = s.length();
        cache = new Integer[N];
        for (int i = N - 1; i >= 0; i--) {
            dfs(i, parent[i], adjList, s);
        }

        return res;
    }

    private Integer dfs(int node,
                        int parent,
                        HashMap<Integer, ArrayList<Integer>> adjList,
                        String s
    ) {
        if (cache[node] != null) {
            return cache[node];
        }
        char c = s.charAt(node);
        int maxAsRoot = 1;
        int maxAsPath = 1;
        int maxBranch = 0;
        int[] longestPaths = new int[2];


        if (adjList.containsKey(node)) {
            ArrayList<Integer> edges = adjList.get(node);
            for (int nextNode : edges) {
                if (nextNode != parent) {
                    char adjLetter = s.charAt(nextNode);
                    if (adjLetter != c) {
                        //Not adjacent, can visit
                        Integer path = dfs(nextNode, node, adjList, s);
                        insert(longestPaths, path);
                        maxBranch = Math.max(maxBranch, path);
                    }
                }
            }
        }
        maxAsPath += maxBranch;
        maxAsRoot += longestPaths[0];
        maxAsRoot += longestPaths[1];


        res = Math.max(res, maxAsRoot);
//        cache[node] = new Integer[]{maxAsRoot, maxAsPath};
        cache[node] = maxAsPath;
        return cache[node];

    }

    private void insert(int[] arr, int i) {
        if (i > arr[0]) {
            arr[1] = arr[0];
            arr[0] = i;
            return;
        }
        if (i > arr[1]) {
            arr[1] = i;
        }
    }


    private HashMap<Integer, ArrayList<Integer>> makeAdjList(int[] parent) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int i = parent.length - 1; i >= 0; i--) {
            int pNode = parent[i];
            int node = i;
            adjList.computeIfAbsent(pNode, value -> new ArrayList<Integer>()).add(i);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestPathWithDifferentAdjacentCharacters extends Solution {
}