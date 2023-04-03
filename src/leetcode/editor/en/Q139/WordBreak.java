package leetcode.editor.en.Q139;

import java.util.*;

import javafx.util.Pair;

//Given a string s and a dictionary of strings wordDict, return true if s can 
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// 👍 13697 👎 579


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Trie {
        public HashMap<Character, Trie> next = new HashMap<>();
        private static final char ENDING_CHAR = '*';
        char c;

        Trie(Character c) {
            this.c = c;
        }

        public boolean endsWord() {
            return this.next.containsKey(ENDING_CHAR);
        }

        public boolean containsNext(char target) {
            return this.next.containsKey(target);
        }

        public Trie getNext(char target) {
            return this.next.get(target);
        }

        public Trie getNextOrCreate(char target) {
            if (this.containsNext(target)) return this.getNext(target);
            return addNext(target);
        }


        public Trie addNext(char newC) {
            Trie branch = this.next.getOrDefault(newC, new Trie(newC));
            this.next.put(newC, branch);
            return branch;
        }

        public Trie addEndingWord() {
            return this.addNext(ENDING_CHAR);
        }

    }

    HashMap<Pair<Integer, Trie>, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie('@');
        for (String word : wordDict) {
            addStringToTrie(root, word);
        }
        return wordBreakHelper(s, 0, root, root);

    }

    private boolean wordBreakHelper(String s, int i, Trie current, Trie root) {
        if (i == s.length()) {
            return current.endsWord();
        }
        Pair<Integer, Trie> cacheKey = new Pair<>(i + 1, current);
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
        char target = s.charAt(i);
        if (!current.containsNext(target)) return false;
        current = current.getNext(target);
        if (current.endsWord()) {
            if (wordBreakHelper(s, i + 1, root, root)) {
                return true;
            }
        }
        boolean res = wordBreakHelper(s, i + 1, current, root);
        cache.put(cacheKey, res);
        return res;
    }

    private void addStringToTrie(Trie root, String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getNextOrCreate(word.charAt(i));
        }
        current.addEndingWord();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class WordBreak extends Solution {
}