package leetcode.editor.en.Q297;

import java.util.*;

//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
//
// 👍 8382 👎 305

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
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
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    int nodeId;
    LinkedList<String> rows;

    class NodeInfo {


        Integer id, val, leftId, rightId;

        NodeInfo(Integer id, Integer val, Integer leftId, Integer rightId) {
            this.id = id;
            this.val = val;
            this.leftId = leftId;
            this.rightId = rightId;
        }

        NodeInfo(String s) {
            String[] info = s.split(":");
            for (int i = 0; i < info.length; i++) {
                switch (i) {
                    case 0:
                        this.id = info[i].isEmpty() ? null : Integer.parseInt(info[i]);
                        break;
                    case 1:
                        this.val = info[i].isEmpty() ? null : Integer.parseInt(info[i]);
                        break;
                    case 2:
                        this.leftId = info[i].isEmpty() ? null : Integer.parseInt(info[i]);
                        break;
                    case 3:
                        this.rightId = info[i].isEmpty() ? null : Integer.parseInt(info[i]);
                        break;
                }
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Integer getLeftId() {
            return leftId;
        }

        public void setLeftId(Integer leftId) {
            this.leftId = leftId;
        }

        public Integer getRightId() {
            return rightId;
        }

        public void setRightId(Integer rightId) {
            this.rightId = rightId;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        nodeId = 0;
        rows = new LinkedList<>();
        serializeHelper(root);
        StringBuilder sb = new StringBuilder();
        while (!rows.isEmpty()) {
            sb.append(rows.pop());
        }
        return sb.toString();
    }

    public void serializeHelper(TreeNode root) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append(nodeId);
        sb.append(":");
        sb.append(root.val);
        sb.append(":");
        if (root.left != null) {
            nodeId++;
            sb.append(nodeId);
            serializeHelper(root.left);
        }
        sb.append(":");
        if (root.right != null) {
            nodeId++;
            sb.append(nodeId);
            serializeHelper(root.right);
        }
        sb.append("!");
        rows.add(sb.toString());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        HashMap<Integer, NodeInfo> nodes = new HashMap<>();
        String[] nodesInfoArray = data.split("!");
        for (String nodeInfoString : nodesInfoArray) {
            NodeInfo node = new NodeInfo(nodeInfoString);
            nodes.put(node.getId(), node);
        }
        return deserializeHelper(0, nodes);

    }

    private TreeNode deserializeHelper(Integer nodeId, HashMap<Integer, NodeInfo> nodes) {
        if (nodeId == null || !nodes.containsKey(nodeId)) return null;
        NodeInfo nodeInfo = nodes.get(nodeId);
        TreeNode root = new TreeNode(nodeInfo.getVal());
        root.left = deserializeHelper(nodeInfo.getLeftId(), nodes);
        root.right = deserializeHelper(nodeInfo.getRightId(), nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


public class SerializeAndDeserializeBinaryTree extends Codec {


    public String serialize() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        return super.serialize(root);
    }


}