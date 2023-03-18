package leetcode.editor.en.Q1858;

import java.util.*;

import javafx.util.Pair;

import javax.swing.tree.TreeNode;

//Given an array of strings words, find the longest string in words such that 
//every prefix of it is also in words. 
//
// 
// For example, let words = ["a", "app", "ap"]. The string "app" has prefixes 
//"ap" and "a", all of which are in words. 
// 
//
// Return the string described above. If there is more than one string with the 
//same length, return the lexicographically smallest one, and if no string exists,
// return "". 
//
// 
// Example 1: 
//
// 
//Input: words = ["k","ki","kir","kira", "kiran"]
//Output: "kiran"
//Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of 
//them appear in words.
// 
//
// Example 2: 
//
// 
//Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation: Both "apple" and "apply" have all their prefixes in words.
//However, "apple" is lexicographically smaller, so we return that.
// 
//
// Example 3: 
//
// 
//Input: words = ["abc", "bc", "ab", "qwe"]
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// 1 <= words[i].length <= 10⁵ 
// 1 <= sum(words[i].length) <= 10⁵ 
// 
//
// 👍 143 👎 5


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class WordComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(b.length(), a.length());
        }
    }
    class TrieNode {

        char c;
        public boolean ending;
        HashMap<Character, TrieNode> nodes = new HashMap<>();
        HashSet<String> words = new HashSet<>();

        TrieNode(char c) {
            this.c = c;
        }

        public TrieNode get(char c) {
            return this.nodes.getOrDefault(c, null);
        }

        public boolean contains(char c) {
            return this.nodes.containsKey(c);
        }

        public TrieNode put(char c) {
            if (!this.contains(c)) {
                this.nodes.put(c, new TrieNode(c));
            }
            return this.get(c);
        }
    }


    public String longestWord(String[] words) {
        PriorityQueue<String> res = new PriorityQueue<>(new WordComparator());
        res.add("");
        TrieNode head = new TrieNode('!');
        for (String word : words) {
            TrieNode current = head;
            for (int i = 0; i < word.length(); i++) {
                current = current.put(word.charAt(i));
            }
            current.ending = true;
            current.words.add(word);
        }
        Arrays.sort(words);



        for (String word : words) {
            TrieNode current = head;
            boolean everyPrefixExists = true;
            for (int i = 0; i < word.length(); i++) {
                current = current.get(word.charAt(i));
                if (!current.ending) {
                    everyPrefixExists = false;
                    break;
                }
            }
            if (everyPrefixExists) res.add(word);
        }
        return res.poll();
    }

}




//leetcode submit region end(Prohibit modification and deletion)


public class LongestWordWithAllPrefixes extends Solution {
}