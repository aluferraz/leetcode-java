package leetcode.editor.en.Q93;

import java.util.*;

import javafx.util.Pair;

//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// s consists of digits only. 
// 
//
// 👍 3889 👎 701


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        return restoreIpAddresses(0, new Stack<>(), s, res);
    }

    public List<String> restoreIpAddresses(int start, Stack<String> ip, String s, List<String> res) {
        if (start == s.length()) {
            if (ip.size() == 4)
                res.add(String.join(".", ip));
            return res;
        }
        if (ip.size() == 4) {
            //Cant add more slots
            return res;
        }
        //Cant have leading 0, but can have a 0 alone
        if (s.charAt(start) == '0') {
            ip.push("0");
            restoreIpAddresses(start + 1, ip, s, res);
            ip.pop();
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int pos = start;
        while (pos < s.length()) {
            sb.append(s.charAt(pos));
            if (Integer.parseInt(sb.toString()) > 255) break;
            ip.push(sb.toString());
            restoreIpAddresses(pos + 1, ip, s, res);
            ip.pop();
            pos++;


        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RestoreIpAddresses extends Solution {
}