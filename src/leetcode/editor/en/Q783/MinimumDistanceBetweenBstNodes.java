package leetcode.editor.en.Q783;

import java.util.*;

import javafx.util.Pair;

//Given the root of a Binary Search Tree (BST), return the minimum difference 
//between the values of any two different nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [4,2,6,1,3]
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 100]. 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
// Note: This question is the same as 530: https://leetcode.com/problems/
//minimum-absolute-difference-in-bst/ 
//
// 👍 2157 👎 351
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

    Deque<Integer> values = new LinkedList<>();
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        minDiffInBSTHelper(root);
        return res;
    }

    public void minDiffInBSTHelper(TreeNode root) {
        if(root == null) return ;
        minDiffInBSTHelper(root.left);
        values.add(root.val);
        if(values.size() == 2){
            int diff = Math.abs(values.getFirst() - values.getLast());
            res = Math.min(res, diff);
            values.pollFirst();
        }
        minDiffInBSTHelper(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumDistanceBetweenBstNodes extends Solution {
}