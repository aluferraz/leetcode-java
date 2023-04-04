package leetcode.editor.en.Q632;

import java.util.*;

import javafx.util.Pair;

//You have k lists of sorted integers in non-decreasing order. Find the 
//smallest range that includes at least one number from each of the k lists. 
//
// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or 
//a < c if b - a == d - c. 
//
// 
// Example 1: 
//
// 
//Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
//Output: [20,24]
//Explanation: 
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].
// 
//
// Example 2: 
//
// 
//Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
//Output: [1,1]
// 
//
// 
// Constraints: 
//
// 
// nums.length == k 
// 1 <= k <= 3500 
// 1 <= nums[i].length <= 50 
// -10⁵ <= nums[i][j] <= 10⁵ 
// nums[i] is sorted in non-decreasing order. 
// 
//
// 👍 2918 👎 50


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        LinkedList<int[]> pq = new LinkedList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                pq.add(new int[]{num, i});
            }
        }
        Collections.sort(pq, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int k = nums.size();
        HashMap<Integer, Integer> listsInRange = new HashMap<>();
        Deque<int[]> range = new LinkedList<>();

        int[] res = new int[]{0, Integer.MAX_VALUE};

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int num = info[0];
            int list = info[1];
            range.add(new int[]{num, list});
            listsInRange.put(list, listsInRange.getOrDefault(list, 0) + 1);

            if (listsInRange.size() == k) {
                int[] endInfo = range.peekLast();
                int[] startInfo = range.peekFirst();
                int startingList = startInfo[1];
                while (listsInRange.get(startingList) > 1) {
                    range.pollFirst();
                    listsInRange.put(startingList, listsInRange.get(startingList) - 1);
                    if (listsInRange.get(startingList) == 0) listsInRange.remove(startingList);
                    startInfo = range.peekFirst();
                    startingList = startInfo[1];
                }
                int[] compare = new int[]{startInfo[0], endInfo[0]};
                if(res[1] - res[0] > compare[1] - compare[0]){
                    res = compare;
                }
            }


        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class SmallestRangeCoveringElementsFromKLists extends Solution {
}