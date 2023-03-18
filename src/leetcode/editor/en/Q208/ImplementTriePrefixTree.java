package leetcode.editor.en.Q208;

import java.util.*;

import javafx.util.Pair;

//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
//
// 👍 9418 👎 114

//{a:{
// a: b:}}
//leetcode submit region begin(Prohibit modification and deletion)

class TrieNode {

    char c;
    HashMap<Character, TrieNode> nodes = new HashMap<>();

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

class Trie {

    private static final char ENDING_SYMBOL = '*';
    HashMap<Character, TrieNode> trie = new HashMap<>();

    public Trie() {

    }

    public void insert(String word) {
        char firstChar = word.charAt(0);
        TrieNode head = this.trie.getOrDefault(firstChar, new TrieNode(firstChar));
        TrieNode triePointer = head;
        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            triePointer = triePointer.put(currentChar);
        }
        triePointer.put(ENDING_SYMBOL);
        this.trie.put(firstChar, head);
    }

    public boolean search(String word) {
        TrieNode triePointer = this.pointerThatStartsWith(word);
        if (triePointer == null) return false;
        return triePointer.contains(ENDING_SYMBOL);
    }


    public TrieNode pointerThatStartsWith(String word) {
        char currentChar = word.charAt(0);
        if (!this.trie.containsKey(currentChar)) return null;
        TrieNode triePointer = this.trie.get(currentChar);
        for (int i = 1; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (!triePointer.contains(currentChar)) return null;
            triePointer = triePointer.get(currentChar);
        }
        return triePointer;
    }

    public boolean startsWith(String prefix) {
        TrieNode triePointer = this.pointerThatStartsWith(prefix);
        return triePointer != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)


public class ImplementTriePrefixTree extends Trie {
}