package leetcode.editor.en.Q705;

import java.util.*;

import javafx.util.Pair;

//Design a HashSet without using any built-in hash table libraries. 
//
// Implement MyHashSet class: 
//
// 
// void add(key) Inserts the value key into the HashSet. 
// bool contains(key) Returns whether the value key exists in the HashSet or 
//not. 
// void remove(key) Removes the value key in the HashSet. If key does not exist 
//in the HashSet, do nothing. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed) 
//
// 
// Constraints: 
//
// 
// 0 <= key <= 10⁶ 
// At most 10⁴ calls will be made to add, remove, and contains. 
// 
//
// 👍 2651 👎 238


//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {
    private int[] set;

    public MyHashSet() {
        this.set = new int[10000000];
    }

    public void add(int key) {
        set[key] = 1;
    }

    public void remove(int key) {
        set[key] = 0;
    }

    public boolean contains(int key) {
        return set[key] != 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)


public class DesignHashset extends MyHashSet {
}