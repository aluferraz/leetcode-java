package leetcode.editor.en.Q472;

import java.util.*;

import javafx.util.Pair;

//Given an array of strings words (without duplicates), return all the 
//concatenated words in the given list of words. 
//
// A concatenated word is defined as a string that is comprised entirely of at 
//least two shorter words in the given array. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog",
//"hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
//
// Example 2: 
//
// 
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 30 
// words[i] consists of only lowercase English letters. 
// All the strings of words are unique. 
// 1 <= sum(words[i].length) <= 10⁵ 
// 
//
// 👍 2769 👎 246


//leetcode submit region begin(Prohibit modification and deletion)

//{}
//{a : {b
// }}

class Solution {
    class Trie {
        private final char ENDING_SYMBOL = '*';
        public HashMap<Character, Trie> edges = new HashMap<>();
        HashSet<String> endingWords = new HashSet<>();

        public Trie(String s) {
            this.fromString(s);
        }

        public Trie() {

        }


        public Trie add(Character c) {
            Trie res;
            if (!this.edges.containsKey(c)) {
                res = new Trie();
                this.edges.put(c, res);
                return res;
            }
            return this.edges.get(c);
        }

        public void addEndingWord(String s) {
            this.endingWords.add(s);
        }

        private void fromString(String s) {
            Trie current = this;
            for (int i = 0; i < s.length(); i++) {
                current = current.add(s.charAt(i));
            }
            current.add(ENDING_SYMBOL);
            current.addEndingWord(s);
//            return ;
        }

        private HashSet<String> getEndingWords() {
            return this.endingWords;
        }

        private boolean isEnding() {
            return this.edges.containsKey(ENDING_SYMBOL);
        }

    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        Arrays.sort(words);
        Trie wordsTrie = new Trie(words[0]);

        for (int i = 1; i < words.length; i++) {
            wordsTrie.fromString(words[i]);
        }
        for (String word : words) {
            ArrayList<String> row = new ArrayList<>();
            if (backtrack(word, 0, wordsTrie, wordsTrie, row)) {
                if (row.size() > 1) res.add(word);
            }
        }
        return res;
    }

    private boolean backtrack(String word, int i, Trie wordsTrie, Trie current, ArrayList<String> res) {
        if (i == word.length()) {
            if (current.isEnding()) {
                res.addAll(current.getEndingWords());
                return true;
            }
            return false;
        }
        char c = word.charAt(i);

        if (current.isEnding()) {
            if (backtrack(word, i, wordsTrie, wordsTrie, res)) {
                res.addAll(current.getEndingWords());
                return true;
            }
        }
        if (!current.edges.containsKey(c)) {
            return false;
        }
        return backtrack(word, i + 1, wordsTrie, current.edges.get(c), res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ConcatenatedWords extends Solution {
}