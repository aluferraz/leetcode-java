package leetcode.editor.en.Q1602;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree and a node u in the tree, return the nearest 
//node on the same level that is to the right of u, or return null if u is the 
//rightmost node in its level. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,4,5,6], u = 4
//Output: 5
//Explanation: The nearest node on the same level to the right of node 4 is 
//node 5.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,null,4,2], u = 2
//Output: null
//Explanation: There are no nodes to the right of 2.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁵]. 
// 1 <= Node.val <= 10⁵ 
// All values in the tree are distinct. 
// u is a node in the binary tree rooted at root. 
// 
//
// 👍 296 👎 9

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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.equals(u)) {
                    return i == size - 1 ? null : q.poll();
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindNearestRightNodeInBinaryTree extends Solution {
}