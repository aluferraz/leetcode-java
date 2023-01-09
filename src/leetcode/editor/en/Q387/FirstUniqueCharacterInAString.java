package leetcode.editor.en.Q387;

import java.util.*;

//Given a string s, find the first non-repeating character in it and return its 
//index. If it does not exist, return -1. 
//
// 
// Example 1: 
// Input: s = "leetcode"
//Output: 0
// 
// Example 2: 
// Input: s = "loveleetcode"
//Output: 2
// 
// Example 3: 
// Input: s = "aabb"
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// 👍 7173 👎 243


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[][] counter = new int[26][2];
        char[] sArr = s.toCharArray();
        int N = sArr.length;

        for (int i = 0; i < N; i++) {
            int idx = sArr[i] - 'a';
            counter[idx][0]++;
            if (counter[idx][0] == 1) {
                counter[idx][1] = i;
            }
        }
        int res = N;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i][0] == 1) {
                res = Math.min(counter[i][1], res);
            }
        }
        return res == N ? -1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FirstUniqueCharacterInAString extends Solution {
}