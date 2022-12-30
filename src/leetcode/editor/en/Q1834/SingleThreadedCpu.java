package leetcode.editor.en.Q1834;

import java.util.*;

//You are given n tasks labeled from 0 to n - 1 represented by a 2D integer 
//array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the ith 
//task will be available to process at enqueueTimei and will take processingTimei to 
//finish processing. 
//
// You have a single-threaded CPU that can process at most one task at a time 
//and will act in the following way: 
//
// 
// If the CPU is idle and there are no available tasks to process, the CPU 
//remains idle. 
// If the CPU is idle and there are available tasks, the CPU will choose the 
//one with the shortest processing time. If multiple tasks have the same shortest 
//processing time, it will choose the task with the smallest index. 
// Once a task is started, the CPU will process the entire task without 
//stopping. 
// The CPU can finish a task then start a new one instantly. 
// 
//
// Return the order in which the CPU will process the tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
//Output: [0,2,3,1]
//Explanation: The events go as follows: 
//- At time = 1, task 0 is available to process. Available tasks = {0}.
//- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {
//}.
//- At time = 2, task 1 is available to process. Available tasks = {1}.
//- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
//- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as 
//it is the shortest. Available tasks = {1}.
//- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
//- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is 
//the shortest. Available tasks = {1}.
//- At time = 6, the CPU finishes task 3 and starts processing task 1. 
//Available tasks = {}.
//- At time = 10, the CPU finishes task 1 and becomes idle.
// 
//
// Example 2: 
//
// 
//Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
//Output: [4,3,2,0,1]
//Explanation: The events go as follows:
//- At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
//- Also at time = 7, the idle CPU starts processing task 4. Available tasks = {
//0,1,2,3}.
//- At time = 9, the CPU finishes task 4 and starts processing task 3. 
//Available tasks = {0,1,2}.
//- At time = 13, the CPU finishes task 3 and starts processing task 2. 
//Available tasks = {0,1}.
//- At time = 18, the CPU finishes task 2 and starts processing task 0. 
//Available tasks = {1}.
//- At time = 28, the CPU finishes task 0 and starts processing task 1. 
//Available tasks = {}.
//- At time = 40, the CPU finishes task 1 and becomes idle.
// 
//
// 
// Constraints: 
//
// 
// tasks.length == n 
// 1 <= n <= 10⁵ 
// 1 <= enqueueTimei, processingTimei <= 10⁹ 
// 
//
// 👍 1706 👎 164


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getOrder(int[][] tasks) {

        int[] result = new int[tasks.length];

        LinkedList<int[]> tasksFull = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            int enqueueTime = tasks[i][0];
            int taskTime = tasks[i][1];
            tasksFull.add(new int[]{enqueueTime, taskTime, i});
        }

        Collections.sort(tasksFull, Comparator.comparingInt(a -> a[0]));

        int busyUntil = 0;
        int resultIdx = 0;
        int time = tasksFull.peek()[0];

        PriorityQueue<int[]> executionQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });

        while (!tasksFull.isEmpty() || !executionQueue.isEmpty()) {
            while (!tasksFull.isEmpty() && tasksFull.peek()[0] <= time) {
                executionQueue.add(tasksFull.poll());
            }
            if (!executionQueue.isEmpty()) {
                int[] nextTask = executionQueue.poll();
                busyUntil = time + nextTask[1];
                result[resultIdx] = nextTask[2];
                resultIdx++;
            }
            if (busyUntil > time) {
                time = busyUntil;
            } else if (!tasksFull.isEmpty()) {
                time = tasksFull.peek()[0];
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SingleThreadedCpu extends Solution {
}