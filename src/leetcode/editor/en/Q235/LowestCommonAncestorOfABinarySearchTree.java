package leetcode.editor.en.Q235;

import java.util.*;

import javafx.util.Pair;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) node 
//of two given nodes in the BST. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [2,1], p = 2, q = 1
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the BST. 
// 
//
// 👍 8658 👎 245

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(search(p, q.val)) return p;
        if(search(q, p.val)) return q;
        if(search(root.left,p.val) && search(root.right, q.val) || search(root.left,q.val) && search(root.right, p.val)) return root;
        int max = Math.max(p.val, q.val);
        if(max < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

    private boolean search(TreeNode root, int val){
        if(root == null) return false;
        if(root.val == val) return true;
        if(val < root.val) return search(root.left, val);
        return search(root.right,val);
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class LowestCommonAncestorOfABinarySearchTree extends Solution {
}