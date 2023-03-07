package leetcode.editor.en.Q968;

//You are given the root of a binary tree. We install cameras on the tree nodes
//where each camera at a node can monitor its parent, itself, and its immediate 
//children. 
//
// Return the minimum number of cameras needed to monitor all nodes of the tree.
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [0,0,null,0,0]
//Output: 1
//Explanation: One camera is enough to monitor all nodes if placed as shown.
// 
//
// Example 2: 
// 
// 
//Input: root = [0,0,null,0,null,0,null,null,0]
//Output: 2
//Explanation: At least two cameras are needed to monitor all nodes of the tree.
// The above image shows one of the valid configurations of camera placement.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// Node.val == 0 
// 
//
// 👍 4733 👎 62

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    private static final int CAN_SEE = 1;
    HashMap<Pair<TreeNode, Integer>, Integer> cache = new HashMap<>();

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int initialValue = root.val;
        Pair<TreeNode, Integer> cacheKey = new Pair<>(root, initialValue);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        int startingFromLeft = Integer.MAX_VALUE;
        int startingFromRight = Integer.MAX_VALUE;
        int skipRoot = Integer.MAX_VALUE;

        if (root.left != null && root.val == 0) {
            installCamera(root.left, root);
            startingFromLeft = 1 + minCameraCover(root.left) + minCameraCover(root.right);
            removeCamera(root.left, root);
        }
        if (root.right != null && root.val == 0) {
            installCamera(root.right, root);
            startingFromRight = 1 + minCameraCover(root.left) + minCameraCover(root.right);
            removeCamera(root.right, root);
        }
        int startingFromChildren = Math.min(startingFromRight, startingFromLeft);
        if (root.val != 0) {
            skipRoot = minCameraCover(root.left) + minCameraCover(root.right);
        }
        installCamera(root, null);
        int startingFromRoot = 1 + minCameraCover(root.left) + minCameraCover(root.right);
        removeCamera(root, null);


        int res = Math.min(skipRoot, Math.min(startingFromRoot, startingFromChildren));
        cache.put(cacheKey, res);
        return res;
    }

    private void installCamera(TreeNode node, TreeNode parent) {
        if (node == null) return;
        node.val = 1;
        if (parent != null) parent.val = -1;
        if (node.left != null) node.left.val = 2;
        if (node.right != null) node.right.val = 3;
    }

    private void removeCamera(TreeNode node, TreeNode parent) {
        if (node == null) return;
        node.val = 0;
        if (parent != null) parent.val = 0;
        if (node.left != null) node.left.val = 0;
        if (node.right != null) node.right.val = 0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


public class BinaryTreeCameras extends Solution {
}