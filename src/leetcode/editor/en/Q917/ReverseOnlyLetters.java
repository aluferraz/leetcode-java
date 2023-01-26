package leetcode.editor.en.Q917;

import java.util.*;

import javafx.util.Pair;

//Given a string s, reverse the string according to the following rules: 
//
// 
// All the characters that are not English letters remain in the same position. 
//
// All the English letters (lowercase or uppercase) should be reversed. 
// 
//
// Return s after reversing it. 
//
// 
// Example 1: 
// Input: s = "ab-cd"
//Output: "dc-ba"
// 
// Example 2: 
// Input: s = "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
// 
// Example 3: 
// Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of characters with ASCII values in the range [33, 122]. 
// s does not contain '\"' or '\\'. 
// 
//
// 👍 1734 👎 59


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] stringAsArray = s.toCharArray();
        while (left < right) {
            if (isLetter(stringAsArray[left]) && isLetter(stringAsArray[right])) {
                swap(left, right, stringAsArray);
                right--;
                left++;
                continue;
            }
            while (!isLetter(stringAsArray[left]) && left < right) {
                left++;
            }
            while (!isLetter(stringAsArray[right]) && left < right) {
                right--;
            }
        }
        return String.valueOf(stringAsArray);
    }


    private void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isLetter(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ReverseOnlyLetters extends Solution {
}