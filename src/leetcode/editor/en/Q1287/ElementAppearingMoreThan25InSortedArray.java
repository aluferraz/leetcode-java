package leetcode.editor.en.Q1287;
import java.util.*;
import javafx.util.Pair;

//Given an integer array sorted in non-decreasing order, there is exactly one 
//integer in the array that occurs more than 25% of the time, return that integer. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,2,6,6,6,6,7,10]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁵ 
// 
//
// 👍 818 👎 42


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int num : arr) {
            int total = counter.getOrDefault(num, 0);
            total++;
            if(total > (0.25*arr.length)) return num;
            counter.put(num,total);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class ElementAppearingMoreThan25InSortedArray extends Solution {}