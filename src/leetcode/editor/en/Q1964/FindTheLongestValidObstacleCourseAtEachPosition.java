package leetcode.editor.en.Q1964;

import java.util.*;

import javafx.util.Pair;

//You want to build some obstacle courses. You are given a 0-indexed integer 
//array obstacles of length n, where obstacles[i] describes the height of the iᵗʰ 
//obstacle. 
//
// For every index i between 0 and n - 1 (inclusive), find the length of the 
//longest obstacle course in obstacles such that: 
//
// 
// You choose any number of obstacles between 0 and i inclusive. 
// You must include the iᵗʰ obstacle in the course. 
// You must put the chosen obstacles in the same order as they appear in 
//obstacles. 
// Every obstacle (except the first) is taller than or the same height as the 
//obstacle immediately before it. 
// 
//
// Return an array ans of length n, where ans[i] is the length of the longest 
//obstacle course for index i as described above. 
//
// 
// Example 1: 
//
// 
//Input: obstacles = [1,2,3,2]
//Output: [1,2,3,3]
//Explanation: The longest valid obstacle course at each position is:
//- i = 0: [1], [1] has length 1.
//- i = 1: [1,2], [1,2] has length 2.
//- i = 2: [1,2,3], [1,2,3] has length 3.
//- i = 3: [1,2,3,2], [1,2,2] has length 3.
// 
//
// Example 2: 
//
// 
//Input: obstacles = [2,2,1]
//Output: [1,2,1]
//Explanation: The longest valid obstacle course at each position is:
//- i = 0: [2], [2] has length 1.
//- i = 1: [2,2], [2,2] has length 2.
//- i = 2: [2,2,1], [1] has length 1.
// 
//
// Example 3: 
//
// 
//Input: obstacles = [3,1,5,6,4,2]
//Output: [1,1,2,3,2,2]
//Explanation: The longest valid obstacle course at each position is:
//- i = 0: [3], [3] has length 1.
//- i = 1: [3,1], [1] has length 1.
//- i = 2: [3,1,5], [3,5] has length 2. [1,5] is also valid.
//- i = 3: [3,1,5,6], [3,5,6] has length 3. [1,5,6] is also valid.
//- i = 4: [3,1,5,6,4], [3,4] has length 2. [1,4] is also valid.
//- i = 5: [3,1,5,6,4,2], [1,2] has length 2.
// 
//
// 
// Constraints: 
//
// 
// n == obstacles.length 
// 1 <= n <= 10⁵ 
// 1 <= obstacles[i] <= 10⁷ 
// 
//
// 👍 464 👎 9


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] longest = new int[obstacles.length + 1];
        int[] counter = new int[obstacles.length + 1];
        Arrays.fill(longest, -1);

        int[] res = new int[obstacles.length];

        for (int i = 0; i < obstacles.length; i++) {
            int maxPossibleLength = i + 1;
            int pos = binarySearch(1, maxPossibleLength, obstacles[i], longest, obstacles);
            if (longest[pos] == -1 || obstacles[i] < obstacles[longest[pos]]) {
                if (longest[pos] != -1 && obstacles[i] < obstacles[longest[pos]]) {
                    counter[pos] = 0;
                }
                longest[pos] = i;
            }
            res[i] = pos + counter[pos];
            counter[pos]++;
        }

        return res;
    }

    private int binarySearch(int left, int right, int target, int[] longest, int[] obstacles) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (longest[mid] == -1 || obstacles[longest[mid]] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindTheLongestValidObstacleCourseAtEachPosition extends Solution {
}