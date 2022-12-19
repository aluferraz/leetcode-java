package leetcode.editor.en.Q337;

import java.util.*;

//The thief has found himself a new place for his thievery again. There is only 
//one entrance to this area, called root. 
//
// Besides the root, each house has one and only one parent house. After a tour,
// the smart thief realized that all houses in this place form a binary tree. It 
//will automatically contact the police if two directly-linked houses were broken 
//into on the same night. 
//
// Given the root of the binary tree, return the maximum amount of money the 
//thief can rob without alerting the police. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,2,3,null,3,null,1]
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,4,5,1,3,null,1]
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// 
//
// 👍 7262 👎 109
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

class Pair<T, T1> {

    Pair(T t, T1 t1) {

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
    //    Pair
//    HashMap<TreeNode, int[]> cache = new HashMap<>();

    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode node) {
        if (node == null) return new int[2];
//        if (cache.containsKey(node)) return cache.get(node);
        int[] result = new int[2];
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        result[0] = node.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//        cache.put(node, result);
        return result;
    }

    /**
     * Official way:
     *
     * class Solution {
     *     public int[] helper(TreeNode node) {
     *         // return [rob this node, not rob this node]
     *         if (node == null) {
     *             return new int[] { 0, 0 };
     *         }
     *         int left[] = helper(node.left);
     *         int right[] = helper(node.right);
     *         // if we rob this node, we cannot rob its children
     *         int rob = node.val + left[1] + right[1];
     *         // else, we free to choose rob its children or not
     *         int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
     *
     *         return new int[] { rob, notRob };
     *     }
     *
     *     public int rob(TreeNode root) {
     *         int[] answer = helper(root);
     *         return Math.max(answer[0], answer[1]);
     *     }
     * }
     *
     */

}
//leetcode submit region end(Prohibit modification and deletion)


public class HouseRobberIii extends Solution {
}