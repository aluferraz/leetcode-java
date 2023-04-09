package leetcode.editor.en.Q501;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary search tree (BST) with duplicates, return all the 
//mode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal 
//to the node's key. 
// The right subtree of a node contains only nodes with keys greater than or 
//equal to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count).
//
// 👍 2829 👎 645
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeMap<Integer, Integer> counter = new TreeMap<>();


    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return -Integer.compare(a.getValue(), b.getValue());
        });
        pq.addAll(counter.entrySet());
        ArrayList<Integer> resArrayList = new ArrayList<>();
        int maxCount = pq.peek().getValue();
        while (!pq.isEmpty() && pq.peek().getValue() == maxCount) {
            resArrayList.add(pq.poll().getKey());
        }
        int[] res = new int[resArrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resArrayList.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        counter.put(root.val, counter.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindModeInBinarySearchTree extends Solution {
}