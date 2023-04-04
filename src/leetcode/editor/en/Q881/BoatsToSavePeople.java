package leetcode.editor.en.Q881;

import java.util.*;

import javafx.util.Pair;

//You are given an array people where people[i] is the weight of the iᵗʰ person,
// and an infinite number of boats where each boat can carry a maximum weight of 
//limit. Each boat carries at most two people at the same time, provided the sum 
//of the weight of those people is at most limit. 
//
// Return the minimum number of boats to carry every given person. 
//
// 
// Example 1: 
//
// 
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
// 
//
// Example 2: 
//
// 
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
// 
//
// Example 3: 
//
// 
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
// 
//
// 
// Constraints: 
//
// 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= limit <= 3 * 10⁴ 
// 
//
// 👍 4309 👎 110


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRescueBoats(int[] people, int limit) {

        int res = 0;
        LinkedList<Integer> combinations = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i] >= limit) res++;
            else combinations.add(people[i]);
        }
        Collections.sort(combinations);

        int weightUsed = 0;
        int occupation = 0;

        int firstOrLast = 0;

        while (!combinations.isEmpty()) {
            int nextPerson = 0;
            if (occupation == 1 && weightUsed + combinations.peekFirst() <= limit) {
                nextPerson = combinations.pollFirst();
            } else {
                nextPerson = combinations.pollLast();
            }
            if (weightUsed + nextPerson <= limit && occupation == 1) {
                occupation++;
                weightUsed += nextPerson;
            } else {
                res++;
                occupation = 1;
                weightUsed = nextPerson;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BoatsToSavePeople extends Solution {
}