package leetcode.editor.en.Q376;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int LESSER = 0;
    private static final int GREATER = 1;

    private Integer[][] cache;

    public int wiggleMaxLength(int[] nums) {
        int[] NGE = nextGreaterElement(nums);
        int[] NLE = nextLesserElement(nums);
        cache = new Integer[nums.length][2];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(wiggleMaxLength(i, GREATER, NGE, NLE), ans);
            ans = Math.max(wiggleMaxLength(i, LESSER, NGE, NLE), ans);
        }
        return ans;

    }

    private int wiggleMaxLength(int i, int direction, int[] NGE, int[] NLE) {
        if (i == NGE.length) {
            return 0;
        }
        if (cache[i][direction] != null) {
            return cache[i][direction];
        }

        int ans = 0;
        int greaterDir = 0;
        int lesserDir = 0;
        if (direction == GREATER) {
            greaterDir = 1 + wiggleMaxLength(NGE[i], LESSER, NGE, NLE);
            ans = greaterDir;
        } else {
            lesserDir = 1 + wiggleMaxLength(NLE[i], GREATER, NGE, NLE);
            ans = lesserDir;
        }
        cache[i][direction] = ans;
        return ans;
    }


    private int[] nextGreaterElement(int[] nums) {
        int[] NGE = new int[nums.length];
        Arrays.fill(NGE, nums.length);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                NGE[stack.pop()] = i;
            }
            stack.add(i);
        }
        return NGE;
    }

    private int[] nextLesserElement(int[] nums) {
        int[] NLE = new int[nums.length];
        Arrays.fill(NLE, nums.length);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekLast()]) {
                NLE[stack.pop()] = i;
            }
            stack.add(i);
        }
        return NLE;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class WiggleSubsequence extends Solution {
}