package leetcode.editor.en.Q109;

import java.util.*;

import javafx.util.Pair;

//Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height-balanced binary search tree. 
//
// 
// Example 1: 
// 
// 
//Input: head = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the 
//shown height balanced BST.
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in head is in the range [0, 2 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 👍 6112 👎 133
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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

    // 1-> 2 -> 3
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head);
    }

    private TreeNode buildTree(ListNode head) {
        if (head == null) return null;
        ListNode middlePrev = getMiddle(head);
        ListNode middle = middlePrev.next;
        if (middle == null) return new TreeNode(head.val);
        TreeNode root = new TreeNode(middle.val);
        middlePrev.next = null;
        if (head != middle) root.left = buildTree(head);
        root.right = buildTree(middle.next);
        return root;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = new ListNode(Integer.MIN_VALUE,head);
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ConvertSortedListToBinarySearchTree extends Solution {
}