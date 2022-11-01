package leetcode.editor.en.Q116;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//You are given a perfect binary tree where all leaves are on the same level,
//and every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no 
//next right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function 
//should populate each next pointer to point to its next right node, just like in 
//Figure B. The serialized output is in level order as connected by the next 
//pointers, with '#' signifying the end of each level.
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
// The number of nodes in the tree is in the range [0, 2¹² - 1]. 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
//
// 👍 7884 👎 266
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

class Solution {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> levelNodes = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            LinkedList<Node> nextLevelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (cur == null) continue;
                if (levelNodes.size() > 0) {
                    cur.next = levelNodes.remove();
                } else {
                    cur.next = null;
                }
                queue.add(cur.left);
                nextLevelNodes.add(cur.left);
                queue.add(cur.right);
                nextLevelNodes.add(cur.right);
            }
            if (nextLevelNodes.size() > 0) nextLevelNodes.remove(); // Sempre um a menos
            levelNodes = nextLevelNodes;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
