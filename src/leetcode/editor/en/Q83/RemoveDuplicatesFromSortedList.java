package leetcode.editor.en.Q83;

import java.util.*;

//Given the head of a sorted linked list, delete all duplicates such that each 
//element appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
//
// 👍 6538 👎 226

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != null) {
            while (p2 != null && p1.val == p2.val) {
                p2 = p2.next;

            }
            p1.next = p2;
            p1 = p2;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemoveDuplicatesFromSortedList extends Solution {
}