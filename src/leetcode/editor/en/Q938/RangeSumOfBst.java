package leetcode.editor.en.Q938;

import java.util.*;

//Given the root node of a binary search tree and two integers low and high, 
//return the sum of values of all nodes with a value in the inclusive range [low, 
//high]. 
//
// 
// Example 1: 
// 
// 
//Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//Output: 32
//Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
// 
//
// Example 2: 
// 
// 
//Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//Output: 23
//Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 2 * 10⁴]. 
// 1 <= Node.val <= 10⁵ 
// 1 <= low <= high <= 10⁵ 
// All Node.val are unique. 
// 
//
// 👍 5108 👎 341

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val == high) return root.val + rangeSumBST(root.left, low, high);
        if (root.val == low) return root.val + rangeSumBST(root.right, low, high);
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (low < root.val) { //between
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.right, low, high);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RangeSumOfBst extends Solution {
    public int rangeSumBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        return super.rangeSumBST(root, 7, 15);
    }
}