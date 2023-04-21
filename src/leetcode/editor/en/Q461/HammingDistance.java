package leetcode.editor.en.Q461;

import java.util.*;

import javafx.util.Pair;

//The Hamming distance between two integers is the number of positions at which 
//the corresponding bits are different. 
//
// Given two integers x and y, return the Hamming distance between them. 
//
// 
// Example 1: 
//
// 
//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are 
//different.
// 
//
// Example 2: 
//
// 
//Input: x = 3, y = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// 👍 3547 👎 211


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);
        LinkedList<Character> xChar = new LinkedList<>();
        LinkedList<Character> yChar = new LinkedList<>();
        for (int i = 0; i < xBin.length(); i++) {
            xChar.add(xBin.charAt(i));
        }
        for (int i = 0; i < yBin.length(); i++) {
            yChar.add(yBin.charAt(i));
        }

        while (yChar.size() < 32) {
            yChar.addFirst('0');
        }
        while (xChar.size() < 32) {
            xChar.addFirst('0');
        }
        int diffCount = 0;
        while (!yChar.isEmpty()) {
            if (yChar.pollFirst() != xChar.pollFirst()) {
                diffCount++;
            }
        }
        return diffCount;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class HammingDistance extends Solution {
}