package leetcode.editor.en.Q369;

import java.util.*;

import javafx.util.Pair;

//Given a non-negative integer represented as a linked list of digits, plus one 
//to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list. 
//
// 
// Example 1: 
// Input: head = [1,2,3]
//Output: [1,2,4]
// 
// Example 2: 
// Input: head = [0]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// The number of nodes in the linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// The number represented by the linked list does not contain leading zeros 
//except for the zero itself. 
// 
//
// 👍 857 👎 41
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
    public ListNode plusOne(ListNode head) {
        Pair<ListNode, Integer> result = plusOneHelper(head);
        //Still have carryOn
        if (result.getValue() != 0) {
            return new ListNode(result.getValue(), result.getKey());
        }
        return result.getKey();
    }

    private Pair<ListNode, Integer> plusOneHelper(ListNode head) {
        if (head == null) {
            return new Pair<>(null, 1);
        }
        Pair<ListNode, Integer> nextAndCarryOn = plusOneHelper(head.next);
        int newNumber = head.val + nextAndCarryOn.getValue();
        int newValue = newNumber % 10;
        int carryOn = newNumber / 10;
        ListNode result = new ListNode(newValue, nextAndCarryOn.getKey());
        return new Pair<>(result, carryOn);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class PlusOneLinkedList extends Solution {
}