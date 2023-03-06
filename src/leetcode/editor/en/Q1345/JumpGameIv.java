package leetcode.editor.en.Q1345;

import java.util.*;

//Given an array of integers arr, you are initially positioned at the first 
//index of the array. 
//
// In one step you can jump from index i to index: 
//
// 
// i + 1 where: i + 1 < arr.length. 
// i - 1 where: i - 1 >= 0. 
// j where: arr[i] == arr[j] and i != j. 
// 
//
// Return the minimum number of steps to reach the last index of the array. 
//
// Notice that you can not jump outside of the array at any time. 
//
// 
// Example 1: 
//
// 
//Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
//Output: 3
//Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that 
//index 9 is the last index of the array.
// 
//
// Example 2: 
//
// 
//Input: arr = [7]
//Output: 0
//Explanation: Start index is the last index. You do not need to jump.
// 
//
// Example 3: 
//
// 
//Input: arr = [7,6,9,6,9,6,9,7]
//Output: 1
//Explanation: You can jump directly from index 0 to index 7 which is last 
//index of the array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// -10⁸ <= arr[i] <= 10⁸ 
// 
//
// 👍 2745 👎 105


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJumps(int[] arr) {
        Queue<int[]> q = new LinkedList<>();
        int[] visited = new int[arr.length];
        int[] parents = new int[arr.length];
        Arrays.fill(visited, 1000000001);
        HashMap<Integer, HashSet<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexes.computeIfAbsent(arr[i], (v) -> new HashSet<>()).add(i);
            parents[i] = 1000000001;
        }
        parents[0] = 0;
        q.add(new int[]{0, 0});
        visited[0] = 0;
        int res = 1000000001;
        int target = arr.length - 1;
        while (!q.isEmpty()) {
            int size = q.size();
            HashMap<Integer, int[]> row = new HashMap<>();

            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int current = info[0];
                int jumps = info[1];
                if (current == arr.length - 1) {
                    //  return backtrack(current, parents);
                    return jumps;
                }
                if (current - 1 >= 0 && (jumps + 1 < visited[current - 1])) {
//                    q.add(new int[]{current - 1, jumps + 1});
                    visited[current - 1] = jumps + 1;
                    parents[current - 1] = current;
                    row.put(current - 1, new int[]{current - 1, jumps + 1});
                }
                if ((jumps + 1 < visited[current + 1])) {
//                    q.add(new int[]{current + 1, jumps + 1});
                    visited[current + 1] = jumps + 1;
                    parents[current + 1] = current;
                    row.put(current + 1, new int[]{current + 1, jumps + 1});
                }
                if (!indexes.containsKey(arr[current])) continue;
                HashSet<Integer> jumpIdxes = indexes.get(arr[current]);
                if (jumpIdxes.contains(target)) return jumps + 1;
                for (int idx : jumpIdxes) {
                    if (jumps + 1 < visited[idx]) {
                        parents[idx] = current;
                        visited[idx] = jumps + 1;
                        row.put(idx, new int[]{idx, jumps + 1});
//                        q.add(new int[]{idx, jumps + 1});
                    }
                }
                indexes.remove(arr[current]);
            }
            q.addAll(row.values());

        }
        return res;

    }

    private int backtrack(int i, int[] parents) {
        if (parents[i] == i) return 0;
        return 1 + backtrack(parents[i], parents);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class JumpGameIv extends Solution {
}