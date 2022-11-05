package leetcode.editor.en.Q345;

//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//lower and upper cases, more than once. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// 
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
//
// 👍 2554 👎 2177


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        HashSet<Character> vowels = new HashSet<Character>();
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
        char[] sAsArray = s.toCharArray();

        while (left < right) {
            while (!vowels.contains(sAsArray[left]) && left < right) left++;
            while (!vowels.contains(sAsArray[right]) && left < right) right--;
            swap(left, right, sAsArray);
            left++;
            right--;
        }
        return String.valueOf(sAsArray);
    }

    private void swap(int i, int j, char[] s) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
