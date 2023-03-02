package leetcode.editor.en.Q912;

import java.util.*;

import javafx.util.Pair;

import javax.swing.plaf.LabelUI;

//Given an array of integers nums, sort the array in ascending order and return 
//it. 
//
// You must solve the problem without using any built-in functions in O(nlog(n))
// time complexity and with the smallest space complexity possible. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
//Explanation: After sorting the array, the positions of some numbers are not 
//changed (for example, 2 and 3), while the positions of other numbers are changed (
//for example, 1 and 5).
// 
//
// Example 2: 
//
// 
//Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
//Explanation: Note that the values of nums are not necessairly unique.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// 👍 3762 👎 641


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        // I you must use HEAPSORT to be O(1) space.
        mergeSort(nums, Arrays.copyOf(nums, nums.length), 0, nums.length - 1);
        return nums;
    }


    private void mergeSort(int[] main, int[] aux, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = Math.floorDiv(start + end, 2);
        mergeSort(aux, main, start, mid);
        mergeSort(aux, main, mid + 1, end);
        merge(main, aux, start, end);
    }

    private void merge(int[] main, int[] aux, int start, int end) {
        int mid = Math.floorDiv(start + end, 2);
        int p1 = start;
        int p2 = mid + 1;
        int i = start;
        while (p1 <= mid && p2 <= end) {
            if (aux[p1] <= aux[p2]) {
                main[i] = aux[p1];
                p1++;
            } else {
                main[i] = aux[p2];
                p2++;
            }
            i++;
        }

        while (p1 <= mid) {
            main[i] = aux[p1];
            i++;
            p1++;
        }
        while (p2 <= end) {
            main[i] = aux[p2];
            i++;
            p2++;
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

//    private void quicksort(int[] nums, int start, int end) {
//        if (start >= end) return;
//        int pivotIdx = start;
//        int left = start + 1;
//        int right = end;
//        int pivot = nums[pivotIdx];
//        while (right >= left) {
//            if (nums[left] > pivot && nums[right] < pivot) {
//                swap(left, right, nums);
//            }
//            if (nums[left] <= pivot) {
//                left++;
//            }
//            if (nums[right] >= pivot) {
//                right--;
//            }
//        }
//        swap(pivotIdx, right, nums);
//        //Always on the smallest array first, to use tail recursion and stay on O(log(N)) space
//        boolean leftIsSmaller = (right - 1 - start) < (end - right + 1);
//        if (leftIsSmaller) {
//            quicksort(nums, start, right - 1);
//            quicksort(nums, right + 1, end);
//        } else {
//            quicksort(nums, right + 1, end);
//            quicksort(nums, start, right - 1);
//        }
//    }

public class SortAnArray extends Solution {
}