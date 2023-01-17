package leetcode.editor.en.Q98;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 👍 13600 👎 1112
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


    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer maxValue, Integer minValue) {
        if (node == null) return true;
        if (maxValue != null && node.val >= maxValue) return false;
        if (minValue != null && node.val <= minValue) return false;
        return isValidBSTHelper(node.left, node.val, minValue) && isValidBSTHelper(node.right, maxValue, node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ValidateBinarySearchTree extends Solution {
}