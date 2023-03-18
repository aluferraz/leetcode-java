package leetcode.editor.en.Q211;

import java.util.*;

import javafx.util.Pair;

//Design a data structure that supports adding new words and finding if a 
//string matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure 
//that matches word or false otherwise. word may contain dots '.' where dots can 
//be matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 25 
// word in addWord consists of lowercase English letters. 
// word in search consist of '.' or lowercase English letters. 
// There will be at most 3 dots in word for search queries. 
// At most 10⁴ calls will be made to addWord and search. 
// 
//
// 👍 5880 👎 339


//leetcode submit region begin(Prohibit modification and deletion)


class TrieNode {

    char c;
    public HashMap<Character, TrieNode> nodes = new HashMap<>();


    TrieNode(char c) {
        this.c = c;
    }

    public TrieNode get(char c) {
        return this.nodes.get(c);
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

class WordDictionary {
    private static final char ENDING_SYMBOL = '*';

    TrieNode trieHead;

    public WordDictionary() {
        trieHead = new TrieNode('!');
    }

    public void addWord(String word) {
        this.insert(word, 0, trieHead);
    }

    private void insert(String word, int i, TrieNode triePointer) {
        if (i == word.length()) {
            triePointer.put(ENDING_SYMBOL);
            return;
        }
        char currentChar = word.charAt(i);
//        insert(word, i + 1, triePointer.put('.'));
        insert(word, i + 1, triePointer.put(currentChar));
    }


    public boolean search(String word) {
        return this.search(0, word, this.trieHead);

    }

    public boolean search(int i, String word, TrieNode pointer) {
        if (i == word.length()) {
            return pointer.contains(ENDING_SYMBOL);
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode paths : pointer.nodes.values()) {
                if (search(i + 1, word, paths)) {
                    return true;
                }
            }
            return false;
        }
        if (!pointer.contains(c)) return false;
        return search(i + 1, word, pointer.get(c));

    }

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)


public class DesignAddAndSearchWordsDataStructure extends WordDictionary {
}