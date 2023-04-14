package leetcode.editor.en.Q946;

import java.util.*;

import javafx.util.Pair;

//Given two integer arrays pushed and popped each with distinct values, return 
//true if this could have been the result of a sequence of push and pop operations 
//on an initially empty stack, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4),
//pop() -> 4,
//push(5),
//pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// Example 2: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// All the elements of pushed are unique. 
// popped.length == pushed.length 
// popped is a permutation of pushed. 
// 
//
// 👍 4622 👎 85


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //If the number is ahead, we can go for it
        //If it's not, it must be the tail.
        HashSet<Integer> forwardSet = new HashSet<>();
        LinkedList<Integer> forward = new LinkedList<>();
        LinkedList<Integer> popQueue = new LinkedList<>();
        LinkedList<Integer> pushQueue = new LinkedList<>();

        for (int num : pushed) {
            forwardSet.add(num);
            forward.add(num);
        }
        for (int pop : popped) {
            popQueue.add(pop);
        }

        while (!popQueue.isEmpty()) {
            int target = popQueue.poll();
            if (forwardSet.contains(target)) {
                while (!forwardSet.isEmpty()) {
                    int next = forward.poll();
                    forwardSet.remove(next);
                    if (next == target) {
                        break;
                    }
                    pushQueue.add(next);
                }
            } else {
                if (pushQueue.isEmpty() || target != pushQueue.peekLast()) return false;
                pushQueue.pollLast();
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ValidateStackSequences extends Solution {
}