package leetcode.editor.en.Q131;

import java.util.*;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// 👍 8880 👎 280


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Boolean[][] cache;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        cache = new Boolean[s.length()][s.length()];
        partitionHelper(0, s, new LinkedList<>());
        return result;
    }


    private void partitionHelper(int start, String s, LinkedList<String> row) {
        if (start >= s.length()) {
            ArrayList<String> resultingRow = new ArrayList<>(row);
            Collections.reverse(resultingRow);
            result.add(resultingRow);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                row.push(s.substring(start, i + 1));
                partitionHelper(i + 1, s, row);
                row.pop();
            }
        }
    }


    private boolean isPalindrome(String s, int start, int end) {
        //  System.out.println(s.substring(start, end + 1));
        if (cache[start][end] != null) return cache[start][end];
        int left = start;
        int right = end;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                cache[start][end] = false;
                return false;
            }
            left++;
            right--;
        }
        cache[start][end] = true;
        return cache[start][end];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PalindromePartitioning extends Solution {
}