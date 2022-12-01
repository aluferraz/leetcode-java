package leetcode.editor.en.Q2130;

import java.util.*;

//In a linked list of size n, where n is even, the iᵗʰ node (0-indexed) of the 
//linked list is known as the twin of the (n-1-i)ᵗʰ node, if 0 <= i <= (n / 2) - 1.
// 
//
// 
// For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the 
//twin of node 2. These are the only nodes with twins for n = 4. 
// 
//
// The twin sum is defined as the sum of a node and its twin. 
//
// Given the head of a linked list with even length, return the maximum twin 
//sum of the linked list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [5,4,2,1]
//Output: 6
//Explanation:
//Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum 
//= 6.
//There are no other nodes with twins in the linked list.
//Thus, the maximum twin sum of the linked list is 6. 
// 
//
// Example 2: 
// 
// 
//Input: head = [4,2,2,3]
//Output: 7
//Explanation:
//The nodes with twins present in this linked list are:
//- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
//- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
//Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
// 
//
// Example 3: 
// 
// 
//Input: head = [1,100000]
//Output: 100001
//Explanation:
//There is only one node with a twin in the linked list having twin sum of 1 + 1
//00000 = 100001.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is an even integer in the range [2, 10⁵]. 
// 1 <= Node.val <= 10⁵ 
// 
//
// 👍 1310 👎 38


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

class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int result = Integer.MIN_VALUE;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            stack.push(p1.val);
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        //Now p1 is at the middle
        //p1 = p1.next;
        while (p1 != null) {
            result = Math.max(result, p1.val + stack.pop());
            p1 = p1.next;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximumTwinSumOfALinkedList extends Solution {
}