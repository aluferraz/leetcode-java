package leetcode.editor.en.Q832;

import java.util.*;

import javafx.util.Pair;

//Given an n x n binary matrix image, flip the image horizontally, then invert 
//it, and return the resulting image. 
//
// To flip an image horizontally means that each row of the image is reversed. 
//
// 
// For example, flipping [1,1,0] horizontally results in [0,1,1]. 
// 
//
// To invert an image means that each 0 is replaced by 1, and each 1 is 
//replaced by 0. 
//
// 
// For example, inverting [0,1,1] results in [1,0,0]. 
// 
//
// 
// Example 1: 
//
// 
//Input: image = [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// Example 2: 
//
// 
//Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]
//.
//Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
// Constraints: 
//
// 
// n == image.length 
// n == image[i].length 
// 1 <= n <= 20 
// images[i][j] is either 0 or 1. 
// 
//
// 👍 2789 👎 216


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int left = 0;
            int right = row.length - 1;
            while (left <= right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                row[left] = (row[left] + 1) % 2;
                if (left != right) {
                    row[right] = (row[right] + 1) % 2;
                }
                left++;
                right--;
            }
        }
        return image;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FlippingAnImage extends Solution {
}