package leetcode.editor.en.Q254;

import java.util.*;

//Numbers can be regarded as the product of their factors. 
//
// 
// For example, 8 = 2 x 2 x 2 = 2 x 4. 
// 
//
// Given an integer n, return all possible combinations of its factors. You may 
//return the answer in any order. 
//
// Note that the factors should be in the range [2, n - 1]. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: []
// 
//
// Example 2: 
//
// 
//Input: n = 12
//Output: [[2,6],[3,4],[2,2,3]]
// 
//
// Example 3: 
//
// 
//Input: n = 37
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁷ 
// 
//
// 👍 1010 👎 59


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new Stack<>();

    public List<List<Integer>> getFactors(int n) {
        getFactorsRec(2, n, new Stack<>());
        return ans;
    }

    private void getFactorsRec(int start, int n, Stack<Integer> path) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                path.push(i);
                path.push((n / i));
                ans.add(new ArrayList<>(path));
                getFactorsRec(i, path.pop(), path);
                path.pop();
            }
        }
    }

//    HashMap<Integer, List<List<Integer>>> cache = new HashMap<>();
//
//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> result = getFactorsRecursive(n);
//        HashSet<List<Integer>> seen = new HashSet<>();
//        for (int k = 0; k < result.size(); k++) {
//            List<Integer> factor = result.get(k);
//            seen.add(factor);
//            for (int i = 0; i < factor.size(); i++) {
//                int number = factor.get(i);
//                List<List<Integer>> subFactors = getFactorsRecursive(number);
//                for (int j = 0; j < subFactors.size(); j++) {
//                    LinkedList<Integer> newFactors = new LinkedList<>();
//                    newFactors.addAll(factor);
//                    newFactors.remove(i);
//                    newFactors.addAll(subFactors.get(j));
//                    newFactors.sort(Integer::compareTo);
//                    if (!seen.contains(newFactors)) {
//                        result.add(newFactors);
//                        seen.add(newFactors);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//
//    private List<List<Integer>> getFactorsRecursive(int n) {
//        if (n <= 2) return new ArrayList<>();
//        if (cache.containsKey(n)) return cache.get(n);
//        List<Integer> factors;
//        List<List<Integer>> result = new LinkedList<>();
//        for (int i = n - 1; i >= 2; i--) {
//            if ((n / i) > i) break; //12 / 6 = 2; 12/2 = 6
//            if (n % i == 0) {
//                factors = Arrays.asList((n / i), i);
//                result.add(factors);
//            }
//        }
//        cache.put(n, result);
//        return result;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FactorCombinations extends Solution {
}