package leetcode.editor.en.Q733;

//An image is represented by an m x n integer grid image where image[i][j] 
//represents the pixel value of the image. 
//
// You are also given three integers sr, sc, and color. You should perform a 
//flood fill on the image starting from the pixel image[sr][sc]. 
//
// To perform a flood fill, consider the starting pixel, plus any pixels 
//connected 4-directionally to the starting pixel of the same color as the starting 
//pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
//color), and so on. Replace the color of all of the aforementioned pixels with 
//color. 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
// 
// 
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
//e., the red pixel), all pixels connected by a path of the same color as the 
//starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally 
//connected to the starting pixel.
// 
//
// Example 2: 
//
// 
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made 
//to the image.
// 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// 👍 5825 👎 562


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int[] pos = {sr, sc};
        q.add(pos);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pos = q.remove();
                int row = pos[0];
                int col = pos[1];
                String visitedKey = Arrays.toString(pos);
                if (visited.contains(visitedKey)) continue;
                visited.add(visitedKey);
                if (this.isValidIdx(row - 1, col, image) && image[row - 1][col] == image[row][col]) {
                    q.add(new int[]{row - 1, col});
                }
                if (this.isValidIdx(row + 1, col, image) && image[row + 1][col] == image[row][col]) {
                    q.add(new int[]{row + 1, col});
                }
                if (this.isValidIdx(row, col - 1, image) && image[row][col - 1] == image[row][col]) {
                    q.add(new int[]{row, col - 1});
                }
                if (this.isValidIdx(row, col + 1, image) && image[row][col + 1] == image[row][col]) {
                    q.add(new int[]{row, col + 1});
                }
                image[row][col] = color;
            }
        }
        return image;
    }

    public boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
