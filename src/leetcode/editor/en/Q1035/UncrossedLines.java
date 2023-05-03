package leetcode.editor.en.Q1035;

import java.util.*;

import javafx.util.Pair;

//You are given two integer arrays nums1 and nums2. We write the integers of 
//nums1 and nums2 (in the order they are given) on two separate horizontal lines. 
//
// We may draw connecting lines: a straight line connecting two numbers nums1[i]
// and nums2[j] such that: 
//
// 
// nums1[i] == nums2[j], and 
// the line we draw does not intersect any other connecting (non-horizontal) 
//line. 
// 
//
// Note that a connecting line cannot intersect even at the endpoints (i.e., 
//each number can only belong to one connecting line). 
//
// Return the maximum number of connecting lines we can draw in this way. 
//
// 
// Example 1: 
// 
// 
//Input: nums1 = [1,4,2], nums2 = [1,2,4]
//Output: 2
//Explanation: We can draw 2 uncrossed lines as in the diagram.
//We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[
//2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 500 
// 1 <= nums1[i], nums2[j] <= 2000 
// 
//
// 👍 2047 👎 29


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        cache = new Integer[nums1.length][nums2.length];
        HashMap<Integer, TreeSet<Integer>> nums1Map = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> nums2Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Map.computeIfAbsent(nums1[i], (v) -> new TreeSet<>()).add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.computeIfAbsent(nums2[i], (v) -> new TreeSet<>()).add(i);
        }

        return maxUncrossedLinesHelper(0, 0, nums1, nums2, nums1Map, nums2Map);
    }

    private int maxUncrossedLinesHelper(
            int i,
            int j,
            int[] nums1,
            int[] nums2,
            HashMap<Integer, TreeSet<Integer>> nums1Map,
            HashMap<Integer, TreeSet<Integer>> nums2Map) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        int num1 = nums1[i];
        int num2 = nums2[j];

        int useNum1 = 0;
        int useNum2 = 0;
        if (nums2Map.containsKey(num1)) {
            Integer nextIndex = nums2Map.get(num1).ceiling(j);
            if (nextIndex != null) {
                useNum1 = 1 + maxUncrossedLinesHelper(i + 1, nextIndex + 1, nums1, nums2, nums1Map, nums2Map);
            }
        }

        if (nums1Map.containsKey(num2)) {
            Integer nextIndex = nums1Map.get(num2).ceiling(i);
            if (nextIndex != null) {
                useNum2 = 1 + maxUncrossedLinesHelper(nextIndex + 1, j + 1, nums1, nums2, nums1Map, nums2Map);
            }
        }
        int skip1 = maxUncrossedLinesHelper(i + 1, j, nums1, nums2, nums1Map, nums2Map);
        int skip2 = maxUncrossedLinesHelper(i, j + 1, nums1, nums2, nums1Map, nums2Map);
        int ans = Math.max(useNum1, useNum2);
        ans = Math.max(ans, skip1);
        ans = Math.max(ans, skip2);
        cache[i][j] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class UncrossedLines extends Solution {
}