package leetcode.editor.en.Q25;

import java.util.*;

import javafx.util.Pair;

//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
//
// 👍 10253 👎 560

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        if (len == 1 || len == 0) return head;
        ListNode current = head;
        ListNode tail = head;
        ListNode res = null;
        ListNode resTail = null;
        while (len - k >= 0) {
            for (int i = 0; i < (k - 1); i++) {
                tail = tail.next;
            }
            ListNode newHead = tail.next;
            tail.next = null;
            reverseLL(current);
            if (res == null) res = tail;
            if (resTail != null) {
                resTail.next = tail;
            }
            resTail = current;
            current.next = newHead;
            current = newHead;
            tail = newHead;
            len -= k;
        }

        return res;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private void reverseLL(ListNode head) {
        if (head == null) return;
        ListNode prev = null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null) {
            p1.next = prev;
            prev = p1;
            p1 = p2;
            if (p2 != null) {
                p2 = p2.next;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ReverseNodesInKGroup extends Solution {

    public ListNode reverseKGroup(int k) {
        ListNode head = new ListNode(1, new ListNode(2));
        return super.reverseKGroup(head, k);
    }
}