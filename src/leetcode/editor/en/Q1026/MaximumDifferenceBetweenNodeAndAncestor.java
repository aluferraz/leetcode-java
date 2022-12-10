package leetcode.editor.en.Q1026;

import com.sun.source.tree.Tree;

import java.util.*;

//Given the root of a binary tree, find the maximum value v for which there 
//exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b. 
//
// A node a is an ancestor of b if either: any child of a is equal to b or any 
//child of a is an ancestor of b. 
//
// 
// Example 1: 
// 
// 
//Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
//Output: 7
//Explanation: We have various ancestor-node differences, some of which are 
//given below :
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//Among all possible differences, the maximum value of 7 is obtained by |8 - 1| 
//= 7. 
//
// Example 2: 
// 
// 
//Input: root = [1,null,2,null,0,3]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 5000]. 
// 0 <= Node.val <= 10⁵ 
// 
//
// 👍 3237 👎 80

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

class Solution {
    private int v = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return v;
    }

    private void dfs(TreeNode node, int biggestAncestor, int smallestAncestor) {
        if (node == null) return;
        int diff = Math.abs(node.val - biggestAncestor);
        diff = Math.max(Math.abs(node.val - smallestAncestor), diff);
        v = Math.max(diff, v);
        if (node.left != null)
            dfs(node.left, Math.max(biggestAncestor, node.val), Math.min(node.val, smallestAncestor));
        if (node.right != null)
            dfs(node.right, Math.max(biggestAncestor, node.val), Math.min(node.val, smallestAncestor));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumDifferenceBetweenNodeAndAncestor extends Solution {
}