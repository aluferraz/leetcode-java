package leetcode.editor.en.Q587;

import java.util.*;

//You are given an array trees where trees[i] = [xi, yi] represents the 
//location of a tree in the garden. 
//
// You are asked to fence the entire garden using the minimum length of rope as 
//it is expensive. The garden is well fenced only if all the trees are enclosed. 
//
// Return the coordinates of trees that are exactly located on the fence 
//perimeter. 
//
// 
// Example 1: 
// 
// 
//Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
// 
//
// Example 2: 
// 
// 
//Input: points = [[1,2],[2,2],[4,2]]
//Output: [[4,2],[2,2],[1,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 3000 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// All the given points are unique. 
// 
//
// 👍 991 👎 541


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://www.youtube.com/watch?v=uIxl6lrNBi8
    public int[][] outerTrees(int[][] trees) {


        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        HashSet<List<Integer>> resultSet = new HashSet<>();

        Stack<int[]> monochainStack = new Stack<>();

        for (int[] tree : trees) {
            while (monochainStack.size() >= 2
                    && areaOfTriangle(monochainStack.peek(), monochainStack.get(monochainStack.size() - 2), tree) > 0
            ) {
                monochainStack.pop();
            }
            monochainStack.push(tree);
        }
        while (monochainStack.size() > 0) {
            int[] fence = monochainStack.pop();
            resultSet.add(Arrays.asList(fence[0], fence[1]));
        }
        for (int[] tree : trees) {
            while (monochainStack.size() >= 2
                    && areaOfTriangle(monochainStack.peek(), monochainStack.get(monochainStack.size() - 2), tree) < 0
            ) {
                monochainStack.pop();
            }
            monochainStack.push(tree);
        }

        while (monochainStack.size() > 0) {
            int[] fence = monochainStack.pop();
            resultSet.add(Arrays.asList(fence[0], fence[1]));
        }
        int[][] result = new int[resultSet.size()][2];
        int i = 0;
        for (List<Integer> fenceList : resultSet) {
            result[i] = new int[]{fenceList.get(0), fenceList.get(1)};
            i++;
        }

        return result;
    }

    private int areaOfTriangle(int[] a, int[] b, int[] c) {
        //https://www.cuemath.com/geometry/area-of-triangle-in-coordinate-geometry/
        int x1 = a[0];
        int x2 = b[0];
        int x3 = c[0];
        int y1 = a[1];
        int y2 = b[1];
        int y3 = c[1];
        //x1 (y2 – y3 ) + x2 (y3 – y1 ) + x3(y1 – y2)

        return x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);

    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class ErectTheFence extends Solution {
}