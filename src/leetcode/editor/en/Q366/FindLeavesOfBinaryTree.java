package leetcode.editor.en.Q366;

import java.util.*;

//Given the root of a binary tree, collect a tree's nodes as if you were doing 
//this: 
//
// 
// Collect all the leaf nodes. 
// Remove all the leaf nodes. 
// Repeat until the tree is empty. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5]
//Output: [[4,5,3],[2],[1]]
//Explanation:
//[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers 
//since per each level it does not matter the order on which elements are returned.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 👍 2908 👎 51

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> nodePerLevel = new HashMap<>();

        findLeavesRecursive(root, nodePerLevel);
        for (int i = 0; i < 100; i++) {
            if (!nodePerLevel.containsKey(i)) break;
            result.add(nodePerLevel.get(i));
        }
        return result;
    }


    private int findLeavesRecursive(TreeNode node, HashMap<Integer, List<Integer>> result) {
        if (node == null) return 0;
        int leftHeight = findLeavesRecursive(node.left, result);
        int rightHeight = findLeavesRecursive(node.right, result);
        int selfHeight = Math.max(leftHeight, rightHeight);
        if (result.containsKey(selfHeight)) {
            ArrayList<Integer> nodes = (ArrayList<Integer>) result.get(selfHeight);
            nodes.add(node.val);
        } else {
            ArrayList<Integer> nodes = new ArrayList<>();
            nodes.add(node.val);
            result.put(selfHeight, nodes);
        }
        return 1 + selfHeight;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindLeavesOfBinaryTree extends Solution {
}