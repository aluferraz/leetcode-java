package leetcode.editor.en.Q350;

import java.util.*;

//Given two integer arrays nums1 and nums2, return an array of their 
//intersection. Each element in the result must appear as many times as it shows in both 
//arrays and you may return the result in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your 
//algorithm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is 
//better? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
//
// 👍 5855 👎 814


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] seen1 = new int[1001];

        for (int num : nums1) {
            seen1[num]++;
        }
        int[] result = new int[1001];
        int pos = 0;
        for (int num : nums2) {
            if (seen1[num] > 0) {
                result[pos++] = num;
                seen1[num]--;
            }
        }
        int[] res = new int[pos];
        System.arraycopy(result, 0, res, 0, pos);
        return res;

    }


    public int[] intersectCorrect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> seen1 = new HashMap<>();
        HashMap<Integer, Integer> seen2 = new HashMap<>();
        for (int num : nums1) {
            seen1.put(num, seen1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            seen2.put(num, seen2.getOrDefault(num, 0) + 1);
        }
        if (seen1.size() <= seen2.size()) {
            return intersection(seen1, seen2);
        } else {
            return intersection(seen2, seen1);
        }


    }

    private int[] intersection(HashMap<Integer, Integer> seen1, HashMap<Integer, Integer> seen2) {
        ArrayList<Integer> result = new ArrayList<>();


        for (Map.Entry<Integer, Integer> entry : seen1.entrySet()) {
            int key = entry.getKey();
            if (seen2.containsKey(key)) {
                int both = Math.min(entry.getValue(), seen2.get(key));
                for (int i = 0; i < both; i++) {
                    result.add(key);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class IntersectionOfTwoArraysIi extends Solution {
}