package leetcode.editor.en.Q2405;

import javafx.util.Pair;

import java.util.*;

//Given a string s, partition the string into one or more substrings such that 
//the characters in each substring are unique. That is, no letter appears in a 
//single substring more than once. 
//
// Return the minimum number of substrings in such a partition. 
//
// Note that each character should belong to exactly one substring in a 
//partition. 
//
// 
// Example 1: 
//
// 
//Input: s = "abacaba"
//Output: 4
//Explanation:
//Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
//It can be shown that 4 is the minimum number of substrings needed.
// 
//
// Example 2: 
//
// 
//Input: s = "ssssss"
//Output: 6
//Explanation:
//The only valid partition is ("s","s","s","s","s","s").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only English lowercase letters. 
// 
//
// 👍 1163 👎 55


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Pair<Integer, Boolean>, Integer> cache = new HashMap<>();

    public int partitionString(String s) {

        return partitionStringCutting(0, s, new LinkedHashSet<>());
    }


    public int partitionStringCutting(int i, String s, LinkedHashSet<Character> seen) {
        if (i == s.length()) {
            return 1;
        }
        char c = s.charAt(i);
        Pair<Integer, Boolean> cacheKey = new Pair<>(i, seen.contains(c));

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }


        if (seen.contains(c)) {
            //We have two options
            //Make the current window a substring or make the previous ocurrence a substring
            LinkedHashSet<Character> newWindow = new LinkedHashSet<>();
            newWindow.add(c);
            int cutHere = 1 + partitionStringCutting(i + 1, s, newWindow);

            LinkedList<Character> newStr = new LinkedList<>(seen);
            while (!newStr.isEmpty()) {
                char substringChar = newStr.pollFirst();
                seen.remove(substringChar);
                if (substringChar == c) break;
            }
            seen.add(c);
            int cutHead = 1 + partitionStringCutting(i + 1, s, seen);

            int res = Math.min(cutHere, cutHead);
            cache.put(cacheKey, res);
            return res;
        }
        seen.add(c);
        int res = partitionStringCutting(i + 1, s, seen);
        cache.put(cacheKey, res);
        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class OptimalPartitionOfString extends Solution {
}