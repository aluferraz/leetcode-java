package leetcode.editor.en.Q99;

import java.util.*;

//You are given the root of a binary search tree (BST), where the values of 
//exactly two nodes of the tree were swapped by mistake. Recover the tree without 
//changing its structure. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 
//makes the BST valid.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 
//and 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//Follow up: A solution using 
//O(n) space is pretty straight-forward. Could you devise a constant 
//O(1) space solution?
//
// 👍 6516 👎 218
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

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        recoverTreeHelper(root, Integer.MIN_VALUE, null, Integer.MAX_VALUE, null);
    }

    private boolean recoverTreeHelper(TreeNode root, int minValue, TreeNode minValueNode, int maxValue, TreeNode maxValueNode) {
        if (root == null) return false;
        int temp;
        if (root.left != null && root.right != null && root.left.val >= root.val && root.right.val < root.val) {
            temp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = temp;
            return true;
        }


        if (minValue < root.val && root.val <= maxValue) {
            return recoverTreeHelper(root.left, minValue, minValueNode, root.val, root) ||
                    recoverTreeHelper(root.right, root.val, root, maxValue, maxValueNode);
        } else {

            if (root.val < minValue) {
                temp = root.val;
                root.val = minValue;
                minValueNode.val = temp;
            } else {
                if (!recoverTreeHelper(root, Integer.MIN_VALUE, null, Integer.MAX_VALUE, null)) {
                    temp = root.val;
                    root.val = maxValue;
                    maxValueNode.val = temp;
                }
            }
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RecoverBinarySearchTree extends Solution {
}