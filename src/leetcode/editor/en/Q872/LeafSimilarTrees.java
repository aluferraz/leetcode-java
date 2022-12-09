package leetcode.editor.en.Q872;

import java.util.*;

//Consider all the leaves of a binary tree, from left to right order, the 
//values of those leaves form a leaf value sequence. 
//
// 
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
// 8). 
//
// Two binary trees are considered leaf-similar if their leaf value sequence is 
//the same. 
//
// Return true if and only if the two given trees with head nodes root1 and 
//root2 are leaf-similar. 
//
// 
// Example 1: 
// 
// 
//Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,
//null,null,null,null,null,9,8]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root1 = [1,2,3], root2 = [1,3,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each tree will be in the range [1, 200]. 
// Both of the given trees will have values in the range [0, 200]. 
// 
//
// 👍 2367 👎 60

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> leafSequence = new LinkedList<>();
        inOrder(root1, leafSequence);
        if (inOrderCompare(root2, leafSequence)) {
            return leafSequence.isEmpty();
        }
        return false;
    }

    private void inOrder(TreeNode node, LinkedList<Integer> leafSequence) {
        if (node == null) return;
        inOrder(node.left, leafSequence);
        //Self
        if (node.left == null && node.right == null) {
            leafSequence.add(node.val);
        }
        inOrder(node.right, leafSequence);
    }

    private boolean inOrderCompare(TreeNode node, LinkedList<Integer> leafSequence) {
        if (node == null) return true;
        boolean result = true;

        result = result && inOrderCompare(node.left, leafSequence);
        //Self
        if (node.left == null && node.right == null) {
            if (leafSequence.isEmpty()) return false;
            return (node.val == leafSequence.pollFirst());
        }
        result = result && inOrderCompare(node.right, leafSequence);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LeafSimilarTrees extends Solution {
}