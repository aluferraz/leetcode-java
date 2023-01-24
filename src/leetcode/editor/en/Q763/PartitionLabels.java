package leetcode.editor.en.Q763;

import java.util.*;

import javafx.util.Pair;

//You are given a string s. We want to partition the string into as many parts 
//as possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it 
//splits s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
//
// 👍 9059 👎 340


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        Integer[][] counter = new Integer[26][2];
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (counter[idx][0] == null) {
                counter[idx][0] = i;
            }
            counter[idx][1] = i;
        }
        int minLength = counter[s.charAt(0) - 'a'][1];
        int size = 1;
        int totalLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= minLength) {
                totalLength += size;
                res.add(size);
                size = 1;
                if (i < s.length() - 1) {
                    minLength = counter[s.charAt(i + 1) - 'a'][1];
                    continue;
                }
            }
            minLength = Math.max(counter[c - 'a'][1], minLength);
            size++;
        }
        if (totalLength != s.length()) {
            res.add(s.length() - totalLength);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PartitionLabels extends Solution {
}