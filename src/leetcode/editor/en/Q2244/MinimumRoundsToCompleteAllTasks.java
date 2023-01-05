package leetcode.editor.en.Q2244;

import java.util.*;

//You are given a 0-indexed integer array tasks, where tasks[i] represents the 
//difficulty level of a task. In each round, you can complete either 2 or 3 tasks 
//of the same difficulty level. 
//
// Return the minimum rounds required to complete all the tasks, or -1 if it is 
//not possible to complete all the tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = [2,2,3,3,2,4,4,4,4,4]
//Output: 4
//Explanation: To complete all the tasks, a possible plan is:
//- In the first round, you complete 3 tasks of difficulty level 2. 
//- In the second round, you complete 2 tasks of difficulty level 3. 
//- In the third round, you complete 3 tasks of difficulty level 4. 
//- In the fourth round, you complete 2 tasks of difficulty level 4.  
//It can be shown that all the tasks cannot be completed in fewer than 4 rounds,
// so the answer is 4.
// 
//
// Example 2: 
//
// 
//Input: tasks = [2,3,3]
//Output: -1
//Explanation: There is only 1 task of difficulty level 2, but in each round, 
//you can only complete either 2 or 3 tasks of the same difficulty level. Hence, 
//you cannot complete all the tasks, and the answer is -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= tasks.length <= 10⁵ 
// 1 <= tasks[i] <= 10⁹ 
// 
//
// 👍 1327 👎 35


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[] cache;

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        cache = new Integer[tasks.length];
        int minimum = minimumRoundsHelper(tasks, 0);
        return minimum >= 1000000000 ? -1 : minimum;
    }


    private int minimumRoundsHelper(int[] tasks, int left) {
        if (left == tasks.length) {
            return 0;
        }
        if (cache[left] != null) return cache[left];
        int minimum = 1000000001;
        if (left + 1 < tasks.length && tasks[left + 1] == tasks[left]) {
            minimum = 1 + minimumRoundsHelper(tasks, left + 2);
            if (left + 2 < tasks.length && tasks[left + 2] == tasks[left]) {
                int takeThree = (1 + minimumRoundsHelper(tasks, left + 3));
                minimum = Math.min(minimum, takeThree);
            }
        }
        cache[left] = minimum;
        return minimum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumRoundsToCompleteAllTasks extends Solution {
}