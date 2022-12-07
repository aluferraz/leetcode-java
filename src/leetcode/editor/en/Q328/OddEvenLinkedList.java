package leetcode.editor.en.Q328;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;

//Given the head of a singly linked list, group all the nodes with odd indices 
//together followed by the nodes with even indices, and return the reordered list. 
//
//
// The first node is considered odd, and the second node is even, and so on. 
//
// Note that the relative order inside both the even and odd groups should 
//remain as it was in the input. 
//
// You must solve the problem in O(1) extra space complexity and O(n) time 
//complexity. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
// 
//
// Example 2: 
// 
// 
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list is in the range [0, 10⁴]. 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// 👍 7011 👎 415
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


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        if (size == 2) return head;
        size = Math.floorDiv(size, 2);
        ListNode prev = head;
        ListNode current = head.next;
        for (int i = 1; i <= size; i++) {
            prev.next = current.next;
            current.next = null;
            tail.next = current;
            tail = tail.next;
            prev = prev.next;
            current = prev.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class OddEvenLinkedList extends Solution {
}