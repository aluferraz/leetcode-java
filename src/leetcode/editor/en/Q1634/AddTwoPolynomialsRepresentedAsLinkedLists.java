package leetcode.editor.en.Q1634;

import java.util.*;

import javafx.util.Pair;

//A polynomial linked list is a special type of linked list where every node 
//represents a term in a polynomial expression. 
//
// Each node has three attributes: 
//
// 
// coefficient: an integer representing the number multiplier of the term. The 
//coefficient of the term 9x⁴ is 9. 
// power: an integer representing the exponent. The power of the term 9x⁴ is 4. 
//
// next: a pointer to the next node in the list, or null if it is the last node 
//of the list. 
// 
//
// For example, the polynomial 5x³ + 4x - 7 is represented by the polynomial 
//linked list illustrated below: 
//
// 
//
// The polynomial linked list must be in its standard form: the polynomial must 
//be in strictly descending order by its power value. Also, terms with a 
//coefficient of 0 are omitted. 
//
// Given two polynomial linked list heads, poly1 and poly2, add the polynomials 
//together and return the head of the sum of the polynomials. 
//
// PolyNode format: 
//
// The input/output format is as a list of n nodes, where each node is 
//represented as its [coefficient, power]. For example, the polynomial 5x³ + 4x - 7 would 
//be represented as: [[5,3],[4,1],[-7,0]]. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: poly1 = [[1,1]], poly2 = [[1,0]]
//Output: [[1,1],[1,0]]
//Explanation: poly1 = x. poly2 = 1. The sum is x + 1.
// 
//
// Example 2: 
//
// 
//Input: poly1 = [[2,2],[4,1],[3,0]], poly2 = [[3,2],[-4,1],[-1,0]]
//Output: [[5,2],[2,0]]
//Explanation: poly1 = 2x² + 4x + 3. poly2 = 3x² - 4x - 1. The sum is 5x² + 2. 
//Notice that we omit the "0x" term.
// 
//
// Example 3: 
//
// 
//Input: poly1 = [[1,2]], poly2 = [[-1,2]]
//Output: []
//Explanation: The sum is 0. We return an empty list.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁴ 
// -10⁹ <= PolyNode.coefficient <= 10⁹ 
// PolyNode.coefficient != 0 
// 0 <= PolyNode.power <= 10⁹ 
// PolyNode.power > PolyNode.next.power 
// 
//
// 👍 125 👎 10

class PolyNode {
    int coefficient, power;
    PolyNode next = null;

    PolyNode() {
    }

    PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 * int coefficient, power;
 * PolyNode next = null;
 * <p>
 * PolyNode() {}
 * PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 * PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        TreeMap<Integer, Integer> sum = new TreeMap<>(Comparator.reverseOrder());
        sumPolys(poly1, sum);
        sumPolys(poly2, sum);
        if (sum.isEmpty()) return null;
        PolyNode res = new PolyNode();
        PolyNode current = res;
        for (Map.Entry<Integer, Integer> kv : sum.entrySet()) {
            if (kv.getValue() == 0) continue;
            current.next = new PolyNode();
            current = current.next;
            current.power = kv.getKey();
            current.coefficient = kv.getValue();
        }
        return res.next;
    }

    private void sumPolys(PolyNode poly1, TreeMap<Integer, Integer> sum) {
        PolyNode current = poly1;
        while (current != null) {
            int power = current.power;
            int coefficient = current.coefficient;
            sum.put(power, sum.getOrDefault(power, 0) + coefficient);
            current = current.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class AddTwoPolynomialsRepresentedAsLinkedLists extends Solution {
}