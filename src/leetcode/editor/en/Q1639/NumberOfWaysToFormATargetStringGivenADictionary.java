package leetcode.editor.en.Q1639;

import java.util.*;

import javafx.util.Pair;

//You are given a list of strings of the same length words and a string target. 
//
//
// Your task is to form target using the given words under the following rules: 
//
//
// 
// target should be formed from left to right. 
// To form the iᵗʰ character (0-indexed) of target, you can choose the kᵗʰ 
//character of the jᵗʰ string in words if target[i] = words[j][k]. 
// Once you use the kᵗʰ character of the jᵗʰ string of words, you can no longer 
//use the xᵗʰ character of any string in words where x <= k. In other words, all 
//characters to the left of or at index k become unusuable for every string. 
// Repeat the process until you form the string target. 
// 
//
// Notice that you can use multiple characters from the same string in words 
//provided the conditions above are met. 
//
// Return the number of ways to form target from words. Since the answer may be 
//too large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: words = ["acca","bbbb","caca"], target = "aba"
//Output: 6
//Explanation: There are 6 ways to form target.
//"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
//"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
//"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
//"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
//"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
//"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
// 
//
// Example 2: 
//
// 
//Input: words = ["abba","baab"], target = "bab"
//Output: 4
//Explanation: There are 4 ways to form target.
//"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
//"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
//"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
//"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// All strings in words have the same length. 
// 1 <= target.length <= 1000 
// words[i] and target contain only lowercase English letters. 
// 
//
// 👍 903 👎 47


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final long MOD = 1000000007L;
    private Long[][] cache;

    public int numWays(String[] words, String target) {
        cache = new Long[words[0].length()][target.length()];
        HashMap<Integer, HashMap<Character, Integer>> charMap = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                charMap.computeIfAbsent(i, (v) -> new HashMap<>()).compute(c, (key, val) -> (val == null) ? 1 : val + 1);
            }
        }
        long res = numWays(0, 0, charMap, target);
        return (int) (res % MOD);

    }

    public long numWays(int i,
                        int j,
                        HashMap<Integer, HashMap<Character, Integer>> charMap,
                        String target
    ) {
        if (j == target.length()) {
            return 1L;
        }
        if (!charMap.containsKey(i)) {
            return 0L;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        long res = 0;
        char cTarget = target.charAt(j);

        HashMap<Character, Integer> options = charMap.get(i);

        if (options.containsKey(cTarget)) {
            int wordsIdxes = options.get(cTarget);
            res += ((wordsIdxes) * numWays(i + 1, j + 1, charMap, target));
            res %= MOD;
        }
        res += numWays(i + 1, j, charMap, target);
        cache[i][j] = res;
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfWaysToFormATargetStringGivenADictionary extends Solution {
}