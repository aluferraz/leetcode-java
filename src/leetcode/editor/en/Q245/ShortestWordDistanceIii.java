package leetcode.editor.en.Q245;

import java.util.*;

import javafx.util.Pair;

//Given an array of strings wordsDict and two strings that already exist in the 
//array word1 and word2, return the shortest distance between the occurrence of 
//these two words in the list. 
//
// Note that word1 and word2 may be the same. It is guaranteed that they 
//represent two individual words in the list. 
//
// 
// Example 1: 
// Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1
// = "makes", word2 = "coding"
//Output: 1
// 
// Example 2: 
// Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1
// = "makes", word2 = "makes"
//Output: 3
// 
// 
// Constraints: 
//
// 
// 1 <= wordsDict.length <= 10⁵ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] consists of lowercase English letters. 
// word1 and word2 are in wordsDict. 
// 
//
// 👍 456 👎 97


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int[] wordsHash = new int[wordsDict.length];

        for (int i = 0; i < wordsDict.length; i++) {
            wordsHash[i] = wordsDict[i].hashCode();
        }
        return shortestWordDistance(wordsHash, word1.hashCode(), word2.hashCode());
    }

    public int shortestWordDistance(int[] wordsDict, int word1, int word2) {
        LinkedList<Integer> findings = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i] == word1) {
                findings.add(i);
            } else if (wordsDict[i] == word2) {
                findings.add(i);
            }
            if (findings.size() == 2) {
                if (
                        wordsDict[findings.peekFirst()] == word1 && wordsDict[findings.peekLast()] == word2 ||
                                wordsDict[findings.peekFirst()] == word2 && wordsDict[findings.peekLast()] == word1
                ) {
                    res = Math.min(res, (findings.peekLast() - findings.peekFirst()));
                    if(res == 1) return res;
                }
                findings.pollFirst();
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestWordDistanceIii extends Solution {
}