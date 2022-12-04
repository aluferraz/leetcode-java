package leetcode.editor.en.Q1231;

import java.util.*;

//You have one chocolate bar that consists of some chunks. Each chunk has its 
//own sweetness given by the array sweetness. 
//
// You want to share the chocolate with your k friends so you start cutting the 
//chocolate bar into k + 1 pieces using k cuts, each piece consists of some 
//consecutive chunks. 
//
// Being generous, you will eat the piece with the minimum total sweetness and 
//give the other pieces to your friends. 
//
// Find the maximum total sweetness of the piece you can get by cutting the 
//chocolate bar optimally. 
//
// 
// Example 1: 
//
// 
//Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
//Output: 6
//Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9
//]
// 
//
// Example 2: 
//
// 
//Input: sweetness = [5,6,7,8,9,1,2,3,4], k = 8
//Output: 1
//Explanation: There is only one way to cut the bar into 9 pieces.
// 
//
// Example 3: 
//
// 
//Input: sweetness = [1,2,2,1,2,2,1,2,2], k = 2
//Output: 5
//Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
// 
//
// 
// Constraints: 
//
// 
// 0 <= k < sweetness.length <= 10⁴ 
// 1 <= sweetness[i] <= 10⁵ 
// 
//
// 👍 826 👎 49


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maximizeSweetness(int[] sweetness, int k) {
        Long left = 1L;
        long sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
        }
        long right = sum / (k + 1); // Maximum sweetness


        while (left < right) {
            long mid = (left + right + 1L) / 2L;
            int chunks = getChunks(sweetness, mid);
            if (chunks >= k + 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left.intValue();
    }

    private int getChunks(int[] sweetness, long slice) {
        int sum = 0;
        int chunks = 0;
        for (int sweet : sweetness) {
            sum += sweet;
            if (sum >= slice) {
                chunks++;
                sum = 0;
            }
        }
        return chunks;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class DivideChocolate extends Solution {
}