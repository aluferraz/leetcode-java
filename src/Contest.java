
import javafx.util.Pair;

import java.util.*;

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

class Solution {

    HashSet<Integer> used = new HashSet<>();
    HashMap<String, TreeNode> trees = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            generateTrees(i, n, ans);
        }

        return trees.values().stream().toList();
    }

    public TreeNode generateTrees(int i, int n, List<TreeNode> ans) {

        used.add(i);
        TreeNode root = new TreeNode(i);
        for (int j = i - 1; j >= 1; j--) {
            if (!used.contains(j)) {
                root.left = generateTrees(j, n, ans);
                if (used.size() == n) {
                    appendResult(root);

                }
            }

        }
        root.left = null;
        for (int j = i + 1; j >= 1; j++) {
            if (!used.contains(j)) {
                root.right = generateTrees(j, n, ans);
                if (used.size() == n) {
                    appendResult(root);

                }
            }

        }


        for (int j = i - 1; j >= 1; j++) {
            if (!used.contains(j)) {
                root.left = generateTrees(j, n, ans);
                for (int k = i + 1; k <= n; k++) {
                    if (!used.contains(k)) {
                        root.right = generateTrees(j, n, ans);
                        if (used.size() == n) {
                            appendResult(root);
                        }
                    }
                }

            }
        }


        used.remove(i);
        return root;

    }

    private void appendResult(TreeNode root) {
        trees.put(treeToString(root).toString(), root);
    }

    private StringBuilder treeToString(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null) {
            sb.append("L:");
            sb.append(treeToString(root.left));
        }
        if (root.right != null) {
            sb.append("R:");
            sb.append(treeToString(root.right));
        }
        return sb;
    }

}

public class Contest extends Solution {
}
/**
 * class Node {
 * <p>
 * public Node next = null;
 * int val;
 * <p>
 * Node(int val) {
 * this.val = val;
 * }
 * <p>
 * Node(int val, Node next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 * <p>
 * class CustomLL {
 * <p>
 * Node head;
 * Node tail;
 * <p>
 * int this.
 * <p>
 * public void add(){
 * <p>
 * }
 * <p>
 * }
 */