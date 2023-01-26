package leetcode.editor.en.Q187;

import java.util.*;

import javafx.util.Pair;

//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 
//'C', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the 
//DNA. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-
//long sequences (substrings) that occur more than once in a DNA molecule. You may 
//return the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// 
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
//
// 👍 2662 👎 464


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> counter = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < s.length()) {
            char c = s.charAt(right);
            sb.append(c);
            right++;
            if (sb.length() < 10) continue;
            if (sb.length() > 10) {
                sb.deleteCharAt(0);
            }
            String dna = sb.toString();
            int total = counter.getOrDefault(dna, 0) + 1;
            counter.put(dna, total);
            if (total == 2) {
                res.add(dna);
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RepeatedDnaSequences extends Solution {
}