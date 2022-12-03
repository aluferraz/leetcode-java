package leetcode.editor.en.Q1657;
import java.util.*;

//Two strings are considered close if you can attain one from the other using 
//the following operations: 
//
// 
// Operation 1: Swap any two existing characters. 
// 
//
// 
// For example, abcde -> aecdb 
// 
// 
// Operation 2: Transform every occurrence of one existing character into 
//another existing character, and do the same with the other character.
// 
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into 
//a's) 
// 
// 
//
//
// You can use the operations on either string as many times as necessary. 
//
// Given two strings, word1 and word2, return true if word1 and word2 are close,
// and false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "abc", word2 = "bca"
//Output: true
//Explanation: You can attain word2 from word1 in 2 operations.
//Apply Operation 1: "abc" -> "acb"
//Apply Operation 1: "acb" -> "bca"
// 
//
// Example 2: 
//
// 
//Input: word1 = "a", word2 = "aa"
//Output: false
//Explanation: It is impossible to attain word2 from word1, or vice versa, in 
//any number of operations.
// 
//
// Example 3: 
//
// 
//Input: word1 = "cabbba", word2 = "abbccc"
//Output: true
//Explanation: You can attain word2 from word1 in 3 operations.
//Apply Operation 1: "cabbba" -> "caabbb"
//Apply Operation 2: "caabbb" -> "baaccc"
//Apply Operation 2: "baaccc" -> "abbccc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 and word2 contain only lowercase English letters. 
// 
//
// 👍 1288 👎 63


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        char[] word1C = word1.toCharArray();
        char[] word2C = word2.toCharArray();
        for (int i = 0; i < word1C.length; i++) {
            word1Count[word1C[i] - 'a']++;
            word2Count[word2C[i] - 'a']++;
        }
        return swapAndCheck(0,word1Count, word2Count);
    }

    private boolean swapAndCheck(int i,  int[] word1Count, int[] word2Count){
        if(i == word1Count.length) return true;
        if( word1Count[i] == 0 && word2Count[i] > 0 || word1Count[i] > 0 && word2Count[i] == 0 ) return false;
        if(word1Count[i] == word2Count[i]) return swapAndCheck(i+1, word1Count, word2Count) ;
        for (int j = i+1; j < word1Count.length; j++){
            if(word1Count[j] == word2Count[i]){
                swap(i, j, word1Count); //Swap and try
                if(swapAndCheck(i+1, word1Count, word2Count)) return  true;
                swap(i, j, word1Count); //Un-swap and try with others
            }
        }
        return false;
    }
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}




//leetcode submit region end(Prohibit modification and deletion)



public class DetermineIfTwoStringsAreClose extends Solution {}