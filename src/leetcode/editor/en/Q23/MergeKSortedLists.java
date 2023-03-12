package leetcode.editor.en.Q23;

import java.util.*;

import javafx.util.Pair;

//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// 👍 16154 👎 596

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

    //1 APPROACH - ACCEPTED
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heads = new PriorityQueue<>(Comparator.comparingInt((a) -> a.val));

        for (ListNode list : lists) {
            if (list != null) heads.add(list);
        }
        ListNode res = new ListNode(-1);
        ListNode current = res;

        while (!heads.isEmpty()) {
            ListNode sortedTail = heads.poll();
            ListNode queueHead = sortedTail.next;
            sortedTail.next = null;
            current.next = sortedTail;
            current = current.next;
            if (queueHead != null) heads.add(queueHead);
        }
        return res.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MergeKSortedLists extends Solution {
}