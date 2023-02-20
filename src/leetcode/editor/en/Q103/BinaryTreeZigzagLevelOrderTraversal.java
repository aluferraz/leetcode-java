package leetcode.editor.en.Q103;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 👍 8436 👎 224

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
    private static final int LTR = 0;
    private static final int RTL = 1;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int dir = LTR;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> row = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current == null) continue;
                switch (dir) {
                    case LTR:
                        row.add(current.val);
                        break;
                    case RTL:
                        row.addFirst(current.val);
                        break;
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            dir = (dir + 1) % 2;
            if (!row.isEmpty()) res.add(row);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BinaryTreeZigzagLevelOrderTraversal extends Solution {
}