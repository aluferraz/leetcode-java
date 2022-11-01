package leetcode.editor.en.Q617;

//You are given two binary trees root1 and root2. 
//
// Imagine that when you put one of them to cover the other, some nodes of the 
//two trees are overlapped while the others are not. You need to merge the two 
//trees into a new binary tree. The merge rule is that if two nodes overlap, then sum 
//node values up as the new value of the merged node. Otherwise, the NOT null 
//node will be used as the node of the new tree. 
//
// Return the merged tree. 
//
// Note: The merging process must start from the root nodes of both trees. 
//
// 
// Example 1: 
// 
// 
//Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//Output: [3,4,5,5,4,null,7]
// 
//
// Example 2: 
//
// 
//Input: root1 = [1], root2 = [1,2]
//Output: [2,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 2000]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// 👍 7480 👎 263

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesHelper(root1, root2);
    }

    public TreeNode mergeTreesHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return null;
        TreeNode newNode;
        if (node1 != null && node2 == null) {
            newNode = new TreeNode(node1.val, null, null);
            newNode.left = mergeTreesHelper(node1.left, null);
            newNode.right = mergeTreesHelper(node1.right, null);
        } else if (node1 == null && node2 != null) {
            newNode = new TreeNode(node2.val, null, null);
            newNode.left = mergeTreesHelper(null, node2.left);
            newNode.right = mergeTreesHelper(null, node2.right);
        } else {
            newNode = new TreeNode(node1.val + node2.val, null, null);
            newNode.left = mergeTreesHelper(node1.left, node2.left);
            newNode.right = mergeTreesHelper(node1.right, node2.right);
        }
        return newNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
