package leetcode.editor.en.Q207;

import java.util.*;

//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
//
// 👍 12187 👎 478


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] courses;
    private static final int COMPLETED = 2;
    private static final int EVALUATING = 1;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> adjList = makeAdjList(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (!(courses[i] == COMPLETED) && !dfs(i, adjList)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, HashMap<Integer, LinkedList<Integer>> prerequisites) {
        if (courses[course] == EVALUATING) return false;
        if (courses[course] == COMPLETED) return true;
        courses[course] = EVALUATING;
        LinkedList<Integer> reqs = prerequisites.getOrDefault(course, new LinkedList<>());
        for (int req :
                reqs) {
            if (!(courses[req] == COMPLETED) && !dfs(req, prerequisites)) return false;
        }
        courses[course] = COMPLETED;
        return true;
    }

    private HashMap<Integer, LinkedList<Integer>> makeAdjList(int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> result = new HashMap<>();
        for (int[] prereq :
                prerequisites) {
            int from = prereq[0];
            int to = prereq[1];
            LinkedList<Integer> reqs = result.getOrDefault(from, new LinkedList<>());
            reqs.add(to);
            result.put(from, reqs);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class CourseSchedule extends Solution {
}