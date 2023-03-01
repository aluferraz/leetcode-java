package leetcode.editor.en.Q652;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree, return all duplicate subtrees. 
//
// For each kind of duplicate subtrees, you only need to return the root node 
//of any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
// 
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
// 
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 5000] 
// -200 <= Node.val <= 200 
// 
//
// 👍 4467 👎 366

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
    HashMap<String, TreeNode> counter = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializeTree(root);
        List<TreeNode> res = new ArrayList<>();
        for (Map.Entry<String, TreeNode> kv : counter.entrySet()) {
            if (kv.getValue() != null) {
                res.add(kv.getValue());
            }
        }
        return res;

    }
    private String serializeTree(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder serialized = new StringBuilder();
        serialized.append("T:[");
        serialized.append(root.val);
        serialized.append("]L:[");
        serialized.append(serializeTree(root.left));
        serialized.append("]R:[");
        serialized.append(serializeTree(root.right));
        serialized.append("]");
        String rootStr = serialized.toString();
        if (counter.containsKey(rootStr)) {
            counter.put(rootStr, root);
        } else {
            counter.put(rootStr, null);
        }
        return rootStr;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindDuplicateSubtrees extends Solution {

    public List<TreeNode> findDuplicateSubtrees() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        return super.findDuplicateSubtrees(root);
    }
}