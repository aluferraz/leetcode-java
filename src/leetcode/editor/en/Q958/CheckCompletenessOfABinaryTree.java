package leetcode.editor.en.Q958;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree, determine if it is a complete binary tree. 
//
// In a complete binary tree, every level, except possibly the last, is 
//completely filled, and all nodes in the last level are as far left as possible. It can 
//have between 1 and 2ʰ nodes inclusive at the last level h. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values 
//{1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as 
//possible.
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// 1 <= Node.val <= 1000 
// 
//
// 👍 3028 👎 39

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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        int expected = 1;
        int nonNulls = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            if (nonNulls != expected) {
                return lastRowAndFarLeft(q);
            }
            nonNulls = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    nonNulls++;
                }
                q.add(node.left);
                if (node.right != null) {
                    nonNulls++;
                }
                q.add(node.right);
            }
            expected *= 2;
        }
        return true;
    }

    private boolean lastRowAndFarLeft(Queue<TreeNode> row) {
        boolean sawNull = false;
        while (!row.isEmpty()) {
            TreeNode node = row.poll();
            if (node == null) {
                sawNull = true;
            } else {
                if (node.left != null || node.right != null) return false; // This is not the last row
                if (sawNull) return false; //Not as far left as possible
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CheckCompletenessOfABinaryTree extends Solution {
}