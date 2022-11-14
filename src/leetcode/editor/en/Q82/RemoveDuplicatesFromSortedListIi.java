package leetcode.editor.en.Q82;

import java.util.*;

//Given the head of a sorted linked list, delete all nodes that have duplicate 
//numbers, leaving only distinct numbers from the original list. Return the linked 
//list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,1,2,3]
//Output: [2,3]
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
// 👍 6868 👎 185


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
        if (head == null) return head;
        ListNode newHead = new ListNode(-1); //Dummy
        ListNode prev = newHead;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null) {
            while (p2 != null && p1.val == p2.val) {
                int repeated = p1.val;
                while (p1 != null && p1.val == repeated) {
                    p1 = p2;
                    if (p2 != null) p2 = p2.next;
                }
            }

            prev.next = p1;
            prev = p1;
            p1 = p2;
            if (p2 != null) p2 = p2.next;

        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class ListNode {
    int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class RemoveDuplicatesFromSortedListIi extends Solution {

}