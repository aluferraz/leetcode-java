package leetcode.editor.en.Q203;

import java.util.*;

//Given the head of a linked list and an integer val, remove all the nodes of 
//the linked list that has Node.val == val, and return the new head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
// 
//
// Example 2: 
//
// 
//Input: head = [], val = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 10⁴]. 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// 👍 6582 👎 195
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            while (cur != null && cur.val == val) {
                prev.next = next;
                cur.next = null;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
            prev = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemoveLinkedListElements extends Solution {
}