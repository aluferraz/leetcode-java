package leetcode.editor.en.Q2641;

import java.util.*;

import javafx.util.Pair;

//Given the root of a binary tree, replace the value of each node in the tree 
//with the sum of all its cousins' values. 
//
// Two nodes of a binary tree are cousins if they have the same depth with 
//different parents. 
//
// Return the root of the modified tree. 
//
// Note that the depth of a node is the number of edges in the path from the 
//root node to it. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,4,9,1,10,null,7]
//Output: [0,0,0,7,7,null,11]
//Explanation: The diagram above shows the initial binary tree and the binary 
//tree after changing the value of each node.
//- Node with value 5 does not have any cousins so its sum is 0.
//- Node with value 4 does not have any cousins so its sum is 0.
//- Node with value 9 does not have any cousins so its sum is 0.
//- Node with value 1 has a cousin with value 7 so its sum is 7.
//- Node with value 10 has a cousin with value 7 so its sum is 7.
//- Node with value 7 has cousins with values 1 and 10 so its sum is 11.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,1,2]
//Output: [0,0,0]
//Explanation: The diagram above shows the initial binary tree and the binary 
//tree after changing the value of each node.
//- Node with value 3 does not have any cousins so its sum is 0.
//- Node with value 1 does not have any cousins so its sum is 0.
//- Node with value 2 does not have any cousins so its sum is 0.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁵]. 
// 1 <= Node.val <= 10⁴ 
// 
//
// 👍 179 👎 2
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
    HashMap<Integer, Integer> sumPerDepth = new HashMap<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{
                root,
                null
        });
        int depth = 0;
        HashMap<Integer, HashMap<TreeNode, Integer>> sumCousins = new HashMap<>();


        while (!q.isEmpty()) {
            int size = q.size();
            int depthSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode[] info = q.poll();
                TreeNode node = info[0];
                TreeNode parent = info[1];
                depthSum += node.val;
                sumCousins.computeIfAbsent(depth, (v) -> new HashMap<>()).
                        compute(parent, (k, v) -> {
                            if (v == null) {
                                return node.val;
                            }
                            return v + node.val;
                        });
                if (node.left != null) {
                    q.add(new TreeNode[]{
                            node.left,
                            node
                    });
                }
                if (node.right != null) {
                    q.add(new TreeNode[]{
                            node.right,
                            node
                    });
                }
            }
            sumPerDepth.put(depth, depthSum);
            depth++;
        }

        return dfs(root, null, 0, sumCousins);

    }

    private TreeNode dfs(TreeNode current, TreeNode parent, int depth, HashMap<Integer, HashMap<TreeNode, Integer>> sumCousins) {
        if (current == null) {
            return null;
        }
        TreeNode nodeHere = new TreeNode(0);
        HashMap<TreeNode, Integer> cousins = sumCousins.get(depth);
        Integer sameParentSum = cousins.get(parent);
        Integer totalSum = sumPerDepth.get(depth);
        nodeHere.val = totalSum - sameParentSum;
        nodeHere.left = dfs(current.left, current, depth + 1, sumCousins);
        nodeHere.right = dfs(current.right, current, depth + 1, sumCousins);
        return nodeHere;


    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class CousinsInBinaryTreeIi extends Solution {

    public TreeNode replaceValueInTree() {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(10)), new TreeNode(9, null, new TreeNode(7)));
        ;
        return super.replaceValueInTree(root);
    }

}