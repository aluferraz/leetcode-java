package leetcode.editor.en.Q382;

import java.util.*;

import javafx.util.Pair;

//Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen. 
//
// Implement the Solution class: 
//
// 
// Solution(ListNode head) Initializes the object with the head of the singly-
//linked list head. 
// int getRandom() Chooses a node randomly from the list and returns its value. 
//All the nodes of the list should be equally likely to be chosen. 
// 
//
// 
// Example 1: 
// 
// 
//Input
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 3, 2, 2, 3]
// 
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // return 1
//solution.getRandom(); // return 3
//solution.getRandom(); // return 2
//solution.getRandom(); // return 2
//solution.getRandom(); // return 3
//// getRandom() should return either 1, 2, or 3 randomly. Each element should 
//have equal probability of returning.
//
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list will be in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// At most 10⁴ calls will be made to getRandom. 
// 
//
// 
// Follow up: 
//
// 
// What if the linked list is extremely large and its length is unknown to you? 
//
// Could you solve this efficiently without using extra space? 
// 
//
// 👍 2367 👎 558

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
    int size = 0;
    HashMap<Integer, ListNode> nodes = new HashMap<>();
    Random rnd = new Random();

    public Solution(ListNode head) {
        ListNode current = head;
        while (current != null) {
            nodes.put(this.size, current);
            this.size++;
            current = current.next;
        }
    }

    public int getRandom() {
        int index = rnd.nextInt(this.size);
        return this.nodes.get(index).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)


public class LinkedListRandomNode extends Solution {
    public LinkedListRandomNode(ListNode head) {
        super(head);
    }
}