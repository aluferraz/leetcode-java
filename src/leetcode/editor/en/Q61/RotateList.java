package leetcode.editor.en.Q61;

import java.util.*;

import javafx.util.Pair;

//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
// 
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// 👍 7418 👎 1348
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        k %= len;
        if (k == len || k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < k && fast.next != null) {
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RotateList extends Solution {
}