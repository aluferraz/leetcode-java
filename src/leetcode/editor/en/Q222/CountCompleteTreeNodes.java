package leetcode.editor.en.Q222;

import java.util.*;

//Given the root of a complete binary tree, return the number of the nodes in 
//the tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far 
//left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 10⁴]. 
// 0 <= Node.val <= 5 * 10⁴ 
// The tree is guaranteed to be complete. 
// 
//
// 👍 6281 👎 357


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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = dfsCount(root, 0, 'L');
        int rcount = dfsCount(root, 0, 'R');
        if (rcount == count) return count;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;

    }

    private int dfsCount(TreeNode node, int counter, char direction) {
        int nodeCount = (int) Math.pow(2, counter);
        if (node == null) {
            return 0;
        }
        int result;
        if (direction == 'L') {
            result = nodeCount + dfsCount(node.left, counter + 1, direction);
        } else {
            result = nodeCount + dfsCount(node.right, counter + 1, direction);
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class CountCompleteTreeNodes extends Solution {
    public int countNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(12);
        root.right.right = new TreeNode(7);
        return super.countNodes(root);
    }
}