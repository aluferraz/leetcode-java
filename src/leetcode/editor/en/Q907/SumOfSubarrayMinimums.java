package leetcode.editor.en.Q907;

import java.util.*;

//Given an array of integers arr, find the sum of min(b), where b ranges over 
//every (contiguous) subarray of arr. Since the answer may be large, return the 
//answer modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,1,2,4]
//Output: 17
//Explanation: 
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,
//2,4]. 
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.
// 
//
// Example 2: 
//
// 
//Input: arr = [11,81,94,43,3]
//Output: 444
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 👍 4925 👎 341


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] PLE = PreviousLesserElement(arr);
        int[] NLE = NextLessesElement(arr);
        Long result = 0L;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < arr.length; i++) {
            int m = i - PLE[i];
            int n = NLE[i] - i;
            result += ((long) arr[i] * m * n) ;
        }
        result = result % mod;
        return result.intValue();

    }

    private int[] PreviousLesserElement(int[] arr) {
        int[] PLE = new int[arr.length];
        Arrays.fill(PLE, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                PLE[stack.pop()] = i;
            }
            stack.push(i);
        }
        return PLE;
    }

    private int[] NextLessesElement(int[] arr) {
        int[] NLE = new int[arr.length];
        Arrays.fill(NLE, arr.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                NLE[stack.pop()] = i;
            }
            stack.push(i);
        }
        return NLE;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SumOfSubarrayMinimums extends Solution {
}