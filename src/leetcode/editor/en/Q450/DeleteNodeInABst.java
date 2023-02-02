package leetcode.editor.en.Q450;

import com.sun.source.tree.Tree;
import javafx.util.Pair;

//Given a root node reference of a BST and a key, delete the node with the 
//given key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and 
//delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's 
//also accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
// Follow up: Could you solve it with time complexity O(height of tree)? 
//
// 👍 6901 👎 174
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
 * this.left = left;r
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        Pair<TreeNode, TreeNode> targetAndParent = find(root, key, null);
        if (targetAndParent == null) return root;
        return delete(root, targetAndParent.getKey(), targetAndParent.getValue());
    }

    private TreeNode delete(TreeNode root, TreeNode target, TreeNode parent) {
        if (target.left != null && target.right != null) {
            //Target has both left and right
            TreeNode leftmostChildOfRightSubtree = leftmostChild(target.right);
            int temp = leftmostChildOfRightSubtree.val;
            deleteNode(root, temp);
            target.val = temp;
        } else if (target.left == null && target.right == null) {
            if (parent == null) return null;
            if (target == parent.left) parent.left = null;
            else parent.right = null;
        } else if (target.left == null) {
            if (parent == null) return target.right;
            if (target == parent.left) parent.left = target.right;
            else parent.right = target.right;

        } else if (target.right == null) {
            if (parent == null) return target.left;
            if (target == parent.left) parent.left = target.left;
            else parent.right = target.left;
        }
        return root;

    }

    private TreeNode leftmostChild(TreeNode root) {
        if (root.left == null) return root;
        return leftmostChild(root.left);
    }

    private Pair<TreeNode, TreeNode> find(TreeNode root, int key, TreeNode parent) {
        if (root == null) return null;
        if (root.val == key) return new Pair<>(root, parent);
        if (root.val > key) return find(root.left, key, root);
        return find(root.right, key, root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DeleteNodeInABst extends Solution {
    public TreeNode deleteNode(int key) {
        TreeNode root = new TreeNode(1, null, new TreeNode());
        return super.deleteNode(root, key);

    }

}