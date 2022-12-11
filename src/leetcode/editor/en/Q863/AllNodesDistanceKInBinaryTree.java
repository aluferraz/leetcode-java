package leetcode.editor.en.Q863;

import java.util.*;

//Given the root of a binary tree, the value of a target node target, and an 
//integer k, return an array of the values of all nodes that have a distance k from 
//the target node. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 
//5) have values 7, 4, and 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], target = 1, k = 3
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 500]. 
// 0 <= Node.val <= 500 
// All the values Node.val are unique. 
// target is the value of one of the nodes in the tree. 
// 0 <= k <= 1000 
// 
//
// 👍 7814 👎 157


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    HashMap<TreeNode, TreeNode> parents = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();
        findTarget(root, null, target);
        dfsK(target, result, k);
        return result;

    }

    private void dfsK(TreeNode node, List<Integer> result, int k) {
        if (node == null) return;
        if (visited.contains(node)) return;
        visited.add(node);
        if (k == 0) {
            result.add(node.val);
            return;
        }
        if (k < 0) return;
        if (node.left != null && !visited.contains(node.left)) dfsK(node.left, result, k - 1);
        if (node.right != null && !visited.contains(node.right)) dfsK(node.right, result, k - 1);
        if (parents.containsKey(node)) {
            TreeNode parent = parents.get(node);
            if (parent != null && !visited.contains(parent)) {
                dfsK(parent, result, k - 1);
            }
        }
    }

    private void findTarget(TreeNode node, TreeNode parent, TreeNode target) {
        if (node == null) return;
        parents.put(node, parent);
        if (node == target) return;
        findTarget(node.left, node, target);
        findTarget(node.right, node, target);

    }
}