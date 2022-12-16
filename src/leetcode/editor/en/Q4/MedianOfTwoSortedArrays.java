package leetcode.editor.en.Q4;

import java.util.*;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// 👍 21094 👎 2379


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //https://www.youtube.com/watch?v=q6IEA26hvXc
        if (nums1.length == 0 && nums2.length == 0) return 0;
        int leftPartitionSize = (int) Math.ceil((nums1.length + nums2.length) / 2.0);
        int[] shortest = nums1;
        int[] longest = nums2;
        if (nums2.length < shortest.length) {
            shortest = nums2;
            longest = nums1;
        }
        int left = 0;
        int right = shortest.length - 1;
        int direction = 1;
        int mid = 0;
        while (direction != 0) {
            mid = Math.floorDiv((left + right), 2);
            direction = getDirection(shortest, longest, mid, leftPartitionSize);
            switch (direction) {
                case -1:
                    right = mid - 1;
                    break;
                case 1:
                    left = mid + 1;
                    break;
            }
        }
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        if (!isEven) return Math.max(getVal(shortest, mid), getVal(longest, leftPartitionSize - mid - 2));

        return (Math.max(getVal(shortest, mid), getVal(longest, leftPartitionSize - mid - 2)) +
                Math.min(getVal(shortest, mid + 1), getVal(longest, (leftPartitionSize - mid - 1)))) / 2.0;

    }

    private int getDirection(int[] shortest, int[] longest, int mid, int leftPartitionSize) {
        //The left partition size must be X, we are taking ,MID elements from the shortest, so the
        //longest rightmost element must be X-MID.

        int longestArrayIdx = leftPartitionSize - mid - 2;
        if (!(getVal(shortest, mid) <= getVal(longest, longestArrayIdx + 1))) {
            return -1; // Explore left
        }
        if (!(getVal(longest, longestArrayIdx) <= getVal(shortest, mid + 1))) {
            return 1;
        }
        return 0;
    }

    private int getVal(int[] array, int i) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= array.length) return Integer.MAX_VALUE;
        return array[i];
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 && nums2.length == 0) return 0;
//        int medianIdx = Math.floorDiv(nums1.length + nums2.length, 2) + 1;
//
//        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
//
//        int idx1 = 0;
//        int idx2 = 0;
//        Integer last = null;
//        Integer beforeLast = null;
//
//        while (idx1 < nums1.length && idx2 < nums2.length && (idx1 + idx2 < medianIdx)) {
//            beforeLast = last;
//            if (nums1[idx1] < nums2[idx2]) {
//                last = nums1[idx1];
//                idx1++;
//            } else {
//                last = nums2[idx2];
//                idx2++;
//            }
//
//
//        }
//        while (idx1 < nums1.length && (idx1 + idx2 < medianIdx)) {
//            beforeLast = last;
//            last = nums1[idx1];
//            idx1++;
//        }
//        while (idx2 < nums2.length && (idx1 + idx2 < medianIdx)) {
//            beforeLast = last;
//            last = nums2[idx2];
//            idx2++;
//        }
//        if (isEven) return (beforeLast + last) / 2.0;
//        return last;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MedianOfTwoSortedArrays extends Solution {
}