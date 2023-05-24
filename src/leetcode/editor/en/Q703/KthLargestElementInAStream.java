package leetcode.editor.en.Q703;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {

    LinkedList<Integer> nums;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        this.nums = new LinkedList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            this.nums.addFirst(pq.poll());
        }

    }


    public int add(int val) {
        int indexToInsert = binarySearch(val);
        if (indexToInsert < this.nums.size()) {
            this.nums.add(indexToInsert, val);
        } else {
            this.nums.add(val);
        }
        if (this.nums.size() > k) this.nums.pollFirst();
        int ans = this.nums.get(this.nums.size() - k);
        return ans;
    }

    private int binarySearch(int target) {
        int left = 0;
        int right = this.nums.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (this.nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)


public class KthLargestElementInAStream extends KthLargest {

    public KthLargestElementInAStream(int k, int[] nums) {
        super(k, nums);
    }
}