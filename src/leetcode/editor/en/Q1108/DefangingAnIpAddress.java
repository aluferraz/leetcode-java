package leetcode.editor.en.Q1108;

import java.util.*;

import javafx.util.Pair;

//Given a valid (IPv4) IP address, return a defanged version of that IP address.
// 
//
// A defanged IP address replaces every period "." with "[.]". 
//
// 
// Example 1: 
// Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"
// 
// Example 2: 
// Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"
// 
// 
// Constraints: 
//
// 
// The given address is a valid IPv4 address. 
// 
//
// 👍 1511 👎 1627


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class DefangingAnIpAddress extends Solution {
}