package leetcode.editor.en.Q904;
import java.util.*;
import javafx.util.Pair;

//You are visiting a farm that has a single row of fruit trees arranged from 
//left to right. The trees are represented by an integer array fruits where fruits[i]
// is the type of fruit the iᵗʰ tree produces. 
//
// You want to collect as much fruit as possible. However, the owner has some 
//strict rules that you must follow: 
//
// 
// You only have two baskets, and each basket can only hold a single type of 
//fruit. There is no limit on the amount of fruit each basket can hold. 
// Starting from any tree of your choice, you must pick exactly one fruit from 
//every tree (including the start tree) while moving to the right. The picked 
//fruits must fit in one of your baskets. 
// Once you reach a tree with fruit that cannot fit in your baskets, you must 
//stop. 
// 
//
// Given the integer array fruits, return the maximum number of fruits you can 
//pick. 
//
// 
// Example 1: 
//
// 
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.
// 
//
// Example 2: 
//
// 
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].
//If we had started at the first tree, we would only pick from trees [0,1].
// 
//
// Example 3: 
//
// 
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].
//If we had started at the first tree, we would only pick from trees [1,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// 👍 2040 👎 153


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < fruits.length){
            counter.put(fruits[right], counter.getOrDefault(fruits[right],0) + 1);
            while (counter.keySet().size() > 2){
                counter.put(fruits[left], counter.get(fruits[left]) - 1);
                if(counter.get(fruits[left]) == 0){
                    counter.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, counter.values().stream().mapToInt(Integer::intValue).sum());
            right++;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class FruitIntoBaskets extends Solution {}