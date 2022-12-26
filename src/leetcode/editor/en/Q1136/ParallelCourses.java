package leetcode.editor.en.Q1136;

import java.util.*;

//You are given an integer n, which indicates that there are n courses labeled 
//from 1 to n. You are also given an array relations where relations[i] = [
//prevCoursei, nextCoursei], representing a prerequisite relationship between course 
//prevCoursei and course nextCoursei: course prevCoursei has to be taken before course 
//nextCoursei. 
//
// In one semester, you can take any number of courses as long as you have 
//taken all the prerequisites in the previous semester for the courses you are taking. 
//
//
// Return the minimum number of semesters needed to take all courses. If there 
//is no way to take all the courses, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3, relations = [[1,3],[2,3]]
//Output: 2
//Explanation: The figure above represents the given graph.
//In the first semester, you can take courses 1 and 2.
//In the second semester, you can take course 3.
// 
//
// Example 2: 
// 
// 
//Input: n = 3, relations = [[1,2],[2,3],[3,1]]
//Output: -1
//Explanation: No course can be studied because they are prerequisites of each 
//other.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 5000 
// 1 <= relations.length <= 5000 
// relations[i].length == 2 
// 1 <= prevCoursei, nextCoursei <= n 
// prevCoursei != nextCoursei 
// All the pairs [prevCoursei, nextCoursei] are unique. 
// 
//
// 👍 866 👎 22


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int COMPLETED = 1;
    private static final int IN_COURSE = -1;


    private HashMap<Integer, HashSet<Integer>> unlocks = new HashMap<>();
    private Queue<Integer> nextCourses;
    private int completed = 0;

    public int minimumSemesters(int n, int[][] relations) {
        if (n == 0) return 0;
        HashMap<Integer, HashSet<Integer>> adjList = makeAdjList(relations);
        int[] courseStatus = new int[n + 1];
        int semesters = 0;
        nextCourses = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!adjList.containsKey(i)) {
                nextCourses.add(i);
            }
        }
        while (!nextCourses.isEmpty()) {
            int size = nextCourses.size();
            for (int i = 0; i < size; i++) {
                if (dfs(nextCourses.poll(), adjList, courseStatus) < 0) {
                    return -1;
                }
            }
            semesters++;
        }
        return completed == n ? semesters : -1;

    }

    private void update(int prereq, HashMap<Integer, HashSet<Integer>> adjList, Queue<Integer> nextCourses) {
        completed++;
        if (!unlocks.containsKey(prereq)) return;
        HashSet<Integer> next = unlocks.get(prereq);

        for (int nextCourse : next) {
            HashSet<Integer> deps = adjList.get(nextCourse);
            deps.remove(prereq);
            if (deps.size() == 0) {
                adjList.remove(nextCourse);
                nextCourses.add(nextCourse);
            }
        }
    }

    private int dfs(int course, HashMap<Integer, HashSet<Integer>> adjList, int[] courseStatus) {

        if (courseStatus[course] == IN_COURSE) return -1;
        courseStatus[course] = IN_COURSE;
        int semester = 1;
        if (adjList.containsKey(course)) {
            HashSet<Integer> dependencies = adjList.get(course);
            for (int prereq : dependencies) {
                if (courseStatus[prereq] == COMPLETED) continue;
                int semesterPrereq = dfs(prereq, adjList, courseStatus);
                if (semesterPrereq < 0) return -1;
                semester += semesterPrereq;
            }
        }
        courseStatus[course] = COMPLETED;
        update(course, adjList, nextCourses);


        return semester;
    }


    private HashMap<Integer, HashSet<Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> result = new HashMap<>();
        for (int[] edge :
                edges) {
            int course = edge[1];
            int prereq = edge[0];

            HashSet<Integer> reqs = result.getOrDefault(course, new HashSet<>());
            reqs.add(prereq);
            result.put(course, reqs);

            HashSet<Integer> next = unlocks.getOrDefault(prereq, new HashSet<>());
            next.add(course);
            unlocks.put(prereq, next);

        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class ParallelCourses extends Solution {
}