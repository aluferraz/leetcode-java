package leetcode.editor.en.Q210;

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
// Return the ordering of courses you should take to finish all courses. If 
//there are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you 
//should have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you 
//should have finished both courses 1 and 2. Both courses 1 and 2 should be taken 
//after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
//
// 👍 8394 👎 276


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] courses;
    //    int[] order;
//    LinkedList<Integer> order = new LinkedList<>();

    private int[] result;
    private int pos;
    private static final int COMPLETED = 2;
    private static final int EVALUATING = 1;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courses = new int[numCourses];
        result = new int[numCourses];
        pos = 0;
        HashMap<Integer, LinkedList<Integer>> adjList = makeAdjList(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (!(courses[i] == COMPLETED) && !dfs(i, adjList)) {
                return new int[]{};
            }
        }
        return result;
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
        result[pos] = course;
        pos++;
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


public class CourseScheduleIi extends Solution {
}