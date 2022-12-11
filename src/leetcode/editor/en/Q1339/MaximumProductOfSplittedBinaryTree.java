package leetcode.editor.en.Q1339;

import java.util.*;

//Given the root of a binary tree, split the binary tree into two subtrees by 
//removing one edge such that the product of the sums of the subtrees is maximized. 
//
//
// Return the maximum product of the sums of the two subtrees. Since the answer 
//may be too large, return it modulo 10⁹ + 7. 
//
// Note that you need to maximize the answer before taking the mod and not 
//after taking it. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6]
//Output: 110
//Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. 
//Their product is 110 (11*10)
// 
//
// Example 2: 
// 
// 
//Input: root = [1,null,2,3,4,null,null,5,6]
//Output: 90
//Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.
//Their product is 90 (15*6)
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 5 * 10⁴]. 
// 1 <= Node.val <= 10⁴ 
// 
//
// 👍 2268 👎 83
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

    //    LinkedList<Long> sums = new LinkedList<>();
    long result = 0L;
    long fullsum = 0L;

    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        fullsum = presumTree(root);
        evaluateMax(root);
        return (int) (result % 1000000007L);
    }


    private long presumTree(TreeNode node) {
        if (node == null) return 0;
        long leftSubtreeSum = presumTree(node.left);
        long rightSubtreeSum = presumTree(node.right);
        return (long) node.val + leftSubtreeSum + rightSubtreeSum;
    }

    private long evaluateMax(TreeNode node) {
        if (node == null) return 0;
        long leftSubtreeSum = evaluateMax(node.left);
        long rightSubtreeSum = evaluateMax(node.right);
        long subtreesum = (long) node.val + leftSubtreeSum + rightSubtreeSum;
        result = Math.max(result, (fullsum - subtreesum) * subtreesum);
        return subtreesum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumProductOfSplittedBinaryTree extends Solution {
}