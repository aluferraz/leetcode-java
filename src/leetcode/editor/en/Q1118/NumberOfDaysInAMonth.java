package leetcode.editor.en.Q1118;

import java.util.*;

import javafx.util.Pair;

//Given a year year and a month month, return the number of days of that month. 
//
//
// 
// Example 1: 
// Input: year = 1992, month = 7
//Output: 31
// 
// Example 2: 
// Input: year = 2000, month = 2
//Output: 29
// 
// Example 3: 
// Input: year = 1900, month = 2
//Output: 28
// 
// 
// Constraints: 
//
// 
// 1583 <= year <= 2100 
// 1 <= month <= 12 
// 
//
// 👍 35 👎 153


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfDays(int year, int month) {
        int leapYear = 0;
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) leapYear++;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return 28 + leapYear;
            default:
                return 30;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfDaysInAMonth extends Solution {
}