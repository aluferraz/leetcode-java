package leetcode.editor.en.Q443;

import java.util.*;

import javafx.util.Pair;

//Given an array of characters chars, compress it using the following algorithm:
// 
//
// Begin with an empty string s. For each group of consecutive repeating 
//characters in chars: 
//
// 
// If the group's length is 1, append the character to s. 
// Otherwise, append the character followed by the group's length. 
// 
//
// The compressed string s should not be returned separately, but instead, be 
//stored in the input character array chars. Note that group lengths that are 10 or 
//longer will be split into multiple characters in chars. 
//
// After you are done modifying the input array, return the new length of the 
//array. 
//
// You must write an algorithm that uses only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: [
//"a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3
//".
// 
//
// Example 2: 
//
// 
//Input: chars = ["a"]
//Output: Return 1, and the first character of the input array should be: ["a"]
//Explanation: The only group is "a", which remains uncompressed since it's a 
//single character.
// 
//
// Example 3: 
//
// 
//Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//Output: Return 4, and the first 4 characters of the input array should be: [
//"a","b","1","2"].
//Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
// 
//
// 
// Constraints: 
//
// 
// 1 <= chars.length <= 2000 
// chars[i] is a lowercase English letter, uppercase English letter, digit, or 
//symbol. 
// 
//
// 👍 3133 👎 5209


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compress(char[] chars) {
        Deque<int[]> prev = new LinkedList<>();
        int[] jumps = new int[chars.length];
        Arrays.fill(jumps, -1);

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            int[] update = getCounter(prev, current);
            updateInput(update, chars, jumps);
            prev.add(new int[]{current, i, 1});
        }
        if (!prev.isEmpty()) {
            char forceUpdate = (char) ((int) chars[chars.length - 1] + 1);
            updateInput(getCounter(prev, forceUpdate), chars, jumps);
        }
        int len = 0;
        int i = 0;
        int charsIdx = 0;
        while (i < jumps.length) {
            len++;
            chars[charsIdx] = chars[i];
            if (jumps[i] != -1) {
                i = jumps[i];
            } else {
                i++;
            }
            charsIdx++;
        }
        return len;
    }

    private void updateInput(int[] update, char[] chars, int[] jumps) {
        int counter = update[2];
        if (counter > 1) {
            String counterStr = String.valueOf(counter);
            int idx = update[1] + 1;
            for (int i = 0; i < counterStr.length(); i++) {
                chars[idx] = counterStr.charAt(i);
                idx++;
            }
            jumps[idx - 1] = update[1] + counter;
        }
    }

    private int[] getCounter(Deque<int[]> prev, char current) {
        int[] update = new int[]{
                -1, -1, 1
        };
        int counter = 0;
        if (!prev.isEmpty() && current != (char) prev.peek()[0]) {
            counter = prev.size();
            update = prev.pollFirst();
            update[2] = counter;
            prev.clear();
        }
        return update;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class StringCompression extends Solution {
}