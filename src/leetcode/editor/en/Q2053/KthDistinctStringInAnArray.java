package leetcode.editor.en.Q2053;

import java.util.*;

import javafx.util.Pair;

//A distinct string is a string that is present only once in an array. 
//
// Given an array of strings arr, and an integer k, return the kᵗʰ distinct 
//string present in arr. If there are fewer than k distinct strings, return an empty 
//string "". 
//
// Note that the strings are considered in the order in which they appear in 
//the array. 
//
// 
// Example 1: 
//
// 
//Input: arr = ["d","b","c","b","c","a"], k = 2
//Output: "a"
//Explanation:
//The only distinct strings in arr are "d" and "a".
//"d" appears 1ˢᵗ, so it is the 1ˢᵗ distinct string.
//"a" appears 2ⁿᵈ, so it is the 2ⁿᵈ distinct string.
//Since k == 2, "a" is returned. 
// 
//
// Example 2: 
//
// 
//Input: arr = ["aaa","aa","a"], k = 1
//Output: "aaa"
//Explanation:
//All strings in arr are distinct, so the 1ˢᵗ string "aaa" is returned.
// 
//
// Example 3: 
//
// 
//Input: arr = ["a","b","a"], k = 3
//Output: ""
//Explanation:
//The only distinct string is "b". Since there are fewer than 3 distinct 
//strings, we return an empty string "".
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= arr.length <= 1000 
// 1 <= arr[i].length <= 5 
// arr[i] consists of lowercase English letters. 
// 
//
// 👍 535 👎 17


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> counter = new LinkedHashMap<>();
        for (String s : arr) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> pair : counter.entrySet()) {
            if (pair.getValue() == 1) k--;
            if (k == 0) return pair.getKey();
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KthDistinctStringInAnArray extends Solution {
}