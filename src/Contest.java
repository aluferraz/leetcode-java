
import java.util.*;

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        LinkedList<Integer> sliding = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIdx = 0;
        for (int num : nums) {
            sliding.add(num);
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            if (sliding.size() == k) {
                int toRemove = sliding.pollFirst();
                int index = 0;
                for (Map.Entry<Integer, Integer> kv : numbers.entrySet()) {
                    index += kv.getValue();
                    if (index >= x) {
                        int value = kv.getKey();
                        if (value < 0) ans[ansIdx++] = value;
                        else ansIdx++;
                        break;
                    }
                }
                int total = numbers.get(toRemove);
                total--;
                if (total == 0) numbers.remove(toRemove);
                else numbers.put(toRemove, total);
            }
        }
        return ans;
    }


}

public class Contest extends Solution {
}
