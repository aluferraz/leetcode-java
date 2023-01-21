package leetcode.editor.en.Q491;

import java.util.*;

import javafx.util.Pair;

//Given an integer array nums, return all the different possible non-decreasing 
//subsequences of the given array with at least two elements. You may return the 
//answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,6,7,7]
//Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// Example 2: 
//
// 
//Input: nums = [4,4,3,2,1]
//Output: [[4,4]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// 👍 2354 👎 180


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        findSubSequences(0, Integer.MIN_VALUE, nums, new ArrayList<>(), res);
        return res;
    }

    private void findSubSequences(int i,
                                  int prev,
                                  int[] nums,
                                  ArrayList<Integer> running,
                                  ArrayList<List<Integer>> res) {
        if (i >= nums.length) {
            if (running.size() >= 2) {
                res.add(new ArrayList<>(running));
            }
            return;
        }
        if (prev <= nums[i]) {
            running.add(nums[i]);
            findSubSequences(i + 1, nums[i], nums, running, res);
            running.remove(running.size() - 1);
        }
        if (nums[i] != prev)
            findSubSequences(i + 1, prev, nums, running, res);
    }
    //Interactive - My Answer
//    public List<List<Integer>> findSubsequences(int[] nums) {
//
//        List<List<Integer>> resAux = new LinkedList<>();
//
//        if (nums.length < 2) return resAux;
//        List<List<Integer>> res = new LinkedList<>();
//
//        for (int num : nums) {
//            int size = resAux.size();
//            for (int j = 0; j < size; j++) {
//                List<Integer> prev = resAux.get(j);
//                if (prev.get(prev.size() - 1) <= num) {
//                    ArrayList<Integer> current = new ArrayList<>(prev);
//                    current.add(num);
//                    resAux.add(current);
//                }
//            }
//            resAux.add(new ArrayList<>(List.of(num)));
//        }
//
//        HashSet<List<Integer>> seen = new HashSet<>();
//
//        for (List<Integer> cur : resAux) {
//            if (cur.size() > 1) {
//                if (!seen.contains(cur)) {
//                    res.add(cur);
//                    seen.add(cur);
//                }
//            }
//        }
//        return res;
//    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class NonDecreasingSubsequences extends Solution {
}