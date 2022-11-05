package leetcode.editor.en.Q21;

//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists in a one sorted list. The list should be made by 
//splicing together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
// 
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
//
// 👍 15714 👎 1383
class ListNode {
    int val;
    public ListNode next;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = null;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        if (pointer1.val < pointer2.val) {
            head = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
        } else {
            head = new ListNode(pointer2.val);
            pointer2 = pointer2.next;
        }
        ListNode current = head;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val < pointer2.val) {
                current.next = new ListNode(pointer1.val);
                pointer1 = pointer1.next;
            } else {
                current.next = new ListNode(pointer2.val);
                pointer2 = pointer2.next;
            }
            current = current.next;
        }
        while (pointer1 != null) {
            current.next = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
            current = current.next;
        }
        while (pointer2 != null) {
            current.next = new ListNode(pointer2.val);
            pointer2 = pointer2.next;
            current = current.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
