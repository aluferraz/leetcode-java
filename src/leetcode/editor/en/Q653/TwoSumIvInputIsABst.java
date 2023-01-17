package leetcode.editor.en.Q653;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary search tree and an integer k, return true if there 
//exist two elements in the BST such that their sum is equal to k, or false 
//otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [5,3,6,2,4,null,7], k = 28
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root is guaranteed to be a valid binary search tree. 
// -10⁵ <= k <= 10⁵ 
// 
//
// 👍 5500 👎 236

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

    TreeNode main;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (main == null) {
            main = root;
        }
        // a = k - b;
        int complement = k - root.val;

        if (complement >= root.val) {
            if (search(main, root, complement)) return true;
            return findTarget(root.right, k) || findTarget(root.left, k);
        }
        if ((search(main, root, complement))) return true;
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean search(TreeNode root, TreeNode used, int v) {
        if (root == null) return false;
        if (root.val == v && root != used) return true;
        if (v < root.val) return search(root.left, used, v);
        return search(root.right, used, v);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class TwoSumIvInputIsABst extends Solution {
}