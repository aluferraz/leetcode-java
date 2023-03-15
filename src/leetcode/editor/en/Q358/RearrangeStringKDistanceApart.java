package leetcode.editor.en.Q358;

import java.util.*;

import javafx.util.Pair;
import leetcode.editor.en.Q343.IntegerBreak;

//Given a string s and an integer k, rearrange s such that the same characters 
//are at least distance k from each other. If it is not possible to rearrange the 
//string, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: s = "aabbcc", k = 3
//Output: "abcabc"
//Explanation: The same letters are at least a distance of 3 from each other.
// 
//
// Example 2: 
//
// 
//Input: s = "aaabc", k = 3
//Output: ""
//Explanation: It is not possible to rearrange the string.
// 
//
// Example 3: 
//
// 
//Input: s = "aaadbbcc", k = 2
//Output: "abacabcd"
//Explanation: The same letters are at least a distance of 2 from each other.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of only lowercase English letters. 
// 0 <= k <= s.length 
// 
//
// 👍 844 👎 37


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;


        StringBuilder res = new StringBuilder();
        HashSet<Character> cantBe = new HashSet<>();
        HashMap<Integer, HashSet<Character>> canBe = new HashMap<>();

//        Queue<Character> toBeArranged = new LinkedList<>();
        Queue<Pair<Character, Integer>> delayed = new LinkedList<>();
        PriorityQueue<Pair<Character, Integer>> toBeArranged = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                toBeArranged.add(new Pair<>(((char) (i + 'a')), counter[i]));
            }
        }

//        while (!sorted.isEmpty()) {
//            Pair<Character, Integer> pair = sorted.poll();
//            toBeArranged.add(pair.getKey());
//            if (pair.getValue() > 1) {
//                sorted.add(new Pair<>(pair.getKey(), (pair.getValue() - 1)));
//            }
//        }


        while (!toBeArranged.isEmpty()) {
            Pair<Character, Integer> pair = toBeArranged.poll();
            char c = pair.getKey();

            int idx = res.length();
            if (canBe.containsKey(idx)) {
                HashSet<Character> unblock = canBe.get(idx);
                for (Character free : unblock) {
                    cantBe.remove(free);
                }
            }
            if (cantBe.contains(c)) {
                delayed.add(pair);
            } else {
                int freeIdx = (idx + k) % s.length();
                if (pair.getValue() > 1) {
                    toBeArranged.add(new Pair<>(pair.getKey(), (pair.getValue() - 1)));
                }
                canBe.computeIfAbsent(freeIdx, (v) -> new HashSet<>()).add(c);
                cantBe.add(c);
                res.append(c);
                toBeArranged.addAll(delayed);
                delayed.clear();
            }
        }


        if (!delayed.isEmpty()) return "";
        return res.toString();


    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class RearrangeStringKDistanceApart extends Solution {
}