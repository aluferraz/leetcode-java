package leetcode.editor.en.Q1721;

import java.util.*;

import javafx.util.Pair;

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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        int length = 0;
        ListNode current = head;
        ListNode beginning = head;
        ListNode end = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        k %= length;
        for (int i = 0; i < k - 1; i++) {
            if (beginning.next == null) break;
            beginning = beginning.next;
        }
        for (int i = 0; i < length - k; i++) {
            if (end.next == null) break;
            end = end.next;
        }

        int temp = beginning.val;
        beginning.val = end.val;
        end.val = temp;
        return head;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SwappingNodesInALinkedList extends Solution {

    public ListNode swapNodes() {
        return super.swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }
}