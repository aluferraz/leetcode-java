package leetcode.editor.en.Q427;

import java.util.*;

import javafx.util.Pair;

//Given a n * n matrix grid of 0's and 1's only. We want to represent the grid 
//with a Quad-Tree. 
//
// Return the root of the Quad-Tree representing the grid. 
//
// Notice that you can assign the value of a node to True or False when isLeaf 
//is False, and both are accepted in the answer. 
//
// A Quad-Tree is a tree data structure in which each internal node has exactly 
//four children. Besides, each node has two attributes: 
//
// 
// val: True if the node represents a grid of 1's or False if the node 
//represents a grid of 0's. 
// isLeaf: True if the node is leaf node on the tree or False if the node has 
//the four children. 
// 
//
// 
//class Node {
//    public boolean val;
//    public boolean isLeaf;
//    public Node topLeft;
//    public Node topRight;
//    public Node bottomLeft;
//    public Node bottomRight;
//} 
//
// We can construct a Quad-Tree from a two-dimensional area using the following 
//steps: 
//
// 
// If the current grid has the same value (i.e all 1's or all 0's) set isLeaf 
//True and set val to the value of the grid and set the four children to Null and 
//stop. 
// If the current grid has different values, set isLeaf to False and set val to 
//any value and divide the current grid into four sub-grids as shown in the photo.
// 
// Recurse for each of the children with the proper sub-grid. 
// 
// 
// If you want to know more about the Quad-Tree, you can refer to the wiki. 
//
// Quad-Tree format: 
//
// The output represents the serialized format of a Quad-Tree using level order 
//traversal, where null signifies a path terminator where no node exists below. 
//
// It is very similar to the serialization of the binary tree. The only 
//difference is that the node is represented as a list [isLeaf, val]. 
//
// If the value of isLeaf or val is True we represent it as 1 in the list [
//isLeaf, val] and if the value of isLeaf or val is False we represent it as 0. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1],[1,0]]
//Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
//Explanation: The explanation of this example is shown below:
//Notice that 0 represnts False and 1 represents True in the photo representing 
//the Quad-Tree.
//
// 
//
// Example 2: 
//
// 
//
// 
//Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,
//1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]
//]
//Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[
//1,1]]
//Explanation: All values in the grid are not the same. We divide the grid into 
//four sub-grids.
//The topLeft, bottomLeft and bottomRight each has the same value.
//The topRight have different values so we divide it into 4 sub-grids where 
//each has the same value.
//Explanation is shown in the photo below:
//
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// n == 2ˣ where 0 <= x <= 6 
// 
//
// 👍 812 👎 1140
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        if (grid.length == 0) return null;
        int[][] presumMatrix = getPresumMatrix(grid);
        Node root = constructHelper(presumMatrix, 0, 0, presumMatrix.length, presumMatrix[presumMatrix.length - 1].length);
        return root;
    }

    private Node constructHelper(int[][] presumMatrix, int y, int x, int m, int n) {
        int matrixValue = getMatrixSum(presumMatrix, y, x, y + m, x + n);

        int matrixSize = m * n;

        if (matrixValue == 0 || matrixValue == matrixSize) {
            return new Node(matrixValue != 0, true);
        } else {
//            int left = n / 2;
//            int bottom = m / 2;
            return new Node(
                    true,
                    false,
                    constructHelper(presumMatrix,
                            y,
                            x,
                            (m / 2),
                            (n / 2)),
                    constructHelper(presumMatrix,
                            y,
                            x + (n / 2),
                            (m / 2),
                            (n / 2)
                    ),
                    constructHelper(presumMatrix,
                            y + (m / 2),
                            x,
                            (m / 2),
                            (n / 2)),
                    constructHelper(presumMatrix,
                            y + (m / 2),
                            x + (n / 2),
                            m / 2,
                            n / 2
                    )
            );
        }
    }

    private int getMatrixSum(int[][] presumMatrix, int startY, int startX, int endY, int endX) {

        int leftSide = startX > 0 ? presumMatrix[endY - 1][startX - 1] : 0;
        int upSide = startY > 0 ? presumMatrix[startY - 1][endX - 1] : 0;
        int topLeftCorner = (startX > 0 && startY > 0) ? presumMatrix[startY - 1][startX - 1] : 0;
        int bottomRight = presumMatrix[endY - 1][endX - 1];
        return bottomRight - leftSide - upSide + topLeftCorner;
    }

    private int[][] getPresumMatrix(int[][] grid) {
        int[][] presumMatrix = new int[grid.length][grid[0].length];
        presumMatrix[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            presumMatrix[i][0] = presumMatrix[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            presumMatrix[0][i] = presumMatrix[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                presumMatrix[i][j] = presumMatrix[i - 1][j] +
                        presumMatrix[i][j - 1] - presumMatrix[i - 1][j - 1] +
                        grid[i][j];
            }
        }
        return presumMatrix;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class ConstructQuadTree extends Solution {
}