package leetcode.editor.en.Q1704;
import java.util.*;

//You are given a string s of even length. Split this string into two halves of 
//equal lengths, and let a be the first half and b be the second half. 
//
// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 
//'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and 
//lowercase letters. 
//
// Return true if a and b are alike. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: s = "book"
//Output: true
//Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. 
//Therefore, they are alike.
// 
//
// Example 2: 
//
// 
//Input: s = "textbook"
//Output: false
//Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. 
//Therefore, they are not alike.
//Notice that the vowel o is counted twice.
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 1000 
// s.length is even. 
// s consists of uppercase and lowercase letters. 
// 
//
// 👍 991 👎 61


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashSet<Character> vowels = new HashSet<>();

    public Solution(){
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public boolean halvesAreAlike(String s) {
        int vowelsLeft = 0;
        int vowelsRight = 0;
        int left = 0;
        int right = s.length() -1;
        while (left < right){
            if(vowels.contains(s.charAt(left))) vowelsLeft++;
            if(vowels.contains(s.charAt(right))) vowelsRight++;

            left++;
            right--;
        }
        return vowelsLeft == vowelsRight;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class DetermineIfStringHalvesAreAlike extends Solution {}