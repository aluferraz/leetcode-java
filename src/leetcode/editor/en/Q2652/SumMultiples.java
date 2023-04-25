package leetcode.editor.en.Q2652;
import java.util.*;
import javafx.util.Pair;

//Given a positive integer n, find the sum of all integers in the range [1, n] 
//inclusive that are divisible by 3, 5, or 7. 
//
// Return an integer denoting the sum of all numbers in the given range 
//satisfying the constraint. 
//
// 
// Example 1: 
//
// 
//Input: n = 7
//Output: 21
//Explanation: Numbers in the range [1, 7] that are divisible by 3, 5, or 7 are 
//3, 5, 6, 7. The sum of these numbers is 21.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 40
//Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 
//are 3, 5, 6, 7, 9, 10. The sum of these numbers is 40.
// 
//
// Example 3: 
//
// 
//Input: n = 9
//Output: 30
//Explanation: Numbers in the range [1, 9] that are divisible by 3, 5, or 7 are 
//3, 5, 6, 7, 9. The sum of these numbers is 30.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10³ 
// 
//
// 👍 60 👎 5


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                //  System.out.println(i);
                ans += i;
            }

        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class SumMultiples extends Solution {}