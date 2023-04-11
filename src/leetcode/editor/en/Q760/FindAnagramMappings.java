package leetcode.editor.en.Q760;

import java.util.*;

import javafx.util.Pair;

//You are given two integer arrays nums1 and nums2 where nums2 is an anagram of 
//nums1. Both arrays may contain duplicates. 
//
// Return an index mapping array mapping from nums1 to nums2 where mapping[i] = 
//j means the iᵗʰ element in nums1 appears in nums2 at index j. If there are 
//multiple answers, return any of them. 
//
// An array a is an anagram of an array b means b is made by randomizing the 
//order of the elements in a. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
//Output: [1,4,3,2,0]
//Explanation: As mapping[0] = 1 because the 0ᵗʰ element of nums1 appears at 
//nums2[1], and mapping[1] = 4 because the 1ˢᵗ element of nums1 appears at nums2[4], 
//and so on.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [84,46], nums2 = [84,46]
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= 100 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁵ 
// nums2 is an anagram of nums1. 
// 
//
// 👍 560 👎 216


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i], (v) -> new LinkedList<>()).add(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]).pollFirst();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindAnagramMappings extends Solution {
}