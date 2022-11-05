package leetcode.editor.en.Q2158;

import java.util.*;

//There is a long and thin painting that can be represented by a number line. 
//You are given a 0-indexed 2D integer array paint of length n, where paint[i] = [
//starti, endi]. This means that on the iᵗʰ day you need to paint the area between 
//starti and endi. 
//
// Painting the same area multiple times will create an uneven painting so you 
//only want to paint each area of the painting at most once. 
//
// Return an integer array worklog of length n, where worklog[i] is the amount 
//of new area that you painted on the iᵗʰ day. 
//
// 
// Example 1: 
// 
// 
//Input: paint = [[1,4],[4,7],[5,8]]
//Output: [3,3,1]
//Explanation:
//On day 0, paint everything between 1 and 4.
//The amount of new area painted on day 0 is 4 - 1 = 3.
//On day 1, paint everything between 4 and 7.
//The amount of new area painted on day 1 is 7 - 4 = 3.
//On day 2, paint everything between 7 and 8.
//Everything between 5 and 7 was already painted on day 1.
//The amount of new area painted on day 2 is 8 - 7 = 1. 
// 
//
// Example 2: 
// 
// 
//Input: paint = [[1,4],[5,8],[4,7]]
//Output: [3,3,1]
//Explanation:
//On day 0, paint everything between 1 and 4.
//The amount of new area painted on day 0 is 4 - 1 = 3.
//On day 1, paint everything between 5 and 8.
//The amount of new area painted on day 1 is 8 - 5 = 3.
//On day 2, paint everything between 4 and 5.
//Everything between 5 and 7 was already painted on day 1.
//The amount of new area painted on day 2 is 5 - 4 = 1. 
// 
//
// Example 3: 
// 
// 
//Input: paint = [[1,5],[2,4]]
//Output: [4,0]
//Explanation:
//On day 0, paint everything between 1 and 5.
//The amount of new area painted on day 0 is 5 - 1 = 4.
//On day 1, paint nothing because everything between 2 and 4 was already 
//painted on day 0.
//The amount of new area painted on day 1 is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= paint.length <= 10⁵ 
// paint[i].length == 2 
// 0 <= starti < endi <= 5 * 10⁴ 
// 
//
// 👍 293 👎 30


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] amountPainted(int[][] paint) {
        int[] presum = new int[(int) ((5 * Math.pow(10, 4))) + 1];
        int[] result = new int[paint.length];
        for (int i = 0; i < paint.length; i++) {
            int[] pair = paint[i];
            int intraday = 0;
            for (int j = pair[0]; j < pair[1]; j++) {
                if (presum[j] != 0) {
                    j = presum[j] - 1;
                    continue;
                }
                presum[j] = pair[1];
                intraday++;
            }
            result[i] = intraday;
        }
        return result;
    }
}
//class Solution {
//    class TreeNode {
//        public int lo;
//        public int hi;
//        public int hiRooted;
//        public TreeNode left;
//        public TreeNode right;
//
//        public TreeNode(int lo, int hi) {
//            this.lo = lo;
//            this.hi = hi;
//            this.hiRooted = hi;
//        }
//    }
//
//    class BST {
//        TreeNode root;
//
//        public BST(TreeNode root) {
//            this.root = root;
//        }
//
//        public int insert(TreeNode node, TreeNode nodeToInsert) {
//            if (node.lo <= nodeToInsert.lo && node.hi >= nodeToInsert.hi) return 0; //Complete overlap
//            if (nodeToInsert.lo < node.lo) {
//                int rightComplement = 0;
//                if (nodeToInsert.hi >= node.lo) {
//                    nodeToInsert.hi = Math.min(nodeToInsert.hi, node.lo);
//                    TreeNode rightGap = new TreeNode(node.hi, nodeToInsert.hiRooted);
//                    rightComplement = this.insert(root, rightGap);
//                }
//                if (node.left == null) {
//                    node.left = nodeToInsert;
//                    node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hiRooted);
//                    return (nodeToInsert.hi - nodeToInsert.lo) + rightComplement;
//                } else {
//                    return rightComplement + insert(node.left, nodeToInsert);
//                }
//            } else {
//                nodeToInsert.lo = Math.max(nodeToInsert.lo, node.hi);
//                if (node.right == null) {
//                    node.right = nodeToInsert;
//                    node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hiRooted);
//                    return nodeToInsert.hi - nodeToInsert.lo;
//                } else {
//                    return insert(node.right, nodeToInsert);
//                }
//            }
//        }
//    }
//
//    public int[] amountPainted(int[][] paint) {
//        TreeNode root = new TreeNode(paint[0][0], paint[0][1]);
//        BST specialIntervalTree = new BST(root);
//
//        int[] result = new int[paint.length];
//        result[0] = root.hi - root.lo;
//        for (int i = 1; i < paint.length; i++) {
//            TreeNode newNode = new TreeNode(paint[i][0], paint[i][1]);
//            result[i] = specialIntervalTree.insert(root, newNode);
//        }
//
//
//        return result;
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


public class AmountOfNewAreaPaintedEachDay extends Solution {
}