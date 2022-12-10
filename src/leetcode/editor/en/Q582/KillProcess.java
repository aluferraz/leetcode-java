package leetcode.editor.en.Q582;

import java.util.*;

//You have n processes forming a rooted tree structure. You are given two 
//integer arrays pid and ppid, where pid[i] is the ID of the iᵗʰ process and ppid[i] is 
//the ID of the iᵗʰ process's parent process. 
//
// Each process has only one parent process but may have multiple children 
//processes. Only one process has ppid[i] = 0, which means this process has no parent 
//process (the root of the tree). 
//
// When a process is killed, all of its children processes will also be killed. 
//
//
// Given an integer kill representing the ID of a process you want to kill, 
//return a list of the IDs of the processes that will be killed. You may return the 
//answer in any order. 
//
// 
// Example 1: 
// 
// 
//Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
//Output: [5,10]
//Explanation: The processes colored in red are the processes that should be 
//killed.
// 
//
// Example 2: 
//
// 
//Input: pid = [1], ppid = [0], kill = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// n == pid.length 
// n == ppid.length 
// 1 <= n <= 5 * 10⁴ 
// 1 <= pid[i] <= 5 * 10⁴ 
// 0 <= ppid[i] <= 5 * 10⁴ 
// Only one process has no parent. 
// All the values of pid are unique. 
// kill is guaranteed to be in pid. 
// 
//
// 👍 1019 👎 19


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, LinkedList<Integer>> processMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            LinkedList<Integer> children = processMap.getOrDefault(ppid.get(i), new LinkedList<>());
            children.add(pid.get(i));
            processMap.put(ppid.get(i), children);
        }
        killRecursive(kill, processMap, result);
        return result;

    }

    private void killRecursive(int pid, HashMap<Integer, LinkedList<Integer>> processMap, List<Integer> result) {
        result.add(pid); //Kill process
        //Kill child processes
        if (!processMap.containsKey(pid)) return;
        Deque<Integer> children = processMap.getOrDefault(pid, new LinkedList<>());
        while (children.size() > 0) {
            killRecursive(children.pollFirst(), processMap, result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KillProcess extends Solution {
}