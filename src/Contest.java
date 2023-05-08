
import javafx.util.Pair;

import java.util.*;


class Solution {

    TreeSet<Integer> indexes = new TreeSet<>();

    public int[] colorTheArray(int n, int[][] queries) {
//        TreeMap<Integer, TreeSet<Integer>> timeline = new TreeMap<>();


        int[] values = new int[n];
        int[] jumps = new int[n];
        Arrays.fill(jumps, -1);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
//            if (values[index] != 0) {
//                timeline.get(values[index]).remove(index);
//            }
            values[index] = value;
            jumps[index] = index;
            if (index + 1 < n && values[index + 1] == value) {
                jumps[index + 1] = Math.min(index, jumps[index + 1]);
                jumps[index] = Math.min(index, jumps[index + 1]);
            }
            if (index > 0 && values[index - 1] == value) {
                jumps[index] = Math.min(jumps[index - 1], index);
            }


            indexes.add(index);
            ans[i] = count(jumps, values);
        }


        return ans;

    }

    private int count(int[] jumps, int[] values) {

        int ans = 0;
        int i = 0;
        while (i >= 0) {
            int value = values[i];
            int start = jumps[i];
            while (jumps[start] != start && values[start] == value) {
                start = jumps[start];
            }
            if (start != i) {
                ans += i - start;
            }
            i = start - 1;
        }
        return ans;
    }


}

public class Contest extends Solution {
}
/**
 * class Node {
 * <p>
 * public Node next = null;
 * int val;
 * <p>
 * Node(int val) {
 * this.val = val;
 * }
 * <p>
 * Node(int val, Node next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 * <p>
 * class CustomLL {
 * <p>
 * Node head;
 * Node tail;
 * <p>
 * int this.
 * <p>
 * public void add(){
 * <p>
 * }
 * <p>
 * }
 */