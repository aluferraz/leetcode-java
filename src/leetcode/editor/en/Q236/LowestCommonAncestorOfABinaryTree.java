package leetcode.editor.en.Q236;

import java.util.*;

import com.sun.source.tree.Tree;
import javafx.util.Pair;

//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
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
// p and q will exist in the tree. 
// 
//
// 👍 13388 👎 321

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
        if (p == q) return p;
        int pLevel = getLevel(root, p);
        int qLevel = getLevel(root, q);


        HashMap<TreeNode, TreeNode> pParents = new HashMap<>();
        setParents(root, p, null, pParents);
        HashMap<TreeNode, TreeNode> qParents = new HashMap<>();
        setParents(root, q, null, qParents);

        while (pLevel > qLevel) {
            //Move p up
            p = pParents.get(p);
            pLevel--;
        }
        while (qLevel > pLevel) {
            //Move q up
            q = qParents.get(q);
            qLevel--;
        }

        while (p != q) {
            p = pParents.get(p);
            q = qParents.get(q);
        }
        return p;
    }


    private void setParents(TreeNode root, TreeNode target, TreeNode parent, HashMap<TreeNode, TreeNode> result) {
        if (root == null) return;
        result.put(root, parent);
        if (root == target) {
            return;
        }
        setParents(root.left, target, root, result);
        setParents(root.right, target, root, result);
    }

    private int getLevel(TreeNode root, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current == target) {
                    return level;
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            level++;
        }
        return level;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LowestCommonAncestorOfABinaryTree extends Solution {
}