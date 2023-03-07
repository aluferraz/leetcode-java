package leetcode.editor.en.Q1065;

import java.util.*;

import javafx.util.Pair;

//Given a string text and an array of strings words, return an array of all 
//index pairs [i, j] so that the substring text[i...j] is in words. 
//
// Return the pairs [i, j] in sorted order (i.e., sort them by their first 
//coordinate, and in case of ties sort them by their second coordinate). 
//
// 
// Example 1: 
//
// 
//Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
//Output: [[3,7],[9,13],[10,17]]
// 
//
// Example 2: 
//
// 
//Input: text = "ababa", words = ["aba","ab"]
//Output: [[0,1],[0,2],[2,3],[2,4]]
//Explanation: Notice that matches can overlap, see "aba" is found in [0,2] and 
//[2,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= text.length <= 100 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 50 
// text and words[i] consist of lowercase English letters. 
// All the strings of words are unique. 
// 
//
// 👍 268 👎 87


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        PriorityQueue<int[]> indexes = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        HashSet<Pair<Integer, Integer>> duplicates = new HashSet<>();

        for (String word : words) {
            int start = 0;
            while (start >= 0 && start <= (text.length() - word.length())) {
                int foundAt = text.indexOf(word, start);
                if (foundAt == -1) break;
                int end = foundAt + word.length();
                Pair<Integer, Integer> dupKey = new Pair<>(foundAt, end);
                if (!duplicates.contains(dupKey)) indexes.add(new int[]{foundAt, end - 1});
                duplicates.add(dupKey);
                start++;
            }
        }


        int size = indexes.size();
        int[][] res = new int[size][2];
        for (
                int i = 0;
                i < size; i++) {
            res[i] = indexes.poll();
        }
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)


public class IndexPairsOfAString extends Solution {
}