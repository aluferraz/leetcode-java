package leetcode.editor.en.Q2591;

//You are given an integer money denoting the amount of money (in dollars) that
//you have and another integer children denoting the number of children that you 
//must distribute the money to. 
//
// You have to distribute the money according to the following rules: 
//
// 
// All money must be distributed. 
// Everyone must receive at least 1 dollar. 
// Nobody receives 4 dollars. 
// 
//
// Return the maximum number of children who may receive exactly 8 dollars if 
//you distribute the money according to the aforementioned rules. If there is no 
//way to distribute the money, return -1. 
//
// 
// Example 1: 
//
// 
//Input: money = 20, children = 3
//Output: 1
//Explanation: 
//The maximum number of children with 8 dollars will be 1. One of the ways to 
//distribute the money is:
//- 8 dollars to the first child.
//- 9 dollars to the second child. 
//- 3 dollars to the third child.
//It can be proven that no distribution exists such that number of children 
//getting 8 dollars is greater than 1.
// 
//
// Example 2: 
//
// 
//Input: money = 16, children = 2
//Output: 2
//Explanation: Each child can be given 8 dollars.
// 
//
// 
// Constraints: 
//
// 
// 1 <= money <= 200 
// 2 <= children <= 30 
// 
//
// 👍 119 👎 540


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int target = 7;
    int[] childrenMoney;

    public int distMoney(int money, int children) {
        if (money < children) return -1;
        money -= children; //Every child has one dollar now
        childrenMoney = new int[children];
        Arrays.fill(childrenMoney, 1);
        distMoneyHelper(money, children - 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == 4) {
                return -1;
            }
            if (a[0] == 8) {
                return 1;
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < childrenMoney.length; i++) {
            pq.add(new int[]{childrenMoney[i], i});
        }

        while (!pq.isEmpty() && pq.peek()[0] == 4) {
            int[] childWithFour = pq.poll();
            if (pq.isEmpty()) return -1;
            int[] next = pq.poll();
            next[0]++;
            childWithFour[0]--;
            childrenMoney[next[1]]++;
            childrenMoney[childWithFour[1]]--;
            pq.add(childWithFour);
            pq.add(next);
        }
        int res = 0;
        while (!pq.isEmpty()) {
            if (pq.poll()[0] == 8) res++;
        }
        return res;

    }

    public void distMoneyHelper(int money, int child) {
        if (child < 0) {
            return;
        }
        if (child == 0) {
            childrenMoney[child] += money;
            return;
        }
        if (money >= target) {
            childrenMoney[child] += target;
            distMoneyHelper(money - target, child - 1);
            return;
        } else {
            distMoneyHelper(money - 1, child - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class DistributeMoneyToMaximumChildren extends Solution {
}