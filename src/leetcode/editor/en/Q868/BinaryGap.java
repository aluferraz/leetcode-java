package leetcode.editor.en.Q868;

import java.util.*;

import javafx.util.Pair;

//Given a positive integer n, find and return the longest distance between any 
//two adjacent 1's in the binary representation of n. If there are no two adjacent 
//1's, return 0. 
//
// Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
// The distance between two 1's is the absolute difference between their bit 
//positions. For example, the two 1's in "1001" have a distance of 3. 
//
// 
// Example 1: 
//
// 
//Input: n = 22
//Output: 2
//Explanation: 22 in binary is "10110".
//The first adjacent pair of 1's is "10110" with a distance of 2.
//The second adjacent pair of 1's is "10110" with a distance of 1.
//The answer is the largest of these two distances, which is 2.
//Note that "10110" is not a valid pair since there is a 1 separating the two 1
//'s underlined.
// 
//
// Example 2: 
//
// 
//Input: n = 8
//Output: 0
//Explanation: 8 in binary is "1000".
//There are not any adjacent pairs of 1's in the binary representation of 8, so 
//we return 0.
// 
//
// Example 3: 
//
// 
//Input: n = 5
//Output: 2
//Explanation: 5 in binary is "101".
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 526 👎 629


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int binaryGap(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int dist = 0;
        for (int i = 0; i < binaryStr.length() - 1; i++) {
            if (binaryStr.charAt(i) == '1') {
                int next = binaryStr.indexOf('1', i + 1);
                if (next > 0) {
                    dist = Math.max(dist, next - i);
                }
            }
        }
        return dist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BinaryGap extends Solution {
}