package leetcode.editor.en.Q231;
import java.util.*;

//Given an integer n, return true if it is a power of two. Otherwise, return 
//false. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2⁰ = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2⁴ = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion?
//
// 👍 4368 👎 329


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return  false;
        if( n == 1 ) return true;
        if(n % 2 != 0) return  false;
        return isPowerOfTwo( n / 2 );
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class PowerOfTwo extends Solution {}